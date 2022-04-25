package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Classi.Veicolo;

public interface DaoVeicolo {

	public ArrayList<Veicolo> ottieniVeicoli(int codiceRider) throws SQLException, ClassNotFoundException;
	
}
