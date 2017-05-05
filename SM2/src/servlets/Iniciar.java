package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.User;
import controlador.Conexion;


/**
 * Servlet implementation class Iniciar
 */
@WebServlet("/Iniciar")
public class Iniciar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Iniciar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		Conexion con = new Conexion();
		
		
		try{
			String consulta = "select * from usuarios where email = ? and pass = ?";
			pst = con.getConexion().prepareStatement(consulta);
			pst.setString(1,email);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			
			if(rs.absolute(1)){
				
				//coinciden en db
				int dbId = rs.getInt("id");
				int dbPermiso = rs.getInt("permisos");
				String dbEmail = rs.getString("email");
				
				User user = new User(dbId,dbEmail,dbPermiso);
				HttpSession objsession = request.getSession(true);
				objsession.setAttribute("user", user);
				
				 RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/panel.jsp");
					    dispatcher.forward( request, response ); 
				
				

				
			}else{
				System.out.println("Fatal fail____________________________");
			}
			
		}catch(Exception e){
			System.err.println("Error"+e);
		}finally{
			try{
				if(con.getConexion() != null) con.getConexion().close();
				if(pst != null) pst.close();
				if(rs != null) rs.close();
			}catch(Exception e){
				System.err.println("Error"+e);
			}
		}		
		
		
		
//		Consultas con = new Consultas();
//		if(con.autenticacion(email, pass)){
//			
//			User = new User();

//			response.sendRedirect("panel.jsp");
//		}else{
//			response.sendRedirect("index.jsp");
//		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
