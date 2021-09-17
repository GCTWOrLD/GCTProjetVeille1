package com.projetveille.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class TestH2JDBCLecture {

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

			//Lecture des données de la table Produit
			System.out.println("Lecture de la table..."); 
			stmt = conn.createStatement(); 
			String sql = "SELECT * FROM Produit"; 
			ResultSet rs = stmt.executeQuery(sql); 


			while(rs.next()) { 
				int id  = rs.getInt("id"); 
				String nomP = rs.getString("NOM");
				String nomC = rs.getString("COMPAGNIE");

				System.out.print("ID: " + id + " NOM: " + nomP + " COMPAGNIE: " + nomC + "\r\n"); 
			} 
			rs.close(); 
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
