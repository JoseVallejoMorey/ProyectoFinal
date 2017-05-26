package servlets;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ContactoBeanLocal;
import classes.*;

@WebServlet("/Vistamailing")
public class Vistamailing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Vistamailing() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Navegacion nv = new Navegacion("vistamailing.jsp");
		HttpSession objsession = request.getSession(true);
		objsession.setAttribute("navegacion", nv);
		
		
		//aqui es donde crea el array con los responsables
		//y lo pasa como parametro
		ContactoBeanLocal ejb = null;
		InitialContext ctx = null;
		try {
			ctx = new InitialContext();
			ejb = (ContactoBeanLocal) ctx.lookup("java:app/SM2EJB/ContactoBean!beans.ContactoBeanLocal");
			String[] responsables =  ejb.getResponsables();			
			
			request.setAttribute("responsables", responsables);
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/panel.jsp");
	    dispatcher.forward( request, response );
	    return;
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
