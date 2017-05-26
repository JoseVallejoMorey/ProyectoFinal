package beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import classes.Contacto;
import entities.EContact;

/**
 * Session Bean implementation class ContactoBean
 */
@Stateless
public class ContactoBean implements ContactoBeanRemote, ContactoBeanLocal {

	@PersistenceContext(unitName="SM2EJB")
	private EntityManager em;

    public ContactoBean() {
        // TODO Auto-generated constructor stub
    }

   
	@Override
	public void updateContact(HttpServletRequest request,int id) {
		EContact contact = em.find(EContact.class, id);

		  
		String nombre = request.getParameter("nombre");		
		String apellido = request.getParameter("apellidos");
		String empresa = request.getParameter("empresa");
		String cargo = request.getParameter("cargo");
		String email = request.getParameter("email");
		String web = request.getParameter("web");
		String observaciones= request.getParameter("observaciones");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		String mailing = (String) request.getAttribute("mailing");

		em.getTransaction().begin();
		
		contact.setNombre(nombre);
		contact.setApellidos(apellido);
		contact.setEmpresa(empresa);
		contact.setCargo(cargo);
		contact.setTelefono(telefono);
		contact.setEmail(email);
		contact.setWeb(web);
		contact.setObservaciones(observaciones);
		contact.setMailing(mailing);
		
		em.getTransaction().commit();
	}

	@Override
	public void deleteContact(int id) {
		EContact contact = em.find(EContact.class, id);
		if(contact != null){
			em.remove(contact);
		}
		
	}

	@Override
	public EContact buscarContact(int id) {
		return em.find(EContact.class, id);
	}


	@Override
	public int createContact(HttpServletRequest request) {

		String nombre = (request.getParameter("nombre") != null)?request.getParameter("nombre") : null;
		String apellido = (request.getParameter("apellidos") != null)?request.getParameter("apellidos") : null;
		String empresa = (request.getParameter("empresa") != null)?request.getParameter("empresa") : null;
		String cargo = (request.getParameter("cargo") != null)?request.getParameter("cargo") : null;
		String direccion = (request.getParameter("direccion") != null)?request.getParameter("direccion") : null;
		String ciudad = (request.getParameter("ciudad") != null)?request.getParameter("ciudad") : null;
		String provincia = (request.getParameter("provincia") != null)?request.getParameter("provincia") : null;
		String cp = (request.getParameter("cp") != null)? request.getParameter("cp") : null;
		String region = (request.getParameter("region") != null)?request.getParameter("region") : null;
		String pais = (request.getParameter("pais") != null)?request.getParameter("pais") : null;
		String email = (request.getParameter("email") != null)?request.getParameter("email") : null;
		String web = (request.getParameter("web") != null)?request.getParameter("web") : null;
		String observaciones = (request.getParameter("observaciones") != null)?request.getParameter("observaciones") : null;
		String responsable = (request.getParameter("responsable") != null)?request.getParameter("responsable") : null;
		String telefono = (request.getParameter("telefono") != null)? request.getParameter("telefono") : null;
		String mailing = (request.getParameter("mailing") != null)? request.getParameter("mailing") : null;
		
		int intcp = (!cp.equals("")) ? Integer.parseInt(cp) :0;
		int inttelefono = (!cp.equals("")) ? Integer.parseInt(telefono) :0;
		
		EContact contact = new EContact();
		
		if(nombre != null) { contact.setNombre(nombre);}
		if(apellido != null) {contact.setApellidos(apellido);}
		if(empresa != null) {contact.setEmpresa(empresa);}
		if(cargo != null) {contact.setCargo(cargo);}
		if(direccion != null) {contact.setDireccion(direccion);}
		if(ciudad != null) {contact.setCiudad(ciudad);}
		if(provincia != null) {contact.setProvincia(provincia);}
		if(intcp != 0) {contact.setCp(intcp);}
		if(region != null) {contact.setRegion(region);}
		if(pais != null) {contact.setPais(pais);}
		if(inttelefono != 0) {contact.setTelefono(inttelefono);}
		if(email != null) {contact.setEmail(email);}
		if(web != null) {contact.setWeb(web);}
		if(observaciones != null) {contact.setObservaciones(observaciones);}
		if(responsable != null) {contact.setResponsableContacto(responsable);}
		contact.setMailing(mailing);
		
		em.persist(contact);
		
		return contact.getId();
		
	}


