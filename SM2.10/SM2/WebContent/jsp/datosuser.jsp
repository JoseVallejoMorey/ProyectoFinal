<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="classes.*" %>

<%
	System.out.println("accion es: "+request.getAttribute("accion"));
	Integer accion = (Integer) request.getAttribute("accion");
	User user = null;
	HttpSession objsession = request.getSession();
	if( (objsession != null) || (!objsession.equals("")) ){
		user = (User)objsession.getAttribute("user");
	}
	
	
	String action = "";
	String disabled = "";
	
	switch (accion) {
	case 1:
		//crear nuevo usuario
		action = "Userguardar";
		break;
	case 2:
		//modificar datos
		action="Userguardar";
		break;
	default:
		//este caso sera leer
		action="";
		disabled = "disabled";
		break;
	}
%>



<jsp:useBean id="userdb" class="entities.EUser" scope="request"></jsp:useBean>

<!-- PANEL FORM -->
<div class="text-center" style="padding: 10px 0">
	<div class="logo">
		<img alt="logo" src="img/logo.png">
	</div>

	<div class="container">
		<div class="panel panel-danger">
			<div class="panel-heading">Panel de busqueda</div>
			<div class="panel-body">
				<!-- Main Form -->
				<form action="<%=action%>" method="post">
					<input type="hidden" name="accion" value="${accion}" /> 
					<input type="hidden" name="user" value="<%=userdb != null ? userdb.getUserid() : "0"%>" />
					<div class="col-md-12 col-sm-12">
						<div class="form-group col-md-3 col-sm-3">
							<div class="panel panel-default">
								<div class="panel-body">
									<label for="nombre">Nombre</label> 
									<input type="text" <%=disabled%>
										class="form-control input-sm" name="nombre" id="nombre" placeholder="">
								</div>
							</div>
						</div>

						<div class="form-group col-md-3 col-sm-3">
							<div class="panel panel-default">
								<div class="panel-body">
									<label for="email">E-mail</label> 
									<input type="text" <%=disabled%>
										class="form-control input-sm" name="email" id="email" placeholder="">
								</div>
							</div>
						</div>

						<div class="form-group col-md-3 col-sm-3">
							<div class="panel panel-default">
								<div class="panel-body">
									<label for="pass">Contraseña</label> 
									<input type="text" <%=disabled%>
										class="form-control input-sm" name="pass" id="pass" placeholder="">
								</div>
							</div>
						</div>

						<div class="form-group col-md-3 col-sm-3">
							<div class="panel panel-default">
								<div class="panel-body bordepermisos">

									<div class="form-group">
										<label for="sel1">Permisos</label> 
										<select class="form-control labelpermisos" id="sel1 <%=disabled%>" name="permiso">
											<option value="1">Administrador</option>
											<option value="2">Redactor</option>
											<option value="3">Lector</option>
										</select>
									</div>
								</div>

							</div>
						</div>

						<div class="form-group col-md-12 col-sm-12">
							<% if(user.getPermiso()<3){
								System.out.println("accion es________________ "+accion);
							if(accion == 2 || accion == 1){%>
								<div class="form-group col-md-4 col-sm-4">
								<a class="btn icon-btn btn-default" href="#"><span
									class="glyphicon btn-glyphicon glyphicon glyphicon-floppy-disk img-circle text-muted">
										<input type="submit" value="Guardar" />
							</div>							
							<%}else{%>
								
								<div class="form-group col-md-4 col-sm-4">
								<a class="btn icon-btn btn-default" href="Contactoeliminar?contacto="+${ user.getId() }"><span
									class="glyphicon btn-glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>Eliminar</a>
								</div>
	
								<div class="form-group col-md-4 col-sm-4">
									<a class="btn icon-btn btn-default" href="Contactoeditar?contacto="+${ user.getId() }"><span
										class="glyphicon btn-glyphicon glyphicon glyphicon-erase img-circle text-info"></span>Modificar</a>
								</div>						
							<%}%>
							
							<%}%>


						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- end:Main Form -->