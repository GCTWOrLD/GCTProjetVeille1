<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Pannel</title>
<style type="text/css">
a:link, a:visited, a:hover, a:active { 
	background-color: white; 
	color: black; 
	padding: 10px 25px; 
	text-align: center; 
	text-decoration: none; 
	display: inline-block; 
	font-weight: bold;
	border-style: solid;
}

a:hover {
	background-color: black;
	color: white;
}

#footer {
    position: fixed;
    bottom: 0;
    width: 100%;
}

body {
	background-image: url("bg.jpg");
}

h1, h2 {
	color: white;
	text-shadow: #000 0px 0px 10px;
    -webkit-font-smoothing: antialiased;
}
</style>
</head>
<body>

	<h1> Bonjour ${username.username} !</h1>

	<h2> Quelle table voulez-vous consulter?</h2>
	
	<a href="employe.jsp">Employés</a>
	<a href="projet.jsp">Projets</a>
	<a href="dep.jsp">Départements</a>
	<br>
	<br>
	 <div id="footer">
		<a href="index.jsp">Retourner à l'acceuil</a>
		<a href="adminController?action=stats">Stats</a>
	 </div>
</body>
</html>