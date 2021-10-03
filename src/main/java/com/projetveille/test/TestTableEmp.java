package com.projetveille.test;

import com.projetveille.bean.Employe;
import com.projetveille.service.ServiceDepartement;
import com.projetveille.service.ServiceEmploye;
import com.projetveille.service.ServiceProjet;
import com.projetveille.service.ServiceStats;

public class TestTableEmp {
	
	public static void main(String[] args) {
		
		//String filename = "Employés.xml";
		
		//String filename2 = "Départements.xml";
		
		//ServiceDepartement.createDepXml(filename2);
		
		//System.out.println(ServiceDepartement.readDepXml(filename2));
		
		//String filename3 = "Projets.xml";
		
		//ServiceProjet.createProjXml(filename3);
		
		//System.out.println(ServiceProjet.readProjXml(filename3));
		
		//Employe emp = new Employe("Charles", "Wells", "2021-05-26", 2, 2);
		
		//ServiceEmploye.insertEmploye(emp);
		
		//ServiceEmploye.createEmpXml(filename);
		
		//System.out.println(ServiceEmploye.readEmpXml(filename));
		
		//Employe emp2 = ServiceEmploye.getEmploye(13);
		
		//emp2.setPrenom("Eddy");
		
		//ServiceEmploye.updateEmploye(emp2);
		
		//ServiceEmploye.deleteEmploye(10);
		
		//ServiceEmploye.createEmpXml(filename);
		
		//System.out.println(ServiceEmploye.readEmpXml(filename));
		
		System.out.println("Total Emps: " + ServiceStats.getTotalEmp());
		
		System.out.println("Total Deps: " + ServiceStats.getTotalDep());
		
		System.out.println("Total Projs: " + ServiceStats.getTotalProj());
		
		System.out.println("Senior Emp:" + ServiceStats.getSeniorEmp().toString());
		
		System.out.println("Junior Emp" + ServiceStats.getJuniorEmp().toString());
	}	
}
