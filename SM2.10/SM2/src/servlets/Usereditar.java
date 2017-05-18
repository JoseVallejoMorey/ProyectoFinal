package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserbeanLocal;
import classes.Navegacion;
import entities.EUser;

@WebServlet("/Usereditar")
public class Usereditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private UserbeanLocal ub; 
	
    public Usereditar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("user");
		Navegacion nv = new Navegacion("datosuser.jsp");
		
		if (id != null){
			int iduser = Integer.parseInt(id);
			EUser user = ub.buscarUser(iduser);
			request.setAttribute("user", user);		
			request.setAttribute("accion", 1);
			
			HttpSession objsession = request.getSession(true);
			objsession.setAttribute("navegacion", nv);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/panel.jsp");
	    dispatcher.forward( request, response );
	    return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
