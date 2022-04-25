package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Classi.Rider;
import Classi.Veicolo;
import dbConfig.*;


public class DaoRiderDatabase implements DaoRider{

	public ArrayList<Rider> ottieniRider() throws SQLException, ClassNotFoundException{
		ArrayList<Rider> riders = new ArrayList<Rider>();
		String query = "SELECT * FROM rider";
		Connection connection = DBconnection.getInstance().getConn();
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			String biografia = rs.getString("biografia");
			String pathFoto = rs.getString("pathFoto");
			int codiceRider = rs.getInt("codiceRider");
			DaoVeicolo dv = new DaoVeicoloDatabase();
			ArrayList<Veicolo> parcoVeicoli = dv.ottieniVeicoli(codiceRider);
			riders.add(new Rider(nome, cognome, biografia, pathFoto, codiceRider, parcoVeicoli));
		}
		return riders;
	}
	
}
