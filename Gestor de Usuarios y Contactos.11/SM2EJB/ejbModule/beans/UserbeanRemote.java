package beans;

import java.util.ArrayList;

import javax.ejb.Remote;
import javax.servlet.http.HttpServletRequest;
import classes.User;
import entities.EUser;

@Remote
public interface UserbeanRemote {
	public EUser buscarUser(int id);
	public void createUser(HttpServletRequest request);
	public void updateUser(HttpServletRequest request, int id);
	public ArrayList<User> getByField(HttpServletRequest request);
	public void deleteUser(int id);
}
