package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Vistamailing")
public class Vistamailing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Vistamailing() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//debe llevar a un form con un select donde aparecen responsables de usuario.
		//al elegir u responsable de usuario se mostraran los que tiene y se podran imprimir
		//lo cual lleva al servlet mailingprint
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
