package Beans;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class ContactoBean
 */
@Stateless
public class ContactoBean implements ContactoBeanRemote, ContactoBeanLocal {

    /**
     * Default constructor. 
     */
    public ContactoBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createContact() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContact() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContact() {
		// TODO Auto-generated method stub
		
	}

}
