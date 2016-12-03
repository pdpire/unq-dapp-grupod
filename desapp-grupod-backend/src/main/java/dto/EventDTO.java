package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Event;
import model.EventStandart;
import model.EventType;
import model.Place;
import model.StateEvent;
import model.User;

public class EventDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6989470341398605887L;
	
	private int cost;
	private int invited;
	private Calendar date;
	private String stateEvent;
	private Set<User> listInvited;
	
	
	public Set<User> getListInvited() {
		return listInvited;
	}


	public void setListInvited(Set<User> listInvited) {
		this.listInvited = listInvited;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public Calendar getDate() {
		return date;
	}


	public void setDate(Calendar date) {
		this.date = date;
	}


	public String getStateEvent() {
		return stateEvent;
	}


	public void setStateEvent(String stateEvent) {
		this.stateEvent = stateEvent;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	private String type;
	
	public EventDTO copyData(Event event){
		
		this.cost = event.getCost();
		this.setInvited(event.getInvited().size());
		this.date = event.getDate();
		this.stateEvent = event.getStateEvent().getClass().getSimpleName();
		this.type = event.getType().getValue();
		this.listInvited = event.getInvited();
		
		return this;

	}
	
	
	public Set<EventDTO> copyOnList(List<Event> listEvents){
		
		Set<EventDTO> listDto = new HashSet<EventDTO>();
		
		for (Event event : listEvents) {
			listDto.add(new EventDTO().copyData(event));
		}
		
		return listDto;
	}


	public int getInvited() {
		return invited;
	}


	public void setInvited(int invited) {
		this.invited = invited;
	}
	

}
