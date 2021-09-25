package com.projetveille.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projetveille.bean.Employe;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ServiceEmploye {
	
	public static Employe getEmploye(int id) {
		Connection connection = ServiceConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Employés where EmployéID=" + id);
			
			if(rs.next()) {
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
	
	public static List<Employe> getAllEmploye() {
		Connection connection = ServiceConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Employés");
			
			List<Employe> emps = new ArrayList<>();
			
			while (rs.next()) {
				Employe emp = new Employe();
				emp.setId(rs.getInt("EmployéID"));
				emp.setPrenom(rs.getString("Prénom"));
				emp.setNom(rs.getString("Nom"));
				emp.setDateEmbauche(rs.getString("DateEmbauche"));
				emp.setProjetId(rs.getInt("ProjetID"));
				emp.setDepartementId(rs.getInt("DépartementID"));
				emps.add(emp);
			}
			return emps;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static boolean insertEmploye(Employe employe) {
		Connection connection = ServiceConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Employés VALUES (NULL, ? , ?, ?, ?, ?)");
			ps.setString(1, employe.getPrenom());
			ps.setString(2, employe.getNom());
			ps.setString(3, employe.getDateEmbauche());
			ps.setInt(4, employe.getProjetId());
			ps.setInt(5, employe.getDepartementId());
			int i = ps.executeUpdate();
			
			if (i == 1) {
				return true;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public static boolean updateEmploye(Employe employe) {
		Connection connection = ServiceConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE Employés SET Prénom=?, Nom=?, DateEmbauche=?, ProjetId=?, DépartementID=? WHERE EmployéID=?");
			ps.setString(1, employe.getPrenom());
			ps.setString(2, employe.getNom());
			ps.setString(3, employe.getDateEmbauche());
			ps.setInt(4, employe.getProjetId());
			ps.setInt(5, employe.getDepartementId());
			ps.setInt(6, employe.getId());
			int i = ps.executeUpdate();
			
			if (i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public static boolean deleteEmploye(int id) {
		Connection connection = ServiceConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			int i = stmt.executeUpdate("DELETE FROM Employés WHERE EmployéID=" + id);
			
			if (i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public static boolean createEmpXml(String filename) {
		try {
			XStream stream = new XStream(new DomDriver());
			stream.toXML(getAllEmploye(), new FileOutputStream(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static List<Employe> readEmpXml(String filename) {
		List<Employe> list = null;
		try {
			XStream stream = new XStream(new DomDriver());
			list = (List<Employe>) stream.fromXML(new FileInputStream(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
