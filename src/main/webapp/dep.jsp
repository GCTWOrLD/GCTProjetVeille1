<%@page import="java.util.ArrayList" %>
<%@page import="com.projetveille.bean.Departement" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table Départements</title>
</head>
<body>
	
	<h1>Départements</h1>
	<% List<Departement> deps = (ArrayList<Departement>) request.getSession().getAttribute("deps"); %>
	
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
		<% for (Departement dep : deps){ %>
			<tr>
				<td><%= dep.getId() %></td>
				<td><%= dep.getNom() %></td>
				<td><a href="adminController?action=delete&id=<%= dep.getId()%>">Supprimer</a>
				<td><a href="adminController?action=update&id=<%= dep.getId()%>">Mettre à jour</a>
			</tr>
		<% } %>
	</tbody>
	</table>
	<br>
	<a href="adminPannel.jsp">Retour</a>
</body>
</html>