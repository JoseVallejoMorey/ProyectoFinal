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
import classes.Navegacion;
import entities.EContact;

@WebServlet("/Contactoleer")
public class Contactoleer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ContactoBeanLocal cb; 
	
    public Contactoleer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int id = Integer.parseInt(request.getParameter("contacto"));
		String id = request.getParameter("contacto");
		Navegacion nv = new Navegacion("datoscontacto.jsp");
		
		if (id != null){
			int iduser = Integer.parseInt(id);
			EContact contact = cb.buscarContact(iduser);
			request.setAttribute("contacto", contact);		
			request.setAttribute("accion", 3);
			
			HttpSession objsession = request.getSession(true);
			objsession.setAttribute("navegacion", nv);
		}


		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/panel.jsp");
	    dispatcher.forward( request, response );
	    return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
