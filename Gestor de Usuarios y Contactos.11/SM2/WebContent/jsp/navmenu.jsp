

<?xml version="1.0" encoding="ISO-8859-1" ?>
<div class="container">
	<div class="col-md-12 col-sm-12">
		<div class="row">
			<div class="pull-right">
				<div class="dropdown">
					<button type="button" class="btn btn-danger btn-cons" id="dropdownMenu1" data-toggle="dropdown">Menu <span class="caret"></span></button>
					<ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu1">
					
					
					<c:choose>
					<c:when test="${user.getPermiso()==1}">
						<li><a href="Buscadorcontacto"><i class="glyphicon glyphicon-search"></i> Buscar contactos</a></li>
						<li><a href="Contactonuevo"><i class="glyphicon glyphicon-pencil"></i> Crear nuevo contacto</a></li>	
						<li><a href="Buscadorusuario"><i class="glyphicon glyphicon-search"></i> Buscar usuarios</a></li>	
						<li><a href="Usuariocrear"><i class="glyphicon glyphicon-pencil"></i> Crear nuevo usuario</a></li>
						<li><a href="Mailingleer"><i class="glyphicon glyphicon-envelope"></i> Mailing</a></li>
						<li><a href="Logout"><i class="glyphicon glyphicon-off"></i> Cerrar sesión</a></li>						
					
					</c:when>
					<c:when test="${user.getPermiso()==2}">
						<li><a href="Buscadorcontacto"><i class="glyphicon glyphicon-search"></i> Buscar contactos</a></li>
						<li><a href="Contactonuevo"><i class="glyphicon glyphicon-pencil"></i> Crear nuevo contacto</a></li>	
						<li><a href="Logout"><i class="glyphicon glyphicon-off"></i> Cerrar sesión</a></li>							
					</c:when>
					<c:othewhise>
						<li><a href="Buscadorcontacto"><i class="glyphicon glyphicon-search"></i> Buscar contactos</a></li>
						<li><a href="Logout"><i class="glyphicon glyphicon-off"></i> Cerrar sesión</a></li>	
					</c:othewhise>
					
					
					</c:choose>
					
					
					
	
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>