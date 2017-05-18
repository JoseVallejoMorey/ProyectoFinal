package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
import entities.EUser;

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
		System.out.println(nombre);	
		String apellido = request.getParameter("apellidos");
		System.out.println(apellido);
		String empresa = request.getParameter("empresa");
		System.out.println(empresa);
		String cargo = request.getParameter("cargo");
		System.out.println(cargo);
		String email = request.getParameter("email");
		System.out.println(email);
		String web = request.getParameter("web");
		System.out.println(web);
		String observaciones= request.getParameter("observaciones");
		System.out.println(observaciones);
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		System.out.println(telefono);
		String mailing = (String) request.getAttribute("mailing");
		System.out.println(mailing);
		

		//em.getTransaction().begin();
		
		contact.setNombre(nombre);
		contact.setApellidos(apellido);
		contact.setEmpresa(empresa);
		contact.setCargo(cargo);
		contact.setTelefono(telefono);
		contact.setEmail(email);
		contact.setWeb(web);
		contact.setMailing(mailing);
		
		//em.getTransaction().commit();
	}

	@Override
	public void deleteContact(int id) {
		EContact contact = em.find(EContact.class, id);
		em.remove(contact);
	}

	@Override
	public EContact buscarContact(int id) {
		return em.find(EContact.class, id);
	}


	@Override
	public int createContact(HttpServletRequest request) {
		System.out.println("en metodo createContact");
		
		String nombre = (request.getParameter("nombre") != null)?request.getParameter("nombre") : null;
				System.out.println(nombre);
		String apellido = (request.getParameter("apellidos") != null)?request.getParameter("apellidos") : null;
			System.out.println(apellido);
		String empresa = (request.getParameter("empresa") != null)?request.getParameter("empresa") : null;
		System.out.println(empresa);
		String cargo = (request.getParameter("cargo") != null)?request.getParameter("cargo") : null;
		System.out.println(cargo);
		String direccion = (request.getParameter("direccion") != null)?request.getParameter("direccion") : null;
		System.out.println(direccion);
		String ciudad = (request.getParameter("ciudad") != null)?request.getParameter("ciudad") : null;
		System.out.println(ciudad);
		String provincia = (request.getParameter("provincia") != null)?request.getParameter("provincia") : null;
		System.out.println(provincia);
		int cp = (request.getParameter("cp") != null)? Integer.parseInt(request.getParameter("cp")) : null;
		System.out.println(cp);
		String region = (request.getParameter("region") != null)?request.getParameter("region") : null;
		System.out.println(region);
		String pais = (request.getParameter("pais") != null)?request.getParameter("pais") : null;
		System.out.println(pais);
		String email = (request.getParameter("email") != null)?request.getParameter("email") : null;
		System.out.println(email);
		String web = (request.getParameter("web") != null)?request.getParameter("web") : null;
		System.out.println(web);
		String observaciones = (request.getParameter("observaciones") != null)?request.getParameter("observaciones") : null;
		System.out.println(observaciones);
		String responsable = (request.getParameter("responsable") != null)?request.getParameter("responsable") : null;
		System.out.println(responsable);
		int telefono = (request.getParameter("telefono") != null)? Integer.parseInt(request.getParameter("telefono")) : null;
		System.out.println(telefono);	
		String mailing = (request.getParameter("mailing") != null)? request.getParameter("mailing") : null;
		System.out.println(mailing);
		
		
		
		

	
	
	
		
		

		System.out.println("Despues de asignar del request a local");
		EContact contact = new EContact();
		
		if(nombre != null) { contact.setNombre(nombre);}
		if(apellido != null) {contact.setApellidos(apellido);}
		if(empresa != null) {contact.setEmpresa(empresa);}
		if(cargo != null) {contact.setCargo(cargo);}
		if(direccion != null) {contact.setDireccion(direccion);}
		if(ciudad != null) {contact.setCiudad(ciudad);}
		if(provincia != null) {contact.setProvincia(provincia);}
		if(cp != 0) {contact.setCp(cp);}
		if(region != null) {contact.setRegion(region);}
		if(pais != null) {contact.setPais(pais);}
		if(telefono != 0) {contact.setTelefono(telefono);}
		if(email != null) {contact.setEmail(email);}
		if(web != null) {contact.setWeb(web);}
		if(observaciones != null) {contact.setObservaciones(observaciones);}
		if(responsable != null) {contact.setResponsableContacto(responsable);}
		contact.setMailing(mailing);
		
		System.out.println("antes de guardar");
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
		Contacto contacto = null;
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
			System.out.println(sql);
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			
			while(rs.next()) {
			    contactosList.add(new Contacto(rs.getInt("id"),rs.getString("nombre"), rs.getString("apellidos"), rs.getString("empresa")));
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




	
	
	
}

