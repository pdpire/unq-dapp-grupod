package persistence;

import model.Profile;

public class ProfileRepository extends HibernateGenericDAO<Profile> implements GenericRepository<Profile>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Profile> getDomainClass() {
		// TODO Auto-generated method stub
		return Profile.class;
	}

}
