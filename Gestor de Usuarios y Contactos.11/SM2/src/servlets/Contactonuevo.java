package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Navegacion;

@WebServlet("/Contactonuevo")
public class Contactonuevo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Contactonuevo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Navegacion nv = new Navegacion("datoscontacto.jsp");
		HttpSession objsession = request.getSession(true);
		objsession.setAttribute("navegacion", nv);
		request.setAttribute("accion", 1);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/panel.jsp");
		dispatcher.forward( request, response ); 	
		return;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
