package model;


import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "eventallnight")
public class EventAllNight extends Event {
	
	private List<Event> events;

	public EventAllNight(Calendar date, List<User> invited, List<Event> events) {
		super(new EventType("allnight"), date, invited);
		this.events = events;
		this.setCost( this.calculateCost() );
	}
	
	public EventAllNight() {
	}
	
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
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