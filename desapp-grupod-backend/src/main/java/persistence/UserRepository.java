package persistence;

import model.User;

public class UserRepository extends HibernateGenericDAO<User> implements GenericRepository<User>{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5224056470035467236L;

	/**
	 * 
	 */
	
	@Override
	protected Class<User> getDomainClass() {
		// TODO Auto-generated method stub
		return User.class;
	}


}
