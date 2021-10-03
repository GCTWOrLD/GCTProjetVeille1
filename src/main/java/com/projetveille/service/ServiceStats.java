package com.projetveille.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.projetveille.bean.Employe;

public class ServiceStats {

	public static int getTotalEmp() {
		Connection connection = ServiceConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Employés");
			
			rs.next();
			int total = rs.getInt(1);
			
			return total;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return 0;
	}
	
	public static int getTotalDep() {
		Connection connection = ServiceConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Départements");
			
			rs.next();
			int total = rs.getInt(1);
			
			return total;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return 0;
	}
	
	public static int getTotalProj() {
		Connection connection = ServiceConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Projets");
			
			rs.next();
			int total = rs.getInt(1);
			
			return total;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return 0;
	}
	
	public static Employe getSeniorEmp() {
		Connection connection = ServiceConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT TOP 1  *  FROM Employés ORDER BY DateEmbauche ASC");
			
			if (rs.next()) {
				Employe emp = new Employe();
				emp.setId(rs.getInt("EmployéID"));
				emp.setPrenom(rs.getString("Prénom"));
				emp.setNom(rs.getString("Nom"));
				emp.setDateEmbauche(rs.getString("DateEmbauche"));
				emp.setProjetId(rs.getInt("ProjetID"));
				emp.setDepartementId(rs.getInt("DépartementID"));
				
				return emp;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static Employe getJuniorEmp() {
		Connection connection = ServiceConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT TOP 1  *  FROM Employés ORDER BY DateEmbauche DESC");
			
			if (rs.next()) {
				Employe emp = new Employe();
				emp.setId(rs.getInt("EmployéID"));
				emp.setPrenom(rs.getString("Prénom"));
				emp.setNom(rs.getString("Nom"));
				emp.setDateEmbauche(rs.getString("DateEmbauche"));
				emp.setProjetId(rs.getInt("ProjetID"));
				emp.setDepartementId(rs.getInt("DépartementID"));
				
				return emp;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
