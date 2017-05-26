<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page import="beans.*" %>
<%@ page import="classes.*" %>
<%@ page import="java.util.*" %>

<%@ page import="javax.naming.InitialContext" %>


<%
String[] responsables = (String[]) request.getAttribute("responsables");
String code = "";
for (String string : responsables) {
	code = code+"<option>" + string + "</option>";
}

%>
							
							
<!-- PANEL FORM -->
<div class="text-center" style="padding: 10px 0">
	<div class="logo">
		<img alt="logo" src="img/logo.png">
	</div>

	<div class="container">
		<div class="panel panel-danger">
			<div class="panel-heading">Mailing</div>
			<div class="panel-body">
				<!-- Main Form -->

				<div class="col-md-12">
					<form id="imprimir" action="Imprimir" method ="post">
						<select name="responsable">
							<option value="">Seleccione</option>
							<%=code %>
						</select>
					<input type="submit" value="visualizar">
					</form>
				</div>			
				
				<div id="ancla" class="col-md-9">
					<div id="ancla" class="sujerencia-response sujerencia-off"></div>
				</div>

			</div>
		</div>
	</div>
</div>
<!-- end:Main Form -->