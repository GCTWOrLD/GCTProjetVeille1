package com.projetveilleweb.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projetveille.service.ServiceAdmin;

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
		
		System.out.println("Working Dir =" + System.getProperty("user.dir"));
		
		ServiceAdmin.setList(ServiceAdmin.readAdminXml(FILE));
		
		if (action.equalsIgnoreCase("loginAdmin")) {
			if (ServiceAdmin.checkIfUsernameExists(username)) {
				if (pwd.equals(ServiceAdmin.searchAdminByUsername(username).getPassword())) {
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
		
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

