package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Classi.*;
import dbConfig.*;


public class DaoOrdineDatabase implements DaoOrdine {

	public boolean inserisciNuovoOrdine(Utente utente, Carrello carrello, Ristorante ristorante, Rider rider) {
		boolean insertSucced = false;	
		String query = "INSERT INTO ordine(email, codiceCarrello, codiceRistorante, codiceRider) VALUES( ?, ?, ?, ?)";
		try {
			Connection connection = DBconnection.getInstance().getConn();
			inserisciCarrello(carrello, connection);
			inserisciComposizioneCarrello(carrello, connection);
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, utente.getEmail());
			stmt.setInt(2, carrello.getCodiceCarrello());
			stmt.setInt(3, ristorante.getCodiceRistorante());
			stmt.setInt(4, rider.getCodiceRider());
			insertSucced = stmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return insertSucced;
	}
	
	private void inserisciCarrello(Carrello carrello, Connection connection) throws SQLException {
		String query = "INSERT INTO carrello(data) VALUES (CURRENT_DATE)";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.execute();
	}
	
	private void inserisciComposizioneCarrello(Carrello carrello, Connection connection) throws SQLException {
		String query = "INSERT INTO composizioneCarrello(codiceCarrello, codiceSeriale, quantita) VALUES(?, ?, ?)";
		for(Prodotto p : carrello.getQuantitaProdotto().keySet()) {
			PreparedStatement stmt = connection.prepareStatement(query);
			int quantita = carrello.getQuantitaProdotto().get(p);
			stmt.setInt(1, carrello.getCodiceCarrello());
			stmt.setInt(2, p.getCodiceSeriale());
			stmt.setInt(3, quantita);
			stmt.execute();
		}
		
	}
	
}
