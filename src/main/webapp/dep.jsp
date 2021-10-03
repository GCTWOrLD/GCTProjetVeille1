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
<style type="text/css">
a:link, a:visited, a:hover, a:active, button { 
	background-color: white; 
	color: black; 
	padding: 10px 25px; 
	text-align: center; 
	text-decoration: none; 
	display: inline-block; 
	font-weight: bold;
	border-style: solid;
}

a:hover, button:hover {
	background-color: black;
	color: white;
}

h1 {
	margin-left: 10px;
	color: white;
	text-shadow: #000 0px 0px 10px;
    -webkit-font-smoothing: antialiased;
}

#footer {
    position: fixed;
    bottom: 0;
    width: 100%;
}

body {
	background-image: url("bg.jpg");
}

table {
	background-color: black;
	color: white;
}
</style>
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
		</tr>
	</thead>
	<tbody>
		<% for (Departement dep : deps){ %>
			<tr>
				<td><%= dep.getId() %></td>
				<td><%= dep.getNom() %></td>
				<td><a href="adminController?action=deleteDep&depId=<%= dep.getId()%>">Supprimer</a>
				<td><a href="adminController?action=redirectModDep&depId=<%= dep.getId()%>">Modifier</a>
			</tr>
		<% } %>
	</tbody>
	</table>
	<button onclick="location.href='newDep.jsp'" type="button">Ajouter un nouveau département</button>
	<br><br>
	<a href="adminPannel.jsp">Retour</a>
</body>
</html>