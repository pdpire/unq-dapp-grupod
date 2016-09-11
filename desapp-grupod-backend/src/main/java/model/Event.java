package model;

import java.util.ArrayList;
import java.util.Date;

public class Event {
	
	private StateEvent stateEvent;
	private  ArrayList<Place> places;
	private Date date;
	private User userOwner;
	private ArrayList<User> guests;
	private int cost;
	
	public Event(User owner, ArrayList<User> guests, Date date, ArrayList<Place> places){
		
		this.userOwner = owner;
		this.guests = guests;
		this.date = date;
		this.places = places;
		this.cost = this.calculateCost();
		this.stateEvent = new Actived(this);
	}
	
	public boolean getState(){
		return this.getStateEvent().state();
	}
	
	private int calculateCost() {
		int ret= 0;
		for (Place place : this.getPlaces()) {
			ret = ret + place.getCost();
		}
		return ret;
	
	}
//  ----------------------- getters && setters  ----------------------------



	public User getUserOwner() {
		return userOwner;
	}

	public void setUserOwner(User userOwner) {
		this.userOwner = userOwner;
	}

	public ArrayList<Place> getPlaces() {
		return places;
	}

	public void setPlaces(ArrayList<Place> places) {
		this.places = places;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<User> getGuests() {
		return guests;
	}

	public void setGuests(ArrayList<User> guests) {
		this.guests = guests;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	public StateEvent getStateEvent() {
		return stateEvent;
	}

	public void setStateEvent(StateEvent stateEvent) {
		this.stateEvent = stateEvent;
	}
	
	
}
