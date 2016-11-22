package model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class HandlerEvent extends model.Entity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	private User userAdmin;
	
	
	private Set<Event> events = new HashSet<>();
	private HandlerFilter handlerFilter;
	private RepositoryEvent repositoryEvent;
	
	
	public HandlerEvent() {
	}
	
	public HandlerEvent(User user) {
		this.setRepositoryEvent(RepositoryEvent.getInstance());
		this.handlerFilter = new HandlerFilter();
//		-----	NO MAPEADO
		this.events = new HashSet<>();
		this.userAdmin = user;
	}

	
	public void createEvent(Set<User> guests, EventType eventType ,Calendar date, Place place) {
	   EventStandart event = new EventStandart(this.getUserAdmin(), eventType ,date, guests, place);
	   this.getEvents().add(event);
	   this.getRepositoryEvent().addEvents(event);
	}
	
	public Set<Event> suggetsEvents(int comboPosition, Calendar date) throws NoFoundTypeEventException, NoHalfOrangeException{
		return this.getHandlerFilter().suggestEvents(comboPosition, this.getUserAdmin(), date);
	}
	
	public void goToEvent(Event event){
		event.addGuest(this.getUserAdmin());
	}

	//-------------------------------getters and setters----------------------
	

	
	public User getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(User userAdmin) {
		this.userAdmin = userAdmin;
	}
	
 	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	} 
	
	public RepositoryEvent getRepositoryEvent() {
		return repositoryEvent;
	}

	public void setRepositoryEvent(RepositoryEvent repositoryEvent) {
		this.repositoryEvent = repositoryEvent;
	}

	public HandlerFilter getHandlerFilter() {
		return handlerFilter;
	}

	public void setHandlerFilter(HandlerFilter handlerFilter) {
		this.handlerFilter = handlerFilter;
	}


}