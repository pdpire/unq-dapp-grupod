package model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

//@XmlRootElement(name = "event")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Event")
public abstract class Event extends model.Entity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "cost")
	private int cost;
	
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_invited")
	private Set<User> invited = new HashSet<>();
	
	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_e_stateevent")
	private StateEvent stateEvent;
	
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_type")
	private EventType type;
	
	
	
	public Event(EventType type, Calendar date, Set<User> invited){
		this.type = type;
		this.stateEvent = new Actived(this);
		
		this.date = date;
		this.invited = invited;
		this.invited = new HashSet<>();
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
	
	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}
	
	public StateEvent getStateEvent() {
		return stateEvent;
	}
	
	public void setStateEvent(StateEvent stateEvent) {
		this.stateEvent = stateEvent;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public Set<User> getInvited() {
		return invited;
	}

	public void setInvited(Set<User> invited) {
		this.invited = invited;
	}




}