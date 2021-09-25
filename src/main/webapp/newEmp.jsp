<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajout d'un nouvel employ�</title>
<style type="text/css">
.container {
	width: 300px;
	clear both;
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
}

</style>
</head>
<body>

	<div class="container">
		<h2>Informations de l'employ�</h2>
		<h3 class="err">${erreur2}</h3>
		<form method="post" name="newEmp" action="adminController?action=addEmp">
			Pr�nom: <input type="text" name="Pr�nom"/></br>
			Nom: <input type="text" name="Nom"/></br>
			Date d'embauche: <input type="text" name="DateEmbauche"/></br>
			ID du projet: <input type="text" name="ProjetID"/></br>
			ID du d�partement: <input type="text" name="D�partementID"/></br>
			<input class="boutton" type="submit" value="Ajouter l'employ�"/>
		</form>
	</div>
	<a href="adminPannel.jsp">Retour</a>

</body>
</html>