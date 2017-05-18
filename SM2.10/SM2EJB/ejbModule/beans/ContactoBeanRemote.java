package beans;

import java.util.ArrayList;

import javax.ejb.Remote;
import javax.servlet.http.HttpServletRequest;

import classes.Contacto;
import entities.EContact;

@Remote
public interface ContactoBeanRemote {
	public ArrayList<Contacto> getByField(HttpServletRequest request);
	public int createContact(HttpServletRequest request);
	public void updateContact(HttpServletRequest request, int id);
	public void deleteContact(int id);
	public EContact buscarContact(int id);
}
