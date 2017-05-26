package beans;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

import classes.Contacto;
import classes.User;
import entities.EUser;

@Local
public interface UserbeanLocal {
	
	public User selectUser(String email, String pass);
	public EUser buscarUser(int id);
	public void createUser(HttpServletRequest request);
	public void updateUser(HttpServletRequest request, int id);
	public ArrayList<User> getByField(HttpServletRequest request);
	public void deleteUser(int id);
}
