<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SM2 Recuperar Contraseña</title>
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
</head>


<body>
<!-- FORGOT PASSWORD FORM -->
<div class="text-center" style="padding:50px 0">
	<div class="logo">Se te olvidó tu contraseña</div>
	<!-- Main Form -->
	<div class="login-form-1">
		<form id="forgot-password-form" class="text-left">
			<div class="etc-login-form">
				<p>Cuando complete su dirección de correo electrónico registrada, se le enviarán instrucciones sobre cómo restablecer su contraseña.</p>
			</div>
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
					<div class="form-group">
						<label for="fp_email" class="sr-only">Dirección de correo electrónico</label>
						<input type="text" class="form-control" id="fp_email" name="fp_email" placeholder="Dirección de correo electrónico">
					</div>
				</div>
				<button type="submit" class="login-button"><i class="glyphicon glyphicon-chevron-right"></i></button>
			</div>
			<div class="etc-login-form">
				<p>¿Ya tienes una cuenta? <a href="Recuperacionservlet">Entre aquí</a></p>
			</div>
		</form>
	</div>
<!-- end:Main Form -->
</div>



<!-- SCRIPT BOOSTRAP -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.validate.js"></script>
	<script src="js/js_login.js"></script>
</body>
</html>