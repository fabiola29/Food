package Dao;

import java.sql.*;
import java.util.ArrayList;

import Classi.Bicicletta;
import Classi.Moto;
import Classi.Veicolo;
import dbConfig.*;


public class DaoVeicoloDatabase implements DaoVeicolo{

	@Override
	public ArrayList<Veicolo> ottieniVeicoli(int codiceRider) throws SQLException, ClassNotFoundException{
		ArrayList<Veicolo> parcoVeicoli = new ArrayList<Veicolo>();
		String query = "SELECT tipoVeicolo, codiceSeriale, modello FROM veicolo AS V WHERE V.codiceRider = ?";
		Connection connection = DBconnection.getInstance().getConn();
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setInt(1, codiceRider);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String tipoVeicolo = rs.getString("tipoVeicolo");
			int codiceSeriale = rs.getInt("codiceSeriale");
			if(tipoVeicolo.equals("moto")) {
				parcoVeicoli.add(new Moto(codiceSeriale));
			}else {
				parcoVeicoli.add(new Bicicletta(codiceSeriale));
			}
		}
		return parcoVeicoli;
	}


}
