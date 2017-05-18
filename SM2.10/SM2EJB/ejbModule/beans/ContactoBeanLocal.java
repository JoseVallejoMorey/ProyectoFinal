package beans;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

import classes.Contacto;
import entities.EContact;
import entities.EUser;

@Local
public interface ContactoBeanLocal {
	public int createContact(HttpServletRequest request);
	public void updateContact(HttpServletRequest request, int id);
	public void deleteContact(int id);
	public EContact buscarContact(int id);
	public ArrayList<Contacto> getByField(HttpServletRequest request);
	
}
