package model;

import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import model.Place;

@XmlRootElement(name = "eventstandart")
public class EventStandart extends Event {
	
	private User owner;
	private Place place;
	
	public int calculateCost() {
		return this.getPlace().getCost();
	}
	
	public EventStandart(User owner, EventType type, Calendar date, List<User> invited, Place plce) {
		super(type, date, invited);
		this.owner = owner;
		this.place = plce;
		this.setCost( this.calculateCost() );
	}
	
	public EventStandart() {
	}
	
	public boolean iCanAttend(User user){
		return  ! (this.getOwner().equals(user) || this.getInvited().contains(user));
	}
	

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	
}