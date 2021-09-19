<%@page import="java.util.ArrayList" %>
<%@page import="com.projetveille.bean.Employe" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table Employ�s</title>
</head>
<body>

	<h1>Employ�s</h1>
	<% List<Employe> emps = (ArrayList<Employe>) request.getSession().getAttribute("emps"); %>
	
	<table border=1>
	
	<thead>
		<tr>
			<th>Id</th>
			<th>Pr�nom</th>
			<th>Nom</th>
			<th>Date d'embauche</th>
			<th>ID du Projet</th>
			<th>ID du D�partement</th>
			<th></th>
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
				<td><a href="adminController?action=delete&id=<%= emp.getId()%>">Supprimer</a>
				<td><a href="adminController?action=update&id=<%= emp.getId()%>">Mettre � jour</a>
			</tr>
		<% } %>
	</tbody>
	</table>
	<br>
	<a href="adminPannel.jsp">Retour</a>
</body>
</html>