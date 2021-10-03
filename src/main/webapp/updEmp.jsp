<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mise à jour de l'employé</title>
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
	<h2>Nouvelles informations de l'employé</h2>
	<h3 class="err">${erreur2}</h3>
	<div class="container">
		<form method="post" name="updEmp" action="adminController?action=updateEmp">
			<label>ID:</label><input type="text" name="newID" value="${empToUpd.id}"/></br>
			<label>Prénom:</label><input type="text" name="newPrénom" value="${empToUpd.prenom}"/></br>
			<label>Nom:</label><input type="text" name="newNom" value="${empToUpd.nom}"/></br>
			<label>Date d'embauche:</label><input type="text" name="newDateEmbauche" value="${empToUpd.dateEmbauche}"/></br>
			<label>ID du projet:</label><input type="text" name="newProjetID" value="${empToUpd.projetId}"/></br>
			<label>ID du département:</label><input type="text" name="newDépartementID" value="${empToUpd.departementId}"/></br>
			<input class="boutton" type="submit" value="Mettre à jour"/>
		</form>
	</div>
	<div id="footer">
		<a href="employe.jsp">Retour</a>
	</div>
</body>
</html>