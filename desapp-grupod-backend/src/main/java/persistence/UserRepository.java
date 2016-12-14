package persistence;

import org.hibernate.Query;
import org.hibernate.Session;

import model.User;

public class UserRepository extends HibernateGenericDAO<User> implements GenericRepository<User> {

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

	public User getUserByEmail(String email) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "FROM User U WHERE U.email = :email ";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);

		return (User) (query.list().isEmpty() ? null : query.list().get(0));
	}

}
