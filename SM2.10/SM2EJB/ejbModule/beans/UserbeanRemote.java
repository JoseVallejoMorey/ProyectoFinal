package beans;

import javax.ejb.Remote;
import javax.servlet.http.HttpServletRequest;

import entities.EUser;

@Remote
public interface UserbeanRemote {
	public EUser buscarUser(int id);
	public void createUser(HttpServletRequest request);
	public void updateUser(HttpServletRequest request, int id);
	public void deleteUser(int id);
}
