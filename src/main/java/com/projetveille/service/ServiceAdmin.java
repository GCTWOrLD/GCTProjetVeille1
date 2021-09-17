package com.projetveille.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import com.projetveille.bean.Admin;

public class ServiceAdmin {

	private static final Logger logger = LogManager.getLogger(ServiceAdmin.class);
	
	private static List<Admin> liste = new ArrayList<>();
	
	/**
	 * M�thode qui retourne la liste d'Admins
	 * @return la liste
	 */
	public static List<Admin> getList() {
		return liste;
	}
	
	/**
	 * M�thode qui permet de modifier la liste d'Admins
	 * @param liste La nouvelle liste
	 */
	public static void setList(List<Admin> liste) {
		ServiceAdmin.liste = liste;
	}

	/**
	 * M�thode qui permet d'ajouter un admin � la liste
	 * @param a L'Admin � ajouter
	 * @return Retourne vrai si l'ajout a fonctionn�
	 */
	public static boolean addAdmin(Admin a) {
		return getList().add(a);
	}
	
	/**
	 * M�thode qui permet de supprimer un Admin de la liste
	 * @param a L'Admin � supprimer
	 * @return Retourne vrai si la supression a fonctionn�
	 */
	public static boolean deleteAdmin(Admin a) {
		return getList().remove(a);
	}
	
	/**
	 * M�thode qui permet de rechercher un Admin gr�ce � un id pass� en param�tre
	 * @param id L'id � rechercher
	 * @return L'Admin trouv�
	 */
	public static Admin searchAdminById(int id) {
		for (Admin a : getList()) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}
	
	 /**
	  * M�thode qui permet de rechercher un Admin gr�ce � un username pass� en param�tre
	  * @param username L'username � rechercher
	  * @return L'Admin trouv�
	  */
	public static Admin searchAdminByUsername(String username) {
		for (Admin a : getList()) {
			if (username.equals(a.getUsername())) {
				return a;
			}
		}
		return null;
	}
	
	/**
	 * M�thode qui permet de d�terminer si l'Admin pass� en param�tre existe dans la liste
	 * @param username L'username � rechercher
	 * @return Retourne vrai si l'Admin a �t� trouv�
	 */
	public static boolean checkIfUsernameExists(String username) {
		for (Admin a : getList()) {
			if (username.equals(a.getUsername())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * M�thode qui permet de cr�er un fichier XML d'Admins
	 * @param filename Le nom du fichier
	 * @return Retourne vrai si le fichier a �t� cr�� avec succ�s
	 */
	public static boolean createAdminXml(String filename) {
		try {
			XStream stream = new XStream(new DomDriver());
			stream.toXML(getList(), new FileOutputStream(filename));
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return false;	
	}
	
	/**
	 * M�thode qui permet de lire un fichier XML d'Admins
	 * @param filename Le nom du fichier
	 * @return Retourne une liste qui contient les donn�es du fichier XML
	 */
	public static List<Admin> readAdminXml(String filename) {
		List<Admin> list = null;
		try {
			XStream stream = new XStream(new DomDriver());
			list = (List<Admin>) stream.fromXML(new FileInputStream(filename));
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return list;
	}
}
