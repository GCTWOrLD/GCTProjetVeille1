package com.projetveilleweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projetveille.bean.Departement;
import com.projetveille.bean.Employe;
import com.projetveille.bean.Projet;
import com.projetveille.service.ServiceAdmin;
import com.projetveille.service.ServiceDepartement;
import com.projetveille.service.ServiceEmploye;
import com.projetveille.service.ServiceProjet;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Liens
	
	private static final String INDEX_PATH = "index.jsp";
	private static final String ADMIN_PATH = "adminPannel.jsp";
	private static final String FILE = "Admins.xml";
	
	// Messages d'erreur
	
	private static final String ERR_LOGIN = "Votre mot de passe ou nom d'utilisateur est incorrect.";
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String action = request.getParameter("action");
		
		ServiceAdmin.setList(ServiceAdmin.readAdminXml(FILE));
		
		List<Employe> emps = ServiceEmploye.getAllEmploye();
		List<Departement> deps = ServiceDepartement.getAllDep();
		List<Projet> projs = ServiceProjet.getAllProjet();
		
		if (action.equalsIgnoreCase("loginAdmin")) {
			if (ServiceAdmin.checkIfUsernameExists(username)) {
				if (pwd.equals(ServiceAdmin.searchAdminByUsername(username).getPassword())) {
					request.getSession().setAttribute("username", ServiceAdmin.searchAdminByUsername(username));
					request.getSession().setAttribute("emps", emps);
					request.getSession().setAttribute("deps", deps);
					request.getSession().setAttribute("projs", projs);
					request.getRequestDispatcher(ADMIN_PATH).forward(request, response);
				}
			}else {
				request.getSession().setAttribute("erreur", ERR_LOGIN);
				response.sendRedirect(INDEX_PATH);
			}
		}else {
			request.getSession().setAttribute("erreur", ERR_LOGIN);
			response.sendRedirect(INDEX_PATH);
		}
	}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

