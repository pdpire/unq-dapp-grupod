package model;

import javax.persistence.Entity;

import org.hibernate.annotations.ForeignKey;

@Entity
@ForeignKey(name = "fk_Canceled")
public class Canceled extends StateEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Canceled(Event event){
		super(event);
	}
	
	public Canceled(){
		super();
	}

	public void terminateEvent() {

	}

	public void cancelEvent() {

	}

	public void activateEvent() {
		this.getEvent().setStateEvent(new Actived(this.getEvent()));
		this.setEvent(null);
	}

	public boolean state() {
		return false;
	}

}
