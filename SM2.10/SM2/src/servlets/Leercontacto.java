package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ContactoBeanLocal;
import entities.EContact;

@WebServlet("/Leercontacto")
public class Leercontacto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ContactoBeanLocal cb; 
	
    public Leercontacto() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtiene los datos de un contacto, ahora id 1
		int id = Integer.parseInt(request.getParameter("contacto"));
		
		//conociendo el id
		EContact contact = cb.buscarContact(id);
		request.setAttribute("contacto", contact);

		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/datos-contacto.jsp");
	    dispatcher.forward( request, response );
	    return;
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
