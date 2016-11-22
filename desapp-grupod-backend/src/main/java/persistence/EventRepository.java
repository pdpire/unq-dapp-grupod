package persistence;

import model.Event;

public class EventRepository extends HibernateGenericDAO<Event> implements GenericRepository<Event>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5224056470035467236L;

	/**
	 * 
	 */
	
	@Override
	protected Class<Event> getDomainClass() {
		// TODO Auto-generated method stub
		return Event.class;
	}

}
