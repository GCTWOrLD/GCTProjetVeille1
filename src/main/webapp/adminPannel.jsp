<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Pannel</title>
</head>
<body>

	<h1> Bonjour ${username.username} !</h1>

	<h2> Quelle table voulez-vous consulter?</h2>
	
	<a href="employe.jsp">Employ�s</a>
	<a href="projet.jsp">Projets</a>
	<a href="dep.jsp">D�partements</a>
	<br>
	<br>
	<a href="index.jsp">Retourner � l'acceuil</a>


</body>
</html>