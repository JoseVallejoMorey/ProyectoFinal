<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" session="true" %>
<%@page import="clases.User" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SM2 Panel</title>
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
</head>


<body>

<%	

	HttpSession objsession = request.getSession();
	
	if( (objsession == null) || (objsession.equals("")) ){
		
		System.out.println("objsession es NULL");
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	    dispatcher.forward( request, response );
	    return;
	}else{
		
		User user = (User)objsession.getAttribute("user");	
		
%>
		
<!-- PANEL FORM -->
<div class="text-center" style="padding:50px 0">
	<div class="logo"><img alt="logo" src="img/logo.png"></div>

<div class="container">
<div class="panel panel-danger">
    <div class="panel-heading">Panel de busqueda</div>
    <div class="panel-body">
<!-- Main Form -->
    <form> 
	    <div class="col-md-12 col-sm-12">
			<div class="form-group col-md-3 col-sm-3">
	  			<div class="panel panel-default">
	  				<div class="panel-body">
	    				<label for="name">Nombre</label>
	    				<input type="text" class="form-control input-sm" id="name" placeholder="">
	  				</div>
				</div>
			</div>

			<div class="form-group col-md-3 col-sm-3">
	  			<div class="panel panel-default">
	  				<div class="panel-body">
	    				<label for="name">Apellido</label>
	    				<input type="text" class="form-control input-sm" id="name" placeholder="">
	  				</div>
				</div>
			</div>

			<div class="form-group col-md-3 col-sm-3">
	  			<div class="panel panel-default">
	  				<div class="panel-body">
	    				<label for="name">Empresa</label>
	    				<input type="text" class="form-control input-sm" id="name" placeholder="">
	  				</div>
				</div>
			</div>

			<div class="form-group col-md-3 col-sm-3">
				<div class="panel-body">
  					<button type="button" class="btn btn-default btn-lg">
  					Buscar 
    				<span class="glyphicon glyphicon-search"></span>
 				</button>
			</div>

  		</div>
    </form>	
</div>
</div>
      
<!-- end:Main Form -->
    </div>
	

		
		
<%
		
		//obtener
		if(user.getPermiso()<3){
			//mostrar boton de agrear nuevo 
			%><!-- <a href="nuevocontactoservlet"> Agregar Nuevo </a> --> <%
		}
		
		//mostrar contacto (acceso a datos de contacto se muestra a todos)
		%><!-- <a href="modificarcontacto"> Modificar Contacto </a> --> <%
	}
	%>
	


<!-- SCRIPT BOOSTRAP -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.validate.js"></script>
	<script src="js/js_login.js"></script>		
	
</body>
</html>