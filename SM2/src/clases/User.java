package clases;

public class User {

	private int id;
	private String email;
	private int permiso;
	
	
	public User(int id, String email, int permiso){
		
		this.id = id;
		this.email = email;
		this.permiso = permiso;
	}
	
	
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPermiso() {
		return permiso;
	}

	
}


