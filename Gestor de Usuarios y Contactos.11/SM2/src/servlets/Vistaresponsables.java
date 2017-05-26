package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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
import classes.Contacto;
import classes.Navegacion;

@WebServlet("/Vistaresponsables")
public class Vistaresponsables extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Vistaresponsables() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Navegacion nv = new Navegacion("vistamailing.jsp");
		HttpSession objsession = request.getSession(true);
		objsession.setAttribute("navegacion", nv);
		
		String responsable = request.getParameter("responsable");
		
		
		ContactoBeanLocal ejb = null;
		InitialContext ctx = null;
		
		try {
			ctx = new InitialContext();
			ejb = (ContactoBeanLocal) ctx.lookup("java:app/SM2EJB/ContactoBean!beans.ContactoBeanLocal");
	
			//ejecurara la consulta y traera resultados
			ArrayList<Contacto> lista = ejb.getByResponsable(request);		

			String ul = "<ul>";
			
			Iterator<Contacto> it = lista.iterator();
			if(it.hasNext()){
				while (it.hasNext()) {
					Contacto contacto = (Contacto) it.next();
					ul = ul+"<li>"	+contacto.getNombre()+", "
							   		+contacto.getApellidos()+", "
							   		+contacto.getEmpresa()+"</li>";
				}
			}else{
				ul = ul+"<li>No hay resultados.</li>";
			}
			
			ul = ul+"</ul>";

		    response.getWriter().write(ul);       // Write response body.
		    

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
