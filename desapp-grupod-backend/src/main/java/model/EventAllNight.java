package model;


import java.util.ArrayList;
import java.util.Calendar;


public class EventAllNight extends Event {
	
	private ArrayList<Event> events;

	public EventAllNight(Calendar date, ArrayList<User> invited, ArrayList<Event> events) {
		super(EventType.ALLNIGHT, date, invited);
		this.events = events;
		this.setCost( this.calculateCost() );
	}
	
	
	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
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