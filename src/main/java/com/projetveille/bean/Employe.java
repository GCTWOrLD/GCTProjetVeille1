package com.projetveille.bean;

public class Employe {

	private Integer id;
	private String prenom;
	private String nom;
	private String dateEmbauche;
	private Integer projetId;
	private Integer departementId;
	
	public Employe() {
		
	}
	
	public Employe(String prenom, String nom, String dateEmbauche, Integer projetId, Integer departementId) {
		this.prenom = prenom;
		this.nom = nom;
		this.dateEmbauche = dateEmbauche;
		this.projetId = projetId;
		this.departementId = departementId;
	}

	public Employe(Integer id, String prenom, String nom, String dateEmbauche, Integer projetId, Integer departementId) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.dateEmbauche = dateEmbauche;
		this.projetId = projetId;
		this.departementId = departementId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public Integer getProjetId() {
		return projetId;
	}

	public void setProjetId(Integer projetId) {
		this.projetId = projetId;
	}

	public Integer getDepartementId() {
		return departementId;
	}

	public void setDepartementId(Integer departementId) {
		this.departementId = departementId;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", dateEmbauche=" + dateEmbauche
				+ ", projetId=" + projetId + ", departementId=" + departementId + "]";
	}
}
