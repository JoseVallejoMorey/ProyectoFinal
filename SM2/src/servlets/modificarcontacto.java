package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/modificarcontacto")
public class modificarcontacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public modificarcontacto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//llevara a datos de contacto y alli comprobara nuevamente sus permisos
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/datos-contacto.jsp");
		
		request.setAttribute("accion", 2);
		
	    dispatcher.forward( request, response );
	    return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
