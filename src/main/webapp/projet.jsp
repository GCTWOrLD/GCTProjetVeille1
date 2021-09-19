<%@page import="java.util.ArrayList" %>
<%@page import="com.projetveille.bean.Projet" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table Projets</title>
</head>
<body>

	<h1>Projets</h1>
	<% List<Projet> projs = (ArrayList<Projet>) request.getSession().getAttribute("projs"); %>
	
	<table border=1>
	
	<thead>
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<% for (Projet proj : projs){ %>
			<tr>
				<td><%= proj.getId() %></td>
				<td><%= proj.getNom() %></td>
				<td><a href="adminController?action=delete&id=<%= proj.getId()%>">Supprimer</a>
				<td><a href="adminController?action=update&id=<%= proj.getId()%>">Mettre à jour</a>
			</tr>
		<% } %>
	</tbody>
	</table>
	<br>
	<a href="adminPannel.jsp">Retour</a>	
</body>
</html>