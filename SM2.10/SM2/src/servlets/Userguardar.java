package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserbeanLocal;

@WebServlet("/Userguardar")
public class Userguardar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserbeanLocal ub; 
    
	public Userguardar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = (String) request.getParameter("accion");
		String param = request.getParameter("user");
		Integer accionid = Integer.parseInt(accion);
		int userid = Integer.parseInt(param);
		
		if(!accionid.equals("")){
			if(accionid == 1){
				ub.createUser(request);

			}else if(accionid == 2 && userid != 0 ){
				ub.updateUser(request, userid);
			}			
		}
	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/panel.jsp");
	    dispatcher.forward( request, response );
	    return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
