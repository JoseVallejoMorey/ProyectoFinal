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

import beans.UserbeanLocal;
import classes.Navegacion;
import classes.User;



@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		UserbeanLocal ejb = null;
		InitialContext ctx = null;
		
		try {
			ctx = new InitialContext();
			ejb =  (UserbeanLocal) ctx.lookup("java:app/SM2EJB/Userbean!beans.UserbeanLocal");	
			User user = ejb.selectUser(email, pass);
			Navegacion nv = new Navegacion("buscarcontacto.jsp");
			
			if(user != null){
				HttpSession objsession = request.getSession(true);
				objsession.setAttribute("user", user);
				objsession.setAttribute("navegacion", nv);
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/panel.jsp");
			dispatcher.forward( request, response ); 	
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
