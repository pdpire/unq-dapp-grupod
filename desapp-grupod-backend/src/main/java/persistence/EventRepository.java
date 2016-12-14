package persistence;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import dto.EventDTO;
import model.Event;

public class EventRepository extends HibernateGenericDAO<Event> implements GenericRepository<Event> {

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

	public Set<EventDTO> getEventsByName(String name) {

		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "FROM Event E WHERE E.description LIKE :name ";
		Query query = session.createQuery(hql);
		query.setParameter("name", "%" + name + "%");

		return EventDTO.copyOnList(((List<Event>) query.list()));
	}

	public Set<EventDTO> getEventsByAmount(Integer amount) {

		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "FROM Event E WHERE E.cost < :amount ";
		Query query = session.createQuery(hql);
		query.setParameter("amount", amount);

		return EventDTO.copyOnList(((List<Event>) query.list()));
	}

}
