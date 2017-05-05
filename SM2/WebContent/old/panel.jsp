<%@page import="clases.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" session="true" %>
<%@page import="clases.User" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Esto es panel</title>
</head>
<body>


<a href="Logout">Cerrar Sesion</a>



<%	


//System.out.println("Is de session _______________"+request.getSession().getId());
//System.out.println("servlet context______________"+request.getSession().getServletContext());
//System.out.println("session context______________"+request.getSession().getSessionContext());


    
	HttpSession objsession = request.getSession();
	
	if( (objsession == null) || (objsession.equals("")) ){
		
		System.out.println("objsession es NULL");
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	    dispatcher.forward( request, response );
	    return;
	}else{
		
		User user = (User)objsession.getAttribute("user");	
		System.out.println("-email____________"+user.getEmail());
		System.out.println("-id user____________"+user.getId());
		System.out.println("-permisos____________"+user.getPermiso());
		//out.println("<script> console.log('permisos __________'+ user.getPermiso())</script>");
		
		//obtener
		if(user.getPermiso()<3){
			//mostrar boton de agrear nuevo 
			%><a href="nuevocontactoservlet"> Agregar Nuevo </a> <%
		}
		
		
		//mostrar contacto (acceso a datos de contacto se muestra a todos)
		%><a href="modificarcontacto"> Agregar Nuevo </a> <%
	}
	%>
	






</body>
</html>