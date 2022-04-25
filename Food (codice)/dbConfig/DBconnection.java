
package dbConfig;

import java.sql.*;

public class DBconnection {
	
	private static DBconnection instance;
	private Connection conn;
	
	private DBconnection()throws SQLException,ClassNotFoundException
	{
		// TODO : cambia l'url a localhost
		Class.forName("org.postgresql.Driver");
		String url="jdbc:postgresql://localhost/Food";
		String user = "postgres";
		String password = "Fabiola29";
		conn = DriverManager.getConnection(url, user, password);
		System.out.println("connesione al database effettuata con successo");
		String query = "SET search_path TO food";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.execute();
		System.out.println("Search path impostato con successo");
	}

	public Connection getConn() {
		return conn;
	}

	public static DBconnection getInstance() throws SQLException,ClassNotFoundException{
		if(instance==null)
		{
			instance=new DBconnection();
		}
		else if(instance.getConn().isClosed())
		{
			instance=new DBconnection();
		}
	
	return instance;
  }
}
	