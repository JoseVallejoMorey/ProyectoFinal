<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" session="true" %>
<%@page import="classes.*" %>

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
		//System.out.println("objsession es null");
	}else{
		
		User user = (User)objsession.getAttribute("user");
 		Navegacion nv = (Navegacion)objsession.getAttribute("navegacion");
		String destino =nv.getDestino();
	
%>




<!-- menu de navegacion -->

<div class="container">
	<div class="col-md-12 col-sm-12">
		<div class="row">
			<div class="pull-right">
				<div class="dropdown">
					<button type="button" class="btn btn-danger btn-cons" id="dropdownMenu1" data-toggle="dropdown">Menu <span class="caret"></span></button>
					<ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu1">
					
					<% if(user.getPermiso()==1){ %>
						<li><a href="Vistabuscadorcontacto"><i class="glyphicon glyphicon-search"></i> Buscar contactos</a></li>
						<li><a href="Contactonuevo"><i class="glyphicon glyphicon-pencil"></i> Crear nuevo contacto</a></li>	
						<li><a href="Vistabuscadoruser"><i class="glyphicon glyphicon-search"></i> Buscar usuarios</a></li>	
						<li><a href="Usernuevo"><i class="glyphicon glyphicon-pencil"></i> Crear nuevo usuario</a></li>
						<li><a href="Vistamailing"><i class="glyphicon glyphicon-envelope"></i> Mailing</a></li>
						<li><a href="Logout"><i class="glyphicon glyphicon-off"></i> Cerrar sesión</a></li>										
					<%}else if(user.getPermiso()==2){ %>
						<li><a href="Vistabuscadorcontacto"><i class="glyphicon glyphicon-search"></i> Buscar contactos</a></li>
						<li><a href="Contactonuevo"><i class="glyphicon glyphicon-pencil"></i> Crear nuevo contacto</a></li>	
						<li><a href="Logout"><i class="glyphicon glyphicon-off"></i> Cerrar sesión</a></li>							
					<%}else{ %>
						<li><a href="Vistabuscadorcontacto"><i class="glyphicon glyphicon-search"></i> Buscar contactos</a></li>
						<li><a href="Logout"><i class="glyphicon glyphicon-off"></i> Cerrar sesión</a></li>						
					<%} %>

	
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- fin de menu -->














<jsp:include page="<%= destino %>"></jsp:include> 


		

		
	<%}%>
	
	


<!-- SCRIPT BOOSTRAP -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.validate.js"></script>
	<script src="js/js_login.js"></script>	
	<script src="js/autocompletar.js"></script>			
	
</body>
</html>