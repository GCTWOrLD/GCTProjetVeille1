package com.projetveille.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestH2JBDC {

	static final String DRIVER_JDBC = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/test";

	static final String USER = "sa";
	static final String PASS = "";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;

		try { 
			Class.forName(DRIVER_JDBC); 

			//Connexion
			System.out.println("Connexion à la base de données..."); 
			conn = DriverManager.getConnection(DB_URL,USER,PASS);  

			//Test d'ajout d'une table
			System.out.println("Créaton d'une table dans la base de données..."); 
			stmt = conn.createStatement(); 
			String sql =  "CREATE TABLE   Produit " + 
					"(id INTEGER not NULL, " + 
					" NOM VARCHAR(150), " +  
					" COMPAGNIE VARCHAR(100))";  
			stmt.executeUpdate(sql);
			System.out.println("Table créée dans la base de données..."); 

			stmt.close(); 
			conn.close(); 
		} catch(SQLException se) { 
			se.printStackTrace(); 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} finally { 
			try{ 
				if(stmt!=null) stmt.close(); 
			} catch(SQLException se2) { 
			} 
			try { 
				if(conn!=null) conn.close(); 
			} catch(SQLException se){ 
				se.printStackTrace(); 
			} 
		} 
		System.out.println("Fin des opérations.");
	} 
}

