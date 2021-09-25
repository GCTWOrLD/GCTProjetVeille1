<%@page import="java.util.ArrayList" %>
<%@page import="com.projetveille.bean.Employe" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table Employés</title>
</head>
<body>

	<h1>Employés</h1>
	<% List<Employe> emps = (ArrayList<Employe>) request.getSession().getAttribute("emps"); %>
	
	<table border=1>
	
	<thead>
		<tr>
			<th>Id</th>
			<th>Prénom</th>
			<th>Nom</th>
			<th>Date d'embauche</th>
			<th>ID du Projet</th>
			<th>ID du Département</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<% for (Employe emp : emps){ %>
			<tr>
				<td><%= emp.getId() %></td>
				<td><%= emp.getPrenom() %></td>
				<td><%= emp.getNom() %></td>
				<td><%= emp.getDateEmbauche() %></td>
				<td><%= emp.getProjetId() %></td>
				<td><%= emp.getDepartementId() %></td>
				<td><a href="adminController?action=deleteEmp&empId=<%= emp.getId()%>">Supprimer</a>
			</tr>
		<% } %>
	</tbody>
	</table>
	<button onclick="location.href='updEmp.jsp'" type="button">Mettre à jour un employé</button>
	<button onclick="location.href='newEmp.jsp'" type="button">Ajouter un nouvel employé</button>
	<br><br>
	<a href="adminPannel.jsp">Retour</a>
</body>
</html>