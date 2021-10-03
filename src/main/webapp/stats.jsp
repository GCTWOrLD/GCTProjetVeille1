<%@page import="com.projetveille.bean.Employe"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stats</title>
<style type="text/css">
body {
	color: black;
	background-image: url("bg.jpg");
}

h1, h3 {
	color: white;
	text-shadow: #000 0px 0px 10px;
    -webkit-font-smoothing: antialiased;
}

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

p {
	color: white;
	text-shadow: #000 0px 0px 10px;
    -webkit-font-smoothing: antialiased;
}

#footer {
    position: fixed;
    bottom: 0;
    width: 100%;
}
</style>
</head>
<body>
	
	<h1>Stats</h1>
	<div style="display: flex; justify-content: space-around">
		<div>
			<h3>Employ�s</h3>
			<p> Nombre d'employ�s: ${nbEmps} </p>
			<p>Employ� le plus ancien: ${senior.prenom} ${senior.nom}</p>
			<p>Employ� le plus r�cent: ${junior.prenom} ${junior.nom}</p>
		</div>
	
		<div>
			<h3>D�partements</h3>
			<p> Nombre de d�partements: ${nbDeps} </p>
		</div>
	
		<div>
			<h3>Projets</h3>
			<p> Nombre de projets: ${nbProjs} </p>
		</div>
	</div>
	
	<br>
	<div id="footer">
		<a href="adminPannel.jsp">Retour</a>
	</div>
</body>
</html>