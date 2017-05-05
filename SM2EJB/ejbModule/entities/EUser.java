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
	private int userid;
	@Column(name="email")
	private String email;
	@Column(name="pass")
	private String pass;
	@Column(name="permiso")
	private int permiso;
	
	
	
	
}
