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

@WebServlet("/Contactoguardar")
public class Contactoguardar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private ContactoBeanLocal cb; 
	
    public Contactoguardar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = (String) request.getParameter("accion");
		String param = request.getParameter("contacto");
		Integer accionid = Integer.parseInt(accion);
		int contacto = Integer.parseInt(param);
		
		
		if(!accionid.equals("")){
			if(accionid == 1){
				cb.createContact(request);
			}else if(accionid == 2 && contacto != 0 ){
				cb.updateContact(request, contacto);
			}			
		}
		
		Navegacion nv = new Navegacion("buscarcontacto.jsp");
		HttpSession objsession = request.getSession(true);
		objsession.setAttribute("navegacion", nv);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/panel.jsp");
	    dispatcher.forward( request, response );
	    return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
