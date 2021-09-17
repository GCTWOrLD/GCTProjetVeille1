package com.projetveille.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projetveille.bean.Departement;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ServiceDepartement {
	
	public static Departement getDep(int id) {
		Connection connection = ServiceConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Départements where DépartementID=" + id);
			
			if (rs.next()) {
				Departement dep = new Departement();
				dep.setId(rs.getInt("DépartementID"));
				dep.setNom(rs.getString("Nom"));
				
				return dep;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static List<Departement> getAllDep() {
		Connection connection = ServiceConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Départements");
			
			List<Departement> deps = new ArrayList<>();
			
			while(rs.next()) {
				Departement dep = new Departement();
				dep.setId(rs.getInt("DépartementID"));
				dep.setNom(rs.getString("Nom"));
				deps.add(dep);
			}
			return deps;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static boolean insertDep(Departement dep) {
		
		
		return false;
	}
	
	public static boolean updateDep(Departement dep) {
		
		
		return false;
	}
	
	public static boolean deleteDep(int id) {
		
		
		return false;
	}
	
	public static boolean createDepXml(String filename) {
		try {
			XStream stream = new XStream(new DomDriver());
			stream.toXML(getAllDep(), new FileOutputStream(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static List<Departement> readDepXml(String filename) {
		List<Departement> list = null;
		try {
			XStream stream = new XStream(new DomDriver());
			list = (List<Departement>) stream.fromXML(new FileInputStream(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
