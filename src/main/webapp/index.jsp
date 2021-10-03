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
	color: black;
	background-image: url("bg.jpg");
}

h1 {
	margin-left: 10px;
	color: white;
	text-shadow: #000 0px 0px 10px;
    -webkit-font-smoothing: antialiased;
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
}

.centered {
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

.centered img {
	width: 150px;
	border-radius: 50%;
}

.err {
	color: red;
	margin-left: 10px;
	text-shadow: #000 0px 0px 10px;
    -webkit-font-smoothing: antialiased;
}

label {
	font-weight: bold;
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
				<label>Username:</label><input type="text" name="username" /> <br /> <br />
				<label>Password:</label><input type="password" name="pwd" /> <br /> <br /> <input
					type="submit" value="Connexion" />
			</form>
		</div>
	</div>
</body>
</html>
