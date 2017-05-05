//aqui viene un formulrio con los datos del contacto

<%

System.out.println(request.getAttribute("accion"));
Integer accion = (Integer) request.getAttribute("accion");

switch(accion){
	case 1:
		
	break;
	case 2:
		
	break;
	default: 
		//este caso sera leer
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