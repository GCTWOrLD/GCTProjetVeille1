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


import com.projetveille.bean.Projet;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ServiceProjet {

	public static Projet getProjet(int id) {
		Connection connection = ServiceConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Projets where ProjetID=" + id);
			
			if(rs.next()) {
				Projet projet = new Projet();
				projet.setId(rs.getInt("ProjetID"));
				projet.setNom(rs.getString("Nom"));
				
				return projet;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static List<Projet> getAllProjet() {
		Connection connection = ServiceConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Projets");
			
			List<Projet> projs = new ArrayList<>();
			
			while (rs.next()) {
				Projet projet = new Projet();
				projet.setId(rs.getInt("ProjetID"));
				projet.setNom(rs.getString("Nom"));
				projs.add(projet);
			}
			return projs;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static boolean insertProjet(Projet projet) {
		Connection connection = ServiceConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Projets VALUES (NULL, ?)");
			ps.setString(1, projet.getNom());
			int i = ps.executeUpdate();
			
			if (i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean updateProjet(Projet projet) {
		Connection connection = ServiceConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE Projets SET Nom=? WHERE ProjetID=?");
			ps.setString(1, projet.getNom());
			ps.setInt(2, projet.getId());
			int i = ps.executeUpdate();
			
			if (i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public static boolean deleteProjet(int id) {
		Connection connection = ServiceConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			int i = stmt.executeUpdate("DELETE FROM Projets WHERE ProjetID=" + id);
			
			if (i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public static boolean createProjXml(String filename) {
		try {
			XStream stream = new XStream(new DomDriver());
			stream.toXML(getAllProjet(), new FileOutputStream(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static List<Projet> readProjXml(String filename) {
		List<Projet> list = null;
		try {
			XStream stream = new XStream(new DomDriver());
			list = (List<Projet>) stream.fromXML(new FileInputStream(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
