<%@page import="java.util.ArrayList" %>
<%@page import="com.projetveille.bean.Departement" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table D�partements</title>
</head>
<body>
	
	<h1>D�partements</h1>
	<% List<Departement> deps = (ArrayList<Departement>) request.getSession().getAttribute("deps"); %>
	
	<table border=1>
	
	<thead>
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<% for (Departement dep : deps){ %>
			<tr>
				<td><%= dep.getId() %></td>
				<td><%= dep.getNom() %></td>
				<td><a href="adminController?action=deleteDep&depId=<%= dep.getId()%>">Supprimer</a>
			</tr>
		<% } %>
	</tbody>
	</table>
	<button onclick="location.href='updDep.jsp'" type="button">Mettre � jour un d�partement</button>
	<button onclick="location.href='newDep.jsp'" type="button">Ajouter un nouveau d�partement</button>
	<br><br>
	<a href="adminPannel.jsp">Retour</a>
</body>
</html>