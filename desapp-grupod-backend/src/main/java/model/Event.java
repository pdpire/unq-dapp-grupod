package model;

import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "event")
public abstract class Event {

	private StateEvent stateEvent;
	private Calendar date;
	private int cost;
	private EventType type;
	private List<User> invited;
	private Integer id;
	
	
	public Event(EventType type, Calendar date, List<User> invited){
		this.type = type;
		this.date = date;
		this.stateEvent = new Actived(this);
		this.invited = invited;
	}
	
	public Event(){
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
	
	public List<User> getInvited() {
		return invited;
	}

	public void setInvited(List<User> invited) {
		this.invited = invited;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}