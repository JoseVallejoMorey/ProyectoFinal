<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="classes.User"%>
<%
	Integer accion = (request.getAttribute("accion") != null) ? (Integer) request.getAttribute("accion") : null;

	User user = null;
	HttpSession objsession = request.getSession();
	if ((objsession != null) || (!objsession.equals(""))) {
		user = (User) objsession.getAttribute("user");
	}

	String action = "";
	String param = "";
	String disabled = "";

	switch (accion) {
	case 1:
		//crear nuevo usuario
		action = "Contactoguardar";
		param = "1";

		break;
	case 2:
		//modificar datos
		action = "Contactoguardar";
		param = "2";
		break;
	default:
		//este caso sera leer
		action = "";
		disabled = "disabled";
		break;
	}

	//si es leer y los permisos son < 3 muestra 
	//eliminar y modificar
	//sino no nada

	//si es agregar nuevo 
	//consulta nuevamente los permisos, 
	//si es < 3 mostrara
	//mailing y guardar
	//sino le tratara como solo leer

	//si es modificar
	//consulta permisos
	//si es < 3 mostrara
	//eliminar y modificar
	//sino le tratara como solo leer
%>


<jsp:useBean id="contacto" class="entities.EContact" scope="request"></jsp:useBean>


<!-- PANEL FORM -->
<div class="text-center" style="padding: 10px 0">
	<div class="logo">
		<img alt="logo" src="img/logo.png">
	</div>

	<div class="container">
		<div class="panel panel-danger">
			<div class="panel-heading">Agregar Nuevo</div>
			<div class="panel-body">
				<!-- Main Form -->
				<form id="contact-form" action="<%=action%>" method="post">
					<input type="hidden" name="accion" value="${accion}" /> 
					<input type="hidden" name="contacto" value="<%=contacto != null ? contacto.getId() : "0"%>" />

					<div class="col-md-12 col-sm-12">

						<div class="form-group col-md-4 col-sm-4">
							<input type="text" class="form-control input-sm" name="nombre"
								<%=disabled%> placeholder="Nombre:"
								value="<%=(contacto.getNombre() != null) ? contacto.getNombre() : ""%>">
						</div>

						<div class="form-group col-md-4 col-sm-4">
							<input type="text" class="form-control input-sm" name="apellidos"
								placeholder="Apellidos:" <%=disabled%>
								value="<%=(contacto.getApellidos() != null) ? contacto.getApellidos() : ""%>">
						</div>

						<div class="form-group col-md-4 col-sm-4">
							<input type="text" class="form-control input-sm" name="empresa"
								<%=disabled%> placeholder="Empresa:"
								value="<%=(contacto.getEmpresa() != null) ? contacto.getEmpresa() : ""%>">
						</div>

						<div class="form-group col-md-4 col-sm-4">
							<input type="text" class="form-control input-sm" name="cargo"
								<%=disabled%> placeholder="Cargo:"
								value="<%=(contacto.getCargo() != null) ? contacto.getCargo() : ""%>">
						</div>

						<div class="form-group col-md-4 col-sm-4">
							<input type="text" class="form-control input-sm" name="telefono"
								placeholder="Teléfono:" <%=disabled%>
								value="<%=(contacto.getTelefono() != 0) ? contacto.getTelefono() : ""%>">
						</div>

						<div class="form-group col-md-4 col-sm-4">
							<input type="text" class="form-control input-sm" name="email"
								placeholder="E-mail:" <%=disabled%>
								value="<%=(contacto.getEmail() != null) ? contacto.getEmail() : ""%>">
						</div>
						<div class="form-group col-md-4 col-sm-4">
							<input type="text" class="form-control input-sm" name="direccion"
								placeholder="Dirección:" <%=disabled%>
								value="<%=(contacto.getDireccion() != null) ? contacto.getDireccion() : ""%>">
						</div>
						<div class="form-group col-md-4 col-sm-4">
							<input type="text" class="form-control input-sm" name="ciudad"
								placeholder="Ciudad:" <%=disabled%>
								value="<%=(contacto.getCiudad() != null) ? contacto.getCiudad() : ""%>">
						</div>
						<div class="form-group col-md-4 col-sm-4">
							<input type="text" class="form-control input-sm" name="provincia"
								placeholder="Provincia:" <%=disabled%>
								value="<%=(contacto.getProvincia() != null) ? contacto.getProvincia() : ""%>">
						</div>
						<div class="form-group col-md-4 col-sm-4">
							<input type="text" class="form-control input-sm" name="cp"
								placeholder="Codigo postal:" <%=disabled%>
								value="<%=(contacto.getCp() != 0) ? contacto.getCp() : ""%>">
						</div>
						<div class="form-group col-md-4 col-sm-4">
							<input type="text" class="form-control input-sm" name="region"
								placeholder="Region:" <%=disabled%>
								value="<%=(contacto.getRegion() != null) ? contacto.getRegion() : ""%>">
						</div>
						<div class="form-group col-md-4 col-sm-4">
							<input type="text" class="form-control input-sm" name="pais"
								placeholder="Pais:" <%=disabled%>
								value="<%=(contacto.getPais() != null) ? contacto.getPais() : ""%>">
						</div>
					</div>

					<div class="form-group col-md-12 col-sm-12">

						<div class="form-group col-md-4 col-sm-4">
							<input type="text" class="form-control input-sm" name="web"
								<%=disabled%> placeholder="Web:"
								value="<%=(contacto.getWeb() != null) ? contacto.getWeb() : ""%>">
						</div>
						<div class="form-group col-md-12 col-sm-12">
							<textarea class="form-control input-sm" name="observaciones"
								rows="3" placeholder="Observaciones:" <%=disabled%>
								value="<%=(contacto.getObservaciones() != null) ? contacto.getObservaciones() : ""%>"></textarea>
						</div>
						<div class="form-group col-md-4 col-sm-4">
							<input type="text" class="form-control input-sm" <%=disabled%>
								name="responsable" placeholder="Propietario del contacto:"
								value="<%=(contacto.getResponsableContacto() != null) ? contacto.getResponsableContacto() : ""%>">
						</div>
					</div>

					<div class="form-group col-md-12 col-sm-12">

						<div class="form-group col-md-4 col-sm-4">

							<div class="checkbox checkbox-circle">

								<label for="checkbox"> Mailing </label> <select name="mailing"
									<%=disabled%>>
									<option value="true">Si</option>
									<option value="false" checked>No</option>
								</select>

							</div>
						</div>



					</div>

					<div class="form-group col-md-12 col-sm-12">


						<%
							if (user.getPermiso() < 3) {
								if (accion == 1 || accion.equals(1)) {
						%>
						<div class="form-group col-md-4 col-sm-4">
							<a class="btn icon-btn btn-default" href="#"><span
								class="glyphicon btn-glyphicon glyphicon glyphicon-floppy-disk img-circle text-muted">
									<input type="submit" value="Guardar" />
						</div>
						<%
							} else {
						%>



						<div class="form-group col-md-4 col-sm-4">
							<a class="btn icon-btn btn-default"
								href="Contactoeliminar?contacto=<%=contacto.getId()%>"><span
								class="glyphicon btn-glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>Eliminar</a>
						</div>

						<div class="form-group col-md-4 col-sm-4">
							<a class="btn icon-btn btn-default"
								href="Contactoeditar?contacto=<%=contacto.getId()%>"><span
								class="glyphicon btn-glyphicon glyphicon glyphicon-erase img-circle text-info"></span>Modificar</a>
						</div>
						<%
							}
						%>

						<%
							}
						%>




						<div class="form-group col-md-4 col-sm-4">
							<a class="btn icon-btn btn-default" href="#"><span
								class="glyphicon btn-glyphicon glyphicon glyphicon-star img-circle text-warning"></span>Favorito</a>
						</div>


					</div>

				</form>
			</div>
		</div>

		<!-- end:Main Form -->
	</div>