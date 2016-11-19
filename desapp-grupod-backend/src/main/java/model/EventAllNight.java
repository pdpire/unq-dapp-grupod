package model;


import java.util.Calendar;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.Entity;
import org.hibernate.annotations.ForeignKey;

@Entity
@ForeignKey(name = "fk_EventStandart")
public class EventAllNight extends Event {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_ean_events")
	private Set<Event> events;

	public EventAllNight(Calendar date, Set<User> invited, Set<Event> events) {
		super(new EventType("allnight"), date, invited);
		this.events = events;
		this.setCost( this.calculateCost() );
	}
	
	public EventAllNight() {
	}
	
	
	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}


	@Override
	public boolean iCanAttend(User user) {
		return  ! this.getInvited().contains(user);
	}


	@Override
	public int calculateCost() {
		int ret = 0;
		for (Event event : this.getEvents()) {
			ret += event.getCost();
		}
		return ret;
	}
	
	
}