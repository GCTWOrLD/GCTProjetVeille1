package com.projetveille.test;


import java.io.File;
import java.io.IOException;

import com.projetveille.service.ServiceAdmin;

public class initialisationAdmin {
	
	public static void main(String[] args) {
		
		String filename = "Admins.xml";
		
		ServiceAdmin.setList(ServiceAdmin.readAdminXml(filename));
		
		System.out.println(ServiceAdmin.getList());

	}
}
