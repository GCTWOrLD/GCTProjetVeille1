<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mise à jour de l'employé</title>
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
		<h2>Nouvelles informations de l'employé</h2>
		<h3 class="err">${erreur2}</h3>
		<form method="post" name="updEmp" action="adminController?action=updateEmp">
			ID: <input type="text" name="newID"/></br>
			Prénom: <input type="text" name="newPrénom"/></br>
			Nom: <input type="text" name="newNom"/></br>
			Date d'embauche: <input type="text" name="newDateEmbauche"/></br>
			ID du projet: <input type="text" name="newProjetID"/></br>
			ID du département: <input type="text" name="newDépartementID"/></br>
			<input class="boutton" type="submit" value="Mettre à jour"/>
		</form>
	</div>
	<a href="adminPannel.jsp">Retour</a>
</body>
</html>