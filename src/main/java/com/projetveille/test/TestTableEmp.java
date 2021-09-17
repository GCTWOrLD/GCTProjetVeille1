package com.projetveille.test;

import com.projetveille.service.ServiceDepartement;
import com.projetveille.service.ServiceEmploye;
import com.projetveille.service.ServiceProjet;

public class TestTableEmp {
	
	public static void main(String[] args) {
		
		String filename = "Employés.xml";
		
		String filename2 = "Départements.xml";
		
		ServiceDepartement.createDepXml(filename2);
		
		System.out.println(ServiceDepartement.readDepXml(filename2));
		
		ServiceEmploye.createEmpXml(filename);
		
		System.out.println(ServiceEmploye.readEmpXml(filename));
		
		String filename3 = "Projets.xml";
		
		ServiceProjet.createProjXml(filename3);
		
		System.out.println(ServiceProjet.readProjXml(filename3));
	}	
}
