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

@WebServlet("/Usernuevo")
public class Usernuevo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Usernuevo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Navegacion nv = new Navegacion("datosuser.jsp");
		request.setAttribute("accion", 1);
		
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
