<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mise à jour du département</title>
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
		<h2>Nouvelles informations du département</h2>
		<h3 class="err">${erreur2}</h3>
		<form method="post" name="updDep" action="adminController?action=updateDep">
			ID: <input type="text" name="newID"/></br>
			Nom: <input type="text" name="newNom"/></br>
			<input class="boutton" type="submit" value="Mettre à jour"/>
		</form>
	</div>
	<a href="adminPannel.jsp">Retour</a>

</body>
</html>