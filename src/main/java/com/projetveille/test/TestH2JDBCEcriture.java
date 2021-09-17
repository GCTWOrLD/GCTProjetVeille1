package com.projetveille.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestH2JDBCEcriture {

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

			//Ajout de données dans une table
			stmt = conn.createStatement();  
			String sql = "INSERT INTO Produit " + "VALUES (1, 'Lait', 'Lactancia')"; 

			stmt.executeUpdate(sql); 
			sql = "INSERT INTO Produit " + "VALUES (2, 'Fromage', 'OKA')";  

			stmt.executeUpdate(sql); 
			sql = "INSERT INTO Produit " + "VALUES (3, 'Biscuit', 'OREO')"; 

			stmt.executeUpdate(sql); 
			sql = "INSERT INTO Produit " + "VALUES (4, 'Muffin', 'sans nom')"; 

			stmt.executeUpdate(sql); 
			System.out.println("La table Produit est maintenant à jour...");

			stmt.close(); 
			conn.close(); 
		} catch(SQLException se) { 
			se.printStackTrace(); 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} finally { 
			try {
				if(stmt!=null) stmt.close();  
			} catch(SQLException se2) { 
				try { 
					if(conn!=null) conn.close(); 
				} catch(SQLException se) { 
					se.printStackTrace(); 
				}
			}
			System.out.println("Fin des opérations."); 
		} 
	}

}
