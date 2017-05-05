package Beans;

import javax.ejb.Local;

@Local
public interface UserbeanLocal {
	
	public void createUser();
	public void updateUser();
	public void deleteUser();
}
