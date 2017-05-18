<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SM2 Contactos</title>
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
</head>


<body>
<!-- LOGIN FORM -->
<div class="text-center" style="padding:50px 0">
	<div class="logo"><img alt="logo" src="img/logo.png"></div>
	<!-- Main Form -->
	<div class="login-form-1">
		<form id="login-form" class="text-left" action="Login" method="post">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
					<div class="form-group">
						<label for="lg_username" class="sr-only">Username</label>
						<input type="text" class="form-control" id="lg_username" name="email" placeholder="Email">
					</div>
					<div class="form-group">
						<label for="lg_password" class="sr-only">Password</label>
						<input type="password" class="form-control" id="lg_password" name="pass" placeholder="Contraseña">
					</div>
					<div class="form-group login-group-checkbox">
						<input type="checkbox" id="lg_remember" name="lg_remember">
						<label for="lg_remember">Recuerdame</label>
					</div>
				</div>
				<button type="submit" class="login-button"><i class="glyphicon glyphicon-chevron-right"></i></button>
			</div>
			<div class="etc-login-form">
				<p>¿Olvidaste tu contraseña? <a href="Lostpw">haga clic aquí</a></p>
			</div>
		</form>
	</div>
	<!-- end:Main Form -->
</div>



<!-- SCRIPT BOOSTRAP -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
<!-- 	<script src="js/jquery.validate.js"></script> -->
	<script src="js/js_login.js"></script>
</body>
</html>