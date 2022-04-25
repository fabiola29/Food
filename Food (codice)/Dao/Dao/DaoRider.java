package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Classi.Rider;

public interface DaoRider {
	public ArrayList<Rider> ottieniRider() throws SQLException, ClassNotFoundException;
}
