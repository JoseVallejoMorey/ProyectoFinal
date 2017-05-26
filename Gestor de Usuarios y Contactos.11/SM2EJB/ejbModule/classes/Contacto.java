package classes;


public class Contacto {

	private int id;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String ciudad;
	private String provincia; 
	private String cp; 
	private String region; 
	private String pais; 
	private String empresa;
	private String cargo;
	private String email; 
	private String web; 
	private String responsableContacto; 
	private int telefono;	
	private boolean mailing;
	private String observaciones;

	
	public Contacto(int id, String nombre, String apellidos, String empresa){
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.empresa = empresa;
	}

	public Contacto(int id, String nombre, String apellidos, String empresa, String direccion, String cp, String provincia, String pais){
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.empresa = empresa;
		this.direccion = direccion;
		this.cp = cp;
		this.provincia = provincia;
		this.pais = pais;
	} 	
	
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getResponsableContacto() {
		return responsableContacto;
	}
	public void setResponsableContacto(String responsableContacto) {
		this.responsableContacto = responsableContacto;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public boolean isMailing() {
		return mailing;
	}
	public void setMailing(boolean mailing) {
		this.mailing = mailing;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	
	
	
	
	
	
}
