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
	 * Méthode qui retourne la liste d'Admins
	 * @return la liste
	 */
	public static List<Admin> getList() {
		return liste;
	}
	
	/**
	 * Méthode qui permet de modifier la liste d'Admins
	 * @param liste La nouvelle liste
	 */
	public static void setList(List<Admin> liste) {
		ServiceAdmin.liste = liste;
	}

	/**
	 * Méthode qui permet d'ajouter un admin à la liste
	 * @param a L'Admin à ajouter
	 * @return Retourne vrai si l'ajout a fonctionné
	 */
	public static boolean addAdmin(Admin a) {
		return getList().add(a);
	}
	
	/**
	 * Méthode qui permet de supprimer un Admin de la liste
	 * @param a L'Admin à supprimer
	 * @return Retourne vrai si la supression a fonctionné
	 */
	public static boolean deleteAdmin(Admin a) {
		return getList().remove(a);
	}
	
	/**
	 * Méthode qui permet de rechercher un Admin grâce à un id passé en paramètre
	 * @param id L'id à rechercher
	 * @return L'Admin trouvé
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
	  * Méthode qui permet de rechercher un Admin grâce à un username passé en paramètre
	  * @param username L'username à rechercher
	  * @return L'Admin trouvé
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
	 * Méthode qui permet de déterminer si l'Admin passé en paramètre existe dans la liste
	 * @param username L'username à rechercher
	 * @return Retourne vrai si l'Admin a été trouvé
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
	 * Méthode qui permet de créer un fichier XML d'Admins
	 * @param filename Le nom du fichier
	 * @return Retourne vrai si le fichier a été créé avec succès
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
	 * Méthode qui permet de lire un fichier XML d'Admins
	 * @param filename Le nom du fichier
	 * @return Retourne une liste qui contient les données du fichier XML
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
