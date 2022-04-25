package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classi.Carrello;
import dbConfig.*;


public class DaoCarrelloDatabase implements DaoCarrello {
	
	public Carrello creaNuovoCarrello() throws ClassNotFoundException, SQLException {
		int nuovoCodiceCarrello = 0;
		Carrello carrello;
		Connection connection = DBconnection.getInstance().getConn();
		String query = "SELECT last_value + 1 AS nextKey FROM carrello_codicecarrello_seq";
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			nuovoCodiceCarrello = rs.getInt("nextKey");
		}
		carrello = new Carrello(nuovoCodiceCarrello);
		return carrello;
	}
	
}
