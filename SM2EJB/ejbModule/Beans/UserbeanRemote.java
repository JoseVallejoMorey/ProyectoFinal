package Beans;

import javax.ejb.Remote;

@Remote
public interface UserbeanRemote {
	public void createUser();
	public void updateUser();
	public void deleteUser();
}
