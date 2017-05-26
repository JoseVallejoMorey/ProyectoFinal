package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="usuarios")
public class EUser implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="id")
	private int userId;
	@Column(name="email")
	private String email;
	@Column(name="pass")
	private String pass;
	@Column(name="permisos")
	private int permiso;
	@Column(name="nombre")
	private String nombre;
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getPermiso() {
		return permiso;
	}
	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}
	
	
	
	
}
