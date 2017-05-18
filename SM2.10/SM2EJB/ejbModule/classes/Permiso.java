package classes;

public class Permiso {
	
	
	private String servlet;
	private String include;
	private String userType;
	
	private boolean permiso;
	
	public Permiso (String servlet, int nivelPermiso){
		this.servlet = servlet;
		switch(nivelPermiso){
		case 1: 	this.userType = "administrador";	break;
		case 2: 	this.userType = "redactor";			break;
		default:	this.userType = "lector";			break;
		}
		
		String sql = "SELECT * FROM permisos WHERE servlet="+this.servlet+" LIMIT 1";
		//hacer conexion a db
		//comprobar si usertype para ese servlet es 0 o 1
		//vincular a permiso
	}
	


	public String getUserType() {
		return userType;
	}
	public boolean isPermiso() {
		return permiso;
	}
	public String getServlet() {
		return servlet;
	}
	public String getInclude() {
		return include;
	}

	
	
	
	

}
