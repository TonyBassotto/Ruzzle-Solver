package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class daourl {
	private static daourl instance=null;
	static private final String url="jdbc:mysql://localhost/dizionario?user=root&password=";
	private daourl(){
		instance=null;
	}
	public static daourl getInstance() {
		if(instance == null)
			return new daourl() ;
		else {
			return instance ;
		}
	}
	
	public Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(url) ;
			return conn ;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore di connessione al database");
		}	
	}
}
