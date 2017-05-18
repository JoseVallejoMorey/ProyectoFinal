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
		
		int newid;
		if(!accionid.equals("")){
			if(accionid == 1){
				newid = cb.createContact(request);
				System.out.println("El nuevo id es:"+newid);
			}else if(accionid == 2 && contacto != 0 ){
				cb.updateContact(request, contacto);
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
