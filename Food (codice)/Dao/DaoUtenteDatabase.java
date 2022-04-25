package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Classi.*;
import dbConfig.*;


public class DaoUtenteDatabase implements DaoUtente {

	// TODO : query per ottener un utente
	
	public boolean esisteUtente(String email){
		boolean userExist = false;
		String query = "SELECT * FROM utente AS U WHERE U.email=?";
		try {
			Connection connection = DBconnection.getInstance().getConn();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			userExist = rs.next();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userExist;
	}
	
	public boolean concediAccesso(String email, String password) {
		boolean validateAccess = false;
		try {
			Connection connection = DBconnection.getInstance().getConn();
			String query = "SELECT * FROM utente AS U WHERE U.email = ? AND U.password = ?";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			validateAccess = rs.next();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return validateAccess;
	}
	
	public boolean inserisciNuovoUtente(String nome, String cognome, String email, String password, 
			String numeroTelefono, int codiceIndirizzo) {
		boolean insertSucced = false;
		try {
			Connection connection = DBconnection.getInstance().getConn();
			String query = "INSERT INTO utente(nome, cognome, email, password, numeroTelefono, codiceIndirizzo) VALUES(?, ?, ?, ?, ?, ?)"; 
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, nome);
			stmt.setString(2, cognome);
			stmt.setString(3, email);
			stmt.setString(4, password);
			stmt.setString(5, numeroTelefono);
			stmt.setInt(6, codiceIndirizzo);
			stmt.execute();
			insertSucced = true;
		}catch(SQLException e) {
			System.out.println("impossibile effetturare l'inserimento");
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.out.println("impossibile trovare il driver jdbc per postgres");
			e.printStackTrace();
		}
		return insertSucced;
	}
	
	public Utente effettuaAccesso(String email, String password){
		Utente loggedUser = null;
		String query = "SELECT * FROM utente WHERE email=? AND password=?";
		DaoIndirizzo daoIndirizzo = new DaoIndirizzoDatabase();
		try {
			if(esisteUtente(email) && concediAccesso(email, password)) {
				Connection connection = DBconnection.getInstance().getConn();
				PreparedStatement stmt = connection.prepareStatement(query);
				stmt.setString(1, email);
				stmt.setString(2, password);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					String nome = rs.getString("nome");
					String cognome = rs.getString("cognome");
					// email e password li ho gia (in realta' in utente non si dovrebbe inserire il campo password)
					String numeroTelefono = rs.getString("numeroTelefono");
					int codiceIndirizzo = rs.getInt("codiceIndirizzo");
					Indirizzo indirizzo = daoIndirizzo.ottieniIndirizzo(codiceIndirizzo);
					loggedUser = new Utente(nome, cognome, email, password, numeroTelefono, indirizzo);
				}
				if(loggedUser == null) {
					System.out.println("cred errate");
				}
			}
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
			loggedUser = null;
		}
		return loggedUser;
	}
	
	public boolean cambiaPassword(String email, String newPassword) {
		boolean updateSucced = false;
		String query = "UPDATE utente SET password = ? WHERE email = ?";
		try {
			Connection connection = DBconnection.getInstance().getConn();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, newPassword);
			stmt.setString(2, email);
			updateSucced = stmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return updateSucced;
	}
	
	public boolean cambiaIndirizzo(String email, int newCodiceIndirizzo) {
		boolean updateSucced = false;
		String query = "UPDATE utente SET codiceIndirizzo = ? WHERE email = ?";
		try {
			Connection connection = DBconnection.getInstance().getConn();
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, newCodiceIndirizzo);
			stmt.setString(2, email);
			updateSucced = stmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return updateSucced;
	}
		

}
