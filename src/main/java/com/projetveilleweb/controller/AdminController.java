package com.projetveilleweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projetveille.bean.Departement;
import com.projetveille.bean.Employe;
import com.projetveille.bean.Projet;
import com.projetveille.service.ServiceDepartement;
import com.projetveille.service.ServiceEmploye;
import com.projetveille.service.ServiceProjet;
import com.projetveille.service.ServiceStats;

@WebServlet("/adminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Liens
	
	private static final String EMP_PATH = "employe.jsp";
	private static final String PROJ_PATH = "projet.jsp";
	private static final String DEP_PATH = "dep.jsp";
	
	private static final String NEW_EMP_PATH = "newEmp.jsp";
	private static final String NEW_DEP_PATH = "newDeo.jsp";
	private static final String NEW_PROJ_PATH = "newProj.jsp";
	
	private static final String UPD_EMP_PATH = "updEmp.jsp";
	private static final String UPD_DEP_PATH = "updDep.jsp";
	private static final String UPD_PROJ_PATH = "updProj.jsp";
	
	private static final String STATS_PATH = "stats.jsp";
	
	//Msg Erreur
	
	private static final String ERR_EMPTY = "Vous avez laissé un ou plusieurs champs vide.";
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("deleteEmp")) {
			int empToDelId = Integer.parseInt(request.getParameter("empId"));
			ServiceEmploye.deleteEmploye(empToDelId);
			
			request.getSession().setAttribute("emps", ServiceEmploye.getAllEmploye());
			request.getRequestDispatcher(EMP_PATH).forward(request, response);
			
		} else if (action.equalsIgnoreCase("redirectModEmp")) {
			int empToUpd = Integer.parseInt(request.getParameter("empId"));
			Employe emp = ServiceEmploye.getEmploye(empToUpd);
			
			request.getSession().setAttribute("empToUpd", emp);
			request.getRequestDispatcher(UPD_EMP_PATH).forward(request, response);
			
		} else if (action.equalsIgnoreCase("updateEmp")) {
			Integer newId = Integer.valueOf(request.getParameter("newID"));
			String newPrenom = request.getParameter("newPrénom");
			String newNom = request.getParameter("newNom");
			String newDateEmbauche = request.getParameter("newDateEmbauche");
			Integer newProjetId = Integer.valueOf(request.getParameter("newProjetID"));
			Integer newDepId = Integer.valueOf(request.getParameter("newDépartementID"));
			
			if (newId.equals(null) || newPrenom.isEmpty() || newNom.isEmpty() || newDateEmbauche.isEmpty() || newProjetId.equals(null) || newDepId.equals(null)) {
				request.getSession().setAttribute("erreur2", ERR_EMPTY);
				response.sendRedirect(UPD_EMP_PATH);
			} else {
				Employe empToUpd = ServiceEmploye.getEmploye(newId);
				empToUpd.setPrenom(newPrenom);
				empToUpd.setNom(newNom);
				empToUpd.setDateEmbauche(newDateEmbauche);
				empToUpd.setProjetId(newProjetId);
				empToUpd.setDepartementId(newDepId);
				ServiceEmploye.updateEmploye(empToUpd);
				
				request.getSession().setAttribute("emps", ServiceEmploye.getAllEmploye());
				request.getRequestDispatcher(EMP_PATH).forward(request, response);
			}
			
		} else if (action.equalsIgnoreCase("addEmp")) {
			String prenom = request.getParameter("Prénom");
			String nom = request.getParameter("Nom");
			String dateEmbauche = request.getParameter("DateEmbauche");
			Integer projetId = Integer.valueOf(request.getParameter("ProjetID"));
			Integer depId = Integer.valueOf(request.getParameter("DépartementID"));
			
			if (prenom.isEmpty() || nom.isEmpty() || dateEmbauche.isEmpty() || projetId.equals(null) || depId.equals(null)) {
				request.getSession().setAttribute("erreur2", ERR_EMPTY);
				response.sendRedirect(NEW_EMP_PATH);
			} else {
				Employe emp = new Employe(prenom, nom, dateEmbauche, projetId, depId);
				ServiceEmploye.insertEmploye(emp);
				
				request.getSession().setAttribute("emps", ServiceEmploye.getAllEmploye());
				request.getRequestDispatcher(EMP_PATH).forward(request, response);
			}
			
		} else if (action.equalsIgnoreCase("deleteDep")) {
			int depToDelId = Integer.parseInt(request.getParameter("depId"));
			ServiceDepartement.deleteDep(depToDelId);
			
			request.getSession().setAttribute("deps", ServiceDepartement.getAllDep());
			request.getRequestDispatcher(DEP_PATH).forward(request, response);
			
		} else if (action.equalsIgnoreCase("redirectModDep")) {
			int depToUpd = Integer.parseInt(request.getParameter("depId"));
			Departement dep = ServiceDepartement.getDep(depToUpd);
			
			request.getSession().setAttribute("depToUpd", dep);
			request.getRequestDispatcher(UPD_DEP_PATH).forward(request, response);
			
		} else if (action.equalsIgnoreCase("updateDep")) {
			Integer newId = Integer.valueOf(request.getParameter("newID"));
			String newNom = request.getParameter("newNom");
			
			if (newId.equals(null) || newNom.isEmpty()) {
				request.getSession().setAttribute("erreur2", ERR_EMPTY);
				response.sendRedirect(UPD_DEP_PATH);
			} else {
				Departement depToUpd = ServiceDepartement.getDep(newId);
				depToUpd.setNom(newNom);
				ServiceDepartement.updateDep(depToUpd);
				
				request.getSession().setAttribute("deps", ServiceDepartement.getAllDep());
				request.getRequestDispatcher(DEP_PATH).forward(request, response);
			}
			
		} else if (action.equalsIgnoreCase("addDep")) {
			String nom = request.getParameter("Nom");
			
			if (nom.isEmpty()) {
				request.getSession().setAttribute("erreur2", ERR_EMPTY);
				response.sendRedirect(NEW_DEP_PATH);
			} else {
				Departement dep = new Departement(nom);
				ServiceDepartement.insertDep(dep);
				
				request.getSession().setAttribute("deps", ServiceDepartement.getAllDep());
				request.getRequestDispatcher(DEP_PATH).forward(request, response);
			}
			
		} else if (action.equalsIgnoreCase("deleteProj")) {
			int projToDelId = Integer.parseInt(request.getParameter("projetId"));
			ServiceProjet.deleteProjet(projToDelId);
			
			request.getSession().setAttribute("projs", ServiceProjet.getAllProjet());
			request.getRequestDispatcher(PROJ_PATH).forward(request, response);
			
		} else if (action.equalsIgnoreCase("redirectModProj")) {
			int projToUpd = Integer.parseInt(request.getParameter("projId"));
			Projet proj = ServiceProjet.getProjet(projToUpd);
			
			request.getSession().setAttribute("projToUpd", proj);
			request.getRequestDispatcher(UPD_PROJ_PATH).forward(request, response);
			
		} else if (action.equalsIgnoreCase("updateProj")) {
			Integer newId = Integer.valueOf(request.getParameter("newID"));
			String newNom = request.getParameter("newNom");
			
			if (newId.equals(null) || newNom.isEmpty()) {
				request.getSession().setAttribute("erreur2", ERR_EMPTY);
				response.sendRedirect(UPD_PROJ_PATH);
			} else {
				Projet projToUpd = ServiceProjet.getProjet(newId);
				projToUpd.setNom(newNom);
				ServiceProjet.updateProjet(projToUpd);
				
				request.getSession().setAttribute("projs", ServiceProjet.getAllProjet());
				request.getRequestDispatcher(PROJ_PATH).forward(request, response);
			}
			
		} else if (action.equalsIgnoreCase("addProj")) {
			String nom = request.getParameter("Nom");
			
			if (nom.isEmpty()) {
				request.getSession().setAttribute("erreur2", ERR_EMPTY);
				response.sendRedirect(NEW_PROJ_PATH);
			} else {
				Projet proj = new Projet(nom);
				ServiceProjet.insertProjet(proj);
				
				request.getSession().setAttribute("projs", ServiceProjet.getAllProjet());
				request.getRequestDispatcher(PROJ_PATH).forward(request, response);
			}
		} else if (action.equalsIgnoreCase("stats")) {
			request.getSession().setAttribute("nbEmps", ServiceStats.getTotalEmp());
			request.getSession().setAttribute("nbDeps", ServiceStats.getTotalDep());
			request.getSession().setAttribute("nbProjs", ServiceStats.getTotalProj());
			
			request.getSession().setAttribute("senior", ServiceStats.getSeniorEmp());
			request.getSession().setAttribute("junior", ServiceStats.getJuniorEmp());
			
			request.getRequestDispatcher(STATS_PATH).forward(request, response);
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
