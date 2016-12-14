package services;

import javax.transaction.Transactional;

import model.User;
import persistence.UserRepository;

public class ServiceUser extends GenericService<User> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Transactional
	public User getUserByEmail(String email){
		return  ((UserRepository) this.getRepository()).getUserByEmail(email);
	}

}
