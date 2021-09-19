package com.projetveille.test;

import com.projetveille.bean.Admin;
import com.projetveille.service.ServiceAdmin;

public class initialisationAdmin {
	
	public static void main(String[] args) {
		
		Admin admin = new Admin(2, "Gabriel", "password");
		
		String filename = "Admins.xml";
		
		
		ServiceAdmin.setList(ServiceAdmin.readAdminXml(filename));
		
		ServiceAdmin.addAdmin(admin);
		
		ServiceAdmin.createAdminXml(filename);
		
		System.out.println(ServiceAdmin.getList());

	}
}
