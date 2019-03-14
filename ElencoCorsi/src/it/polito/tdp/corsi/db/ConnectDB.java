package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	// Implementa il pattern Sigleton
	private final static String jdbcURL = "jdbc:mysql://localhost/iscritticorsi";
	private static Connection conn;

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(jdbcURL, "root", "root");
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("Errore di connessione al DB");
			throw new RuntimeException();
		}

		return conn;
	}
}
