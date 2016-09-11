package model;

import java.util.ArrayList;
import java.util.Date;

public class HandlerEvent {
	
	private ArrayList<Event> events;
	private HandlerFilter handlerFilter;
	
	
	public HandlerEvent(HandlerFilter hf) {
		this.events = new ArrayList<Event>();
		this.handlerFilter = hf;
	}

	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	public HandlerFilter getHandlerFilter() {
		return handlerFilter;
	}

	public void setHandlerFilter(HandlerFilter handlerFilter) {
		this.handlerFilter = handlerFilter;
	}

	
	public void createEvent(User owner, ArrayList<User> guests, Date date, ArrayList<Place> places) {
	   Event event = new Event(owner, guests, date, places);
	   this.getEvents().add(event);
	}
	
	public ArrayList<Event> suggetsEvents(int comboPosition, User user, Date date, ArrayList<Event> events){
		return this.getHandlerFilter().suggestEvents(comboPosition, user, date, events);
		
	}


}