	@Override
	public  ArrayList<Contacto> getByField(HttpServletRequest request) {
		
		InitialContext ctx;	
		DataSource ds = null;	
		Connection con = null;	
		Statement stm = null;
		ResultSet rs = null;
		request.getParameterNames();

		String nombre = request.getParameter("name");
		String apellidos = request.getParameter("surname"); 
		String empresa = request.getParameter("empresa");
		String telefono = request.getParameter("telefono");
		ArrayList<Contacto> contactosList = new ArrayList<Contacto>();
		
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/DSMySQL");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		String fields = "id, nombre, apellidos, empresa";
		String like = "";
		String and = "";
		
		if(nombre != null && !nombre.equals("")){
			like = like+" nombre LIKE '"+nombre+"%'";
			and = " AND ";
		}
		if(apellidos != null && !apellidos.equals("")){
			like = like+and+" apellidos LIKE '"+apellidos+"%'";
			and = " AND ";
		}
		if(empresa != null && !empresa.equals("")){
			like = like+and+" empresa LIKE '"+empresa+"%'";
			and = " AND";
		}
		if(telefono != null && !telefono.equals("") ){
			like = like+and+" telefono LIKE '"+telefono+"%'";
		}
		
		try {
			con = ds.getConnection();
			String sql = "SELECT "+fields+" FROM contactos WHERE"+like+" LIMIT 5";
			//System.out.println(sql);
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			if(rs != null){
				while(rs.next()) {
				    contactosList.add(new Contacto(rs.getInt("id"),rs.getString("nombre"), rs.getString("apellidos"), rs.getString("empresa")));
				}				
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			if(con != null) con.close();
			if(stm != null) stm.close();
			if(rs != null) rs.close();
		}catch(Exception e){
			System.err.println("Error"+e);
		}
		
		return contactosList;
		
	}


	
	
	
	@Override
	public  ArrayList<Contacto> getByResponsable(HttpServletRequest request) {
		
		InitialContext ctx;	
		DataSource ds = null;	
		Connection con = null;	
		Statement stm = null;
		ResultSet rs = null;
		request.getParameterNames();

		String responsable = request.getParameter("responsable");
		ArrayList<Contacto> contactosList = new ArrayList<Contacto>();
		
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/DSMySQL");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		String fields = "id, nombre, apellidos, empresa";

		
		try {
			con = ds.getConnection();
			String sql = "SELECT "+fields+" FROM contactos WHERE responsable='"+responsable+"' LIMIT 5";
			//System.out.println(sql);
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			if(rs != null){
				while(rs.next()) {
				    contactosList.add(new Contacto(rs.getInt("id"),rs.getString("nombre"), rs.getString("apellidos"), rs.getString("empresa")));
				}				
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			if(con != null) con.close();
			if(stm != null) stm.close();
			if(rs != null) rs.close();
		}catch(Exception e){
			System.err.println("Error"+e);
		}
		
		return contactosList;
		
	}
	
	
	
	
	
	
	@Override
	public String[] getResponsables() {
		
		InitialContext ctx;	
		DataSource ds = null;	
		Connection con = null;	
		Statement stm = null;
		ResultSet rs = null;


		String[] responsables = null;
		String sql = "SELECT DISTINCT responsable FROM contactos";
		try {
			
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/DSMySQL");
			con = ds.getConnection();
			//System.out.println(sql);
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			
			int size= 0;
			int i = 0;	
			if (rs != null)   {  
				rs.beforeFirst();  
			  	rs.last();  
			  	size = rs.getRow();  
			  	rs.beforeFirst(); 
				responsables = new String[size];
						  
				while(rs.next()) {
					if(!rs.getString("responsable").equals("")){
						responsables[i] = rs.getString("responsable");
					 	i++;
					}
				}				  
			  
			}  
			
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			//System.out.println("erorr en getResponsables");
			e.printStackTrace();
		}
		
		try{
			if(con != null) con.close();
			if(stm != null) stm.close();
			if(rs != null) rs.close();
		}catch(Exception e){
			System.err.println("Error"+e);
		}
		
		return responsables;
	}
	
	
}

