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
		</tr>
	</thead>
	<tbody>
		<% for (Projet proj : projs){ %>
			<tr>
				<td><%= proj.getId() %></td>
				<td><%= proj.getNom() %></td>
				<td><a href="adminController?action=deleteProj&projetId=<%= proj.getId()%>">Supprimer</a>
			</tr>
		<% } %>
	</tbody>
	</table>
	<button onclick="location.href='updProj.jsp'" type="button">Mettre � jour un projet</button>
	<button onclick="location.href='newProj.jsp'" type="button">Ajouter un nouveau projet</button>
	<br><br>
	<a href="adminPannel.jsp">Retour</a>	
</body>
</html>