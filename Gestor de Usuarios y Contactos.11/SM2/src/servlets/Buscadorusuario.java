package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserbeanLocal;
import classes.Navegacion;
import classes.User;

@WebServlet("/Buscadorusuario")
public class Buscadorusuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Buscadorusuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Navegacion nv = new Navegacion("buscarcontacto.jsp");
		HttpSession objsession = request.getSession(true);
		objsession.setAttribute("navegacion", nv);
		
		UserbeanLocal ejb = null;
		InitialContext ctx = null;
		
		try {
			ctx = new InitialContext();
			ejb = (UserbeanLocal) ctx.lookup("java:app/SM2EJB/Userbean!beans.UserbeanLocal");
	
			//ejecurara la consulta y traera resultados
			ArrayList<User> lista = ejb.getByField(request);		

			String ul = "<ul>";
			Iterator<User> it = lista.iterator();
			
			if(it.hasNext()){
				while (it.hasNext()) {
					User user = (User) it.next();
					ul = ul+"<li><a href='Userleer?user="
							   +user.getId()+"'>"
							   +user.getName()+",  "
							   +user.getEmail()+"</a></li>";
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