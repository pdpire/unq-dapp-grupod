package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HandlerEvent {
	
	private List<Event> events;
	private HandlerFilter handlerFilter;
	private User userAdmin;
	private RepositoryEvent repositoryEvent;
	
	public HandlerEvent(HandlerFilter handlerFilter, User user) {
		this.setRepositoryEvent(RepositoryEvent.getInstance());
		this.events = new ArrayList<Event>();
		this.handlerFilter = handlerFilter;
		this.userAdmin = user;
	}

	
	public void createEvent(List<User> guests, EventType eventType ,Calendar date, Place place) {
	   EventStandart event = new EventStandart(this.getUserAdmin(), eventType ,date, guests, place);
	   this.getEvents().add(event);
	   this.getRepositoryEvent().addEvents(event);
	}
	
	public List<Event> suggetsEvents(int comboPosition, Calendar date) throws NoFoundTypeEventException, NoHalfOrangeException{
		return this.getHandlerFilter().suggestEvents(comboPosition, this.getUserAdmin(), date);
	}
	
	public void goToEvent(Event event){
		event.addGuest(this.getUserAdmin());
	}

	//-------------------------------getters and setters----------------------
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public HandlerFilter getHandlerFilter() {
		return handlerFilter;
	}

	public void setHandlerFilter(HandlerFilter handlerFilter) {
		this.handlerFilter = handlerFilter;
	}
	
	public User getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(User userAdmin) {
		this.userAdmin = userAdmin;
	}


	public RepositoryEvent getRepositoryEvent() {
		return repositoryEvent;
	}


	public void setRepositoryEvent(RepositoryEvent repositoryEvent) {
		this.repositoryEvent = repositoryEvent;
	}


}