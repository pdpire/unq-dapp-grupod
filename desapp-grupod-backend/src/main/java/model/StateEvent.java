package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="stateevent")
public abstract class StateEvent extends model.Entity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StateEvent(){
		
	}

	public StateEvent(Event event){
		this.setEvent(event);
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_st_events")
	private Event event;
	
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	
	public abstract void terminateEvent();
	public abstract void cancelEvent();
	public abstract void activateEvent();
	public abstract boolean state();

}
