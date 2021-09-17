package com.projetveille.bean;

public class Projet {

	private Integer id;
	private String nom;

	public Projet() {
	}

	public Projet(String nom) {
		this.nom = nom;
	}

	public Projet(Integer id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Projet [id=" + id + ", nom=" + nom + "]";
	}
}
