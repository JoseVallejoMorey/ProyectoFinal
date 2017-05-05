package Beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Userbean implements UserbeanRemote, UserbeanLocal {

    public Userbean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createUser() {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateUser() {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
	}

}
