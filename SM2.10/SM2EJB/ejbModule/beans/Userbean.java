package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import classes.User;
import entities.EUser;


@Stateless
@LocalBean
public class Userbean implements UserbeanRemote, UserbeanLocal {
	
	@PersistenceContext(unitName="SM2EJB")
	private EntityManager em =null;
	
    public Userbean() {}

    

	@Override
	public User selectUser(String email, String pass) {
		
		
		PreparedStatement pst = null;
		ResultSet rs = null;

		InitialContext ctx;
		DataSource ds = null;
		
		try {
			ctx = new InitialContext();
			ds =  (DataSource) ctx.lookup("java:/DSMySQL");
		} catch (NamingException e1) {
			// error in datasource
			e1.printStackTrace();
		}
		
		Connection con = null;
		User user = null;
		
		try{			
			con=(Connection) ds.getConnection();
			String consulta = "select * from usuarios where email = ? and pass = ?";
			pst = con.prepareStatement(consulta);
			pst.setString(1,email);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			if(rs.absolute(1)){
				//coinciden en db
				int dbId = rs.getInt("id");
				int dbPermiso = rs.getInt("permisos");
				String dbEmail = rs.getString("email");
				user = new User(dbId,dbEmail,dbPermiso);
			}else{
				System.out.println("Usuario no encontrado");
			}
		}catch(Exception e){
			System.err.println("Error"+e);
		}finally{
			try{
				if(con != null) con.close();
				if(pst != null) pst.close();
				if(rs != null) rs.close();
			}catch(Exception e){
				System.err.println("Error"+e);
			}
		}	
		return user;
	}

	@Override
	public void createUser(HttpServletRequest request) {
		// recibo parametros
		String nombre = request.getParameter("nombre");
		System.out.println(nombre);
		String email  = request.getParameter("email");
		System.out.println(email);
		String pass   = request.getParameter("pass");
		System.out.println(pass);
		String permiso   = request.getParameter("permiso");
		System.out.println(permiso);
		
		int intpermiso = Integer.parseInt(permiso);
		//asigno parametros al entitie
		EUser user = new EUser();
		user.setEmail(email);
		user.setPass(pass);
		user.setPermiso(intpermiso);
		//doy persistencia al entitie
		em.persist(user);
		
	}

	@Override
	public void updateUser(HttpServletRequest request, int id) {
		//busco en bd
		EUser user = em.find(EUser.class, id);
		// recibo parametros
		String nombre = request.getParameter("nombre");
		System.out.println(nombre);
		String email  = request.getParameter("email");
		System.out.println(email);
		String pass   = request.getParameter("pass");
		System.out.println(pass);
		int permiso   = Integer.parseInt(request.getParameter("permiso"));
		System.out.println(permiso);
		
		//abro transaction
		//em.getTransaction().begin();
		//asigno parametros al entitie
		user.setEmail(email);
		user.setPass(pass);
		user.setPermiso(permiso);
		//cierro transaction
		//em.getTransaction().commit();
	}


	@Override
	public void deleteUser(int id) {
		EUser user = em.find(EUser.class, id);
		em.remove(user);
		
	}

	@Override
	public EUser buscarUser(int id) {
		return em.find(EUser.class, id);
	}

}

