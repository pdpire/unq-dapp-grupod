package model;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Event {

	private StateEvent stateEvent;
	private Calendar date;
	private int cost;
	private EventType type;
	private ArrayList<Enum> pleasures;
	private ArrayList<User> invited;
	
	
	public Event(EventType type, Calendar date, ArrayList<User> invited){
		this.type = type;
		this.date = date;
		this.cost = this.calculateCost();
		this.stateEvent = new Actived(this);
		this.invited = invited;
	}
	
	public boolean getState(){
		return this.getStateEvent().state();
	}
	
	public void addGuest(User user) {
		this.getInvited().add(user);
	}
	
	public abstract int calculateCost();
	public abstract boolean iCanAttend(User user);
	
	
//  ----------------------- getters && setters  ----------------------------

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
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
	
	public ArrayList<User> getInvited() {
		return invited;
	}

	public void setInvited(ArrayList<User> invited) {
		this.invited = invited;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public ArrayList<Enum> getPleasures() {
		return pleasures;
	}

	public void setPleasures(ArrayList<Enum> pleasures) {
		this.pleasures = pleasures;
	}

}