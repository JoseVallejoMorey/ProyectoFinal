<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="classes.*" %>

<%
	Integer accion = (request.getAttribute("accion") != null) ? (Integer) request.getAttribute("accion") : null;

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
			<div class="panel-heading">Datos de usuario</div>
			<div class="panel-body">
				<!-- Main Form -->
				<form action="<%=action%>" method="post">
					<input type="hidden" name="accion" value="${accion}" /> 
					<input type="hidden" name="user" value="<%=userdb != null ? userdb.getUserId() : "0"%>" />
					<div class="col-md-12 col-sm-12">
						<div class="form-group col-md-3 col-sm-3">
							<div class="panel panel-default">
								<div class="panel-body">
									<label for="nombre">Nombre</label> 
									<input type="text" <%=disabled%>
										class="form-control input-sm" name="nombre" id="nombre" placeholder=""
										value="<%=(userdb.getNombre() != null) ? userdb.getNombre() : ""%>">
								</div>
							</div>
						</div>

						<div class="form-group col-md-3 col-sm-3">
							<div class="panel panel-default">
								<div class="panel-body">
									<label for="email">E-mail</label> 
									<input type="text" <%=disabled%>
										class="form-control input-sm" name="email" id="email" placeholder=""
										value="<%=(userdb.getEmail() != null) ? userdb.getEmail() : ""%>">
								</div>
							</div>
						</div>

						<div class="form-group col-md-3 col-sm-3">
							<div class="panel panel-default">
								<div class="panel-body">
									<label for="pass">Contraseña</label> 
									<input type="text" <%=disabled%>
										class="form-control input-sm" name="pass" id="pass" placeholder=""
										value="<%=(userdb.getPass() != null) ? userdb.getPass() : ""%>">
								</div>
							</div>
						</div>

						<div class="form-group col-md-3 col-sm-3">
							<div class="panel panel-default">
								<div class="panel-body bordepermisos">

									<div class="form-group">
										<label for="sel1">Permisos</label> 
										<select class="form-control labelpermisos" id="sel1 <%=disabled%>" name="permiso">
											<option <%= userdb.getPermiso() == 1 ? "selected" : "" %> value="1">Administrador</option>
											<option <%= userdb.getPermiso() == 2 ? "selected" : "" %> value="2">Redactor</option>
											<option <%= userdb.getPermiso() == 3 ? "selected" : "" %> value="3">Lector</option>
										</select>
									</div>
								</div>

							</div>
						</div>

						<div class="form-group col-md-12 col-sm-12">
							<% if(user.getPermiso()<3){
		
								if(accion == 2 || accion == 1){%>
									<div class="form-group col-md-4 col-sm-4">
									<a class="btn icon-btn btn-default" href="#">
										<span class="glyphicon btn-glyphicon glyphicon glyphicon-floppy-disk img-circle text-muted"></span>
									</a>
									<input type="submit" value="Guardar" />
								</div>							
								<%}else{%>
									
									<div class="form-group col-md-4 col-sm-4 lisener2">
									<a class="btn icon-btn btn-default" href="Usereliminar?user=<%= userdb.getUserId() %>"><span
										class="glyphicon btn-glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>Eliminar</a>
									</div>
		
									<div class="form-group col-md-4 col-sm-4">
										<a class="btn icon-btn btn-default" href="Usereditar?user=<%= userdb.getUserId() %>"><span
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