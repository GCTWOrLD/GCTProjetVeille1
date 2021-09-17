package com.projetveille.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.h2.Driver;

public class ServiceConnection {

	static final String DRIVER_JDBC = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/test";

	static final String USER = "sa";
	static final String PASS = "";
	
	public static Connection getConnection() {
		try {
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException ex) {
			throw new RuntimeException("Impossible de se connecter à la base de données.", ex);
		}
	}
}
