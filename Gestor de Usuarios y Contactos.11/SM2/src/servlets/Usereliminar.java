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

import beans.ContactoBeanLocal;
import beans.UserbeanLocal;
import classes.Navegacion;
import entities.EContact;
import entities.EUser;

@WebServlet("/Usereliminar")
public class Usereliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserbeanLocal ub; 
	
    public Usereliminar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("user");
		Navegacion nv = new Navegacion("buscaruser.jsp");
		HttpSession objsession = request.getSession(true);
		objsession.setAttribute("navegacion", nv);
		
		if (id != null){
			int iduser = Integer.parseInt(id);
			ub.deleteUser(iduser);
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/panel.jsp");
	    dispatcher.forward( request, response );
	    return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
