<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Accueil</title>
<style>
body {
	font-family: Arial;
	color: black;
}

h1 {
	margin-left: 10px;
}

.split {
	height: 100%;
	width: 50%;
	position: fixed;
	z-index: 1;
	top: 0;
	overflow-x: hidden;
	padding-top: 20px;
}

.left {
	left: 0;
	background-color: white;
}

.right {
	right: 0;
	background-color: white;
}

.centered {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
}

.centered img {
	width: 150px;
	border-radius: 50%;
}

.err {
	color: red;
}
</style>
</head>
<body>
	<div class="split left">
		<h1>DB Employés</h1>
		<h3 class="err">${erreur}</h3>
		<div class="centered">
			<form method="post" name="admins"
				action="loginController?action=loginAdmin">
				Username: <input type="text" name="username" /> <br /> <br />
				Password: <input type="password" name="pwd" /> <br /> <br /> <input
					type="submit" value="Connexion" />
			</form>
		</div>
	</div>
</body>
</html>
