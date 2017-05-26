package servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

import classes.Contacto;


@WebServlet("/Imprimir")
public class Imprimir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Imprimir() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("application/pdf");
		OutputStream out = response.getOutputStream();
		String nombre=request.getParameter("responsable");
				
				InitialContext ctx;	
				DataSource ds = null;
				Connection con=null;
				Statement st=null;
				ResultSet rs=null;
				
				ArrayList<Contacto> contactosList = new ArrayList<Contacto>();

				try {			
					ctx = new InitialContext();
					ds = (DataSource) ctx.lookup("java:/DSMySQL");
					con=ds.getConnection();
					st=con.createStatement();
					rs=st.executeQuery("SELECT * FROM contactos WHERE responsable='"+nombre+"' AND mailing='true'");
					
					
					if(rs != null){
						while(rs.next()) {
						    contactosList.add(new Contacto(rs.getInt("id"),
						    								   rs.getString("nombre"), 
						    								   rs.getString("apellidos"), 
						    								   rs.getString("empresa"),
						    								   rs.getString("direccion"),
						    								   rs.getString("cp"),
						    								   rs.getString("provincia"),
						    								   rs.getString("pais")));
						}				
						
						Document documento= new Document();
						try {
							PdfWriter.getInstance(documento, out);

							documento.open();
							
						    Iterator<Contacto> it = contactosList.iterator();
							if(it.hasNext()){
								while (it.hasNext()) {
									Contacto contacto = (Contacto) it.next();									
									
									//cada direccion se crea aqui
									Paragraph par1= new Paragraph();
									Font font = new Font(Font.FontFamily.COURIER,12,Font.NORMAL,BaseColor.BLACK);
																		
									par1.add(new Phrase(contacto.getNombre()+"  "+contacto.getApellidos()+"  ",font));
									par1.add(new Phrase(Chunk.NEWLINE));//Salto de linea
									par1.add(new Phrase(contacto.getDireccion()+"  "+contacto.getCp()+"  ",font));
									par1.add(new Phrase(Chunk.NEWLINE));//Salto de linea
									par1.add(new Phrase(contacto.getProvincia()+"  "+contacto.getPais()+" ",font));
									par1.setAlignment(Element.ALIGN_LEFT);
									par1.add(new Phrase(Chunk.NEWLINE));//Salto de linea
									par1.add(new Phrase(Chunk.NEWLINE));//Salto de linea						
									
									documento.add(par1);									
									
								}
							}		
							
							
						} catch (DocumentException e) {
							e.printStackTrace();
						}

						documento.close();			
						
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NamingException e) {
					e.printStackTrace();
				}		
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	
	
	


}
