package Beans;

import javax.ejb.Remote;

@Remote
public interface ContactoBeanRemote {
	public void createContact();
	public void updateContact();
	public void deleteContact();
}
