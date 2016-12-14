package model;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class EventStandart extends Event {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_owner")
	private User owner;
	
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_place")
	private Place place;
	
	public int calculateCost() {
		return this.getPlace().getCost();
	}
	
	public EventStandart(User owner, EventType type, Calendar date, Set<User> invited, Place plce) {
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