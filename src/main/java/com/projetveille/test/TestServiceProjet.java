package com.projetveille.test;

import com.projetveille.service.ServiceProjet;

public class TestServiceProjet {
	
	public static void main(String[] args) {
		
		// Affiche le projet avec id -> 3 qui est "Anubis"
		
		System.out.println(ServiceProjet.getProjet(3).toString());
	}

}
