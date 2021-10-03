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
				<td><a href="adminController?action=redirectModProj&projId=<%= proj.getId()%>">Modifier</a>
			</tr>
		<% } %>
	</tbody>
	</table>
	<button onclick="location.href='newProj.jsp'" type="button">Ajouter un nouveau projet</button>
	<br><br>
	<a href="adminPannel.jsp">Retour</a>	
</body>
</html>