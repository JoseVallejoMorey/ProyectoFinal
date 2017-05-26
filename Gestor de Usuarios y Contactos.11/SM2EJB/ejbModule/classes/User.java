package classes;

public class User {

	private int id;
	private String name;
	private String email;
	private int permiso;
	
	public User(int id, String name, String email, int permiso){
		this.id = id;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}


