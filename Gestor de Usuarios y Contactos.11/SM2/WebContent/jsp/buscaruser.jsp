<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- PANEL FORM -->
<div class="text-center" style="padding: 10px 0">
	<div class="logo">
		<img alt="logo" src="img/logo.png">
	</div>

	<div class="container">
		<div class="panel panel-danger">
			<div class="panel-heading">Busqueda de usuarios</div>
			<div class="panel-body">
				<!-- Main Form -->
				<form id="buscaruser" method="post" acction="Buscadorusuario">
					<div class="col-md-12 col-sm-12">
						<div class="form-group col-md-4 col-sm-4">
							<div class="panel panel-default">
								<div class="panel-body">
									<label for="nombre">Nombre</label> <input type="text"
										class="form-control input-sm" name="nombre" id="nombre" placeholder="">
								</div>
							</div>
						</div>

						<div class="form-group col-md-4 col-sm-4">
							<div class="panel panel-default">
								<div class="panel-body">
									<label for="email">E-mail</label> <input type="text"
										class="form-control input-sm" name="email" id="email" placeholder="">
								</div>
							</div>
						</div>

						<div class="form-group col-md-4 col-sm-4">
							<div class="panel panel-default">
								<div class="panel-body bordepermisos">

									<div class="form-group">
										<label for="sel1">Permisos</label> 
										<select class="form-control labelpermisos" id="sel1" name="permiso">
											<option checked value="0">Todos</option>
											<option value="1">Administrador</option>
											<option value="2">Redactor</option>
											<option value="3">Lector</option>
										</select>
									</div>
								</div>

							</div>
						</div>

					</div>
					<div id="ancla" class="col-md-9">
						<div id="ancla" class="sujerencia-response sujerencia-off"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- end:Main Form -->