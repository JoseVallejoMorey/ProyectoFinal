package Beans;

import javax.ejb.Local;

@Local
public interface ContactoBeanLocal {
	
	public void createContact();
	public void updateContact();
	public void deleteContact();
	
}
