<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.projetveille.bean.Projet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajout d'un nouvel employé</title>
<style type="text/css">
body {
	color: black;
	background-image: url("bg.jpg");
}

h1, h2 {
	color: white;
	text-shadow: #000 0px 0px 10px;
    -webkit-font-smoothing: antialiased;
}

.container {
	width: 300px;
	clear both;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
	border-radius: 20px;
	background-color: #f2f2f2;
	padding: 20px;
	border-style: solid;
}

.container input {
	width 100%;
	clear both;
}

.container .boutton {
	width: 150px;
}

.err {
	color: red;
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

input[type=text], input[type=password] {
  	width: 100%;
  	padding: 12px 20px;
  	margin: 8px 0;
  	display: inline-block;
  	border: 1px solid #ccc;
  	border-radius: 4px;
  	box-sizing: border-box;
}

input[type=submit] {
	background-color: white; 
	color: black; 
	padding: 10px 25px; 
	text-align: center; 
	text-decoration: none; 
	display: inline-block; 
	font-weight: bold;
	border-style: solid;
}

input[type=submit]:hover {
	background-color: black;
	color: white;
}

label {
	font-weight: bold;
}

#footer {
    position: fixed;
    bottom: 0;
    width: 100%;
}
</style>
</head>
<body>

	<% List<Projet> projs = (ArrayList<Projet>) request.getSession().getAttribute("projs"); %>
	
	<h2>Informations de l'employé</h2>
	<h3 class="err">${erreur2}</h3>
	<div class="container">
		<form method="post" name="newEmp" action="adminController?action=addEmp">
			<label>Prénom:</label><input type="text" name="Prénom"/></br>
			<label>Nom:</label><input type="text" name="Nom"/></br>
			<label>Date d'embauche:</label><input type="text" name="DateEmbauche"/></br>
			<label>ID du projet:</label><input type="text" name="ProjetID"/></br>
			<%-- Test: 
			<input type="text" list="projets" name="ProjetID">
  			<datalist id="projets">
  			 <% for (int i = 0; i < projs.size(); i++){ 
    			<option value="${projs.get(i).getNom()}">
    		<% } %>
  			</datalist> --%>
			<label>ID du département:</label><input type="text" name="DépartementID"/></br>
			<input class="boutton" type="submit" value="Ajouter l'employé"/>
		</form>
	</div>
	<div id="footer">
		<a href="employe.jsp">Retour</a>
	</div>
</body>
</html>