package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import Classi.Bevanda;
import Classi.Cibo;
import Classi.Prodotto;
import Classi.Ristorante;
import dbConfig.*;


public class DaoRistoranteDatabase implements DaoRistorante {
	
	public ArrayList<Ristorante> ottieniRistoranti() throws SQLException, ClassNotFoundException{
		ArrayList<Ristorante> ristoranti = new ArrayList<Ristorante>();
		String query = "SELECT nome, codiceRistorante FROM ristorante ORDER BY codiceRistorante ASC";
		String queryProdotti = "SELECT P.codiceSeriale, P.nome, P.prezzo, P.pathFoto, P.tipoProdotto, P.categoria, P.scadenza, F.quantitaProdotto"
				+ " FROM fornitura AS F NATURAL JOIN prodotto AS P"
				+ " WHERE F.codiceRistorante = ?";
				
		Connection connection = DBconnection.getInstance().getConn();
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String nome = rs.getString("nome");
			int codiceRistorante = rs.getInt("codiceRistorante");
			ristoranti.add(new Ristorante(nome, codiceRistorante));
		}
		for(Ristorante r : ristoranti) {
			HashMap<Prodotto, Integer> prodottiInVendita = new HashMap<Prodotto, Integer>();
			PreparedStatement stmtProdotti = connection.prepareStatement(queryProdotti); 
			stmtProdotti.setInt(1, r.getCodiceRistorante());
			ResultSet rsProdotti = stmtProdotti.executeQuery();
			while(rsProdotti.next()) {
				int codiceSeriale = rsProdotti.getInt("codiceSeriale");
				String nomeProdotto = rsProdotti.getString("nome");
				double prezzoProdotto = rsProdotti.getDouble("prezzo");
				String pathFotoProdotto = rsProdotti.getString("pathFoto");
				String tipoProdotto = rsProdotti.getString("tipoProdotto");
				String categoriaProdotto = rsProdotti.getString("categoria");
				int quantitaProdotto = rsProdotti.getInt("quantitaProdotto");
				Date scadenza = rsProdotti.getDate("scadenza");
				java.util.Date conversione = new java.util.Date(scadenza.getTime());
				Prodotto prodotto;
				if(tipoProdotto.equals("cibo")) {
					prodotto = new Cibo(nomeProdotto, prezzoProdotto, codiceSeriale, pathFotoProdotto, categoriaProdotto, conversione);
				}else { // tipoProdotto.equals("bevanda")
					prodotto = new Bevanda(nomeProdotto, prezzoProdotto, codiceSeriale, pathFotoProdotto, categoriaProdotto, conversione);
				}			
				prodottiInVendita.put(prodotto, quantitaProdotto);
				r.setProdottiInVendita(prodottiInVendita);
			}
			
		}
		return ristoranti;
	}
	
	public boolean aggiornaForniture(int codiceRistorante, int codiceProdotto, int nuovaQuantita) {
		boolean updateSucced = false;
		String query = "UPDATE fornitura SET quantitaProdotto = ? WHERE codiceRistorante = ? AND codiceProdotto = ?";
		try {
			Connection connection = DBconnection.getInstance().getConn();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, nuovaQuantita);
			stmt.setInt(2, codiceRistorante);
			stmt.setInt(3, codiceProdotto);
			updateSucced = stmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return updateSucced;
	}

	@Override
	public Ristorante ottieniRistorante(int codiceRistorante) {
		Ristorante ristorante = null;
		return ristorante;
	}

	public HashMap<Integer, ArrayList<Integer>> ottieniAssociazioni() throws SQLException, ClassNotFoundException{
		HashMap<Integer, ArrayList<Integer>> associazioni = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> entry ;
		String query = "SELECT codiceRistorante, codiceRider FROM corrierePer";
		Connection connection = DBconnection.getInstance().getConn();
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		int codiceRistorante = -1;
		int codiceRider = -1;
		while(rs.next()) {
			codiceRistorante = rs.getInt("codiceRistorante");
			codiceRider = rs.getInt("codiceRider");
			if(!associazioni.containsKey(codiceRistorante)) {
				entry = new ArrayList<Integer>();
				entry.add(codiceRider);
				associazioni.put(codiceRistorante, entry);
			}else {
				entry = associazioni.get(codiceRistorante);
				entry.add(codiceRider);
			}
		}
		return associazioni;
	}
	
	public void aggiornaForniture(Ristorante ristorante, HashMap<Prodotto, Integer> prodottiDaAggiornare) throws ClassNotFoundException, SQLException {
		String query = "UPDATE fornitura SET quantitaProdotto = ? WHERE codiceRistorante = ? AND codiceSeriale = ?";
		Connection connection = DBconnection.getInstance().getConn();
		for(Prodotto p : prodottiDaAggiornare.keySet()) {
			PreparedStatement stmt = connection.prepareStatement(query);
			int nuovaQuantita = ristorante.getProdottiInVendita().get(p) - prodottiDaAggiornare.get(p);
			stmt.setInt(1, nuovaQuantita);
			stmt.setInt(2, ristorante.getCodiceRistorante());
			stmt.setInt(3, p.getCodiceSeriale());
			stmt.execute();
		}
	}

}
