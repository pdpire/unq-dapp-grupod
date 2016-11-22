package model;

import javax.persistence.Entity;

import org.hibernate.annotations.ForeignKey;

@Entity
@ForeignKey(name = "fk_Finished")
public class Finished extends StateEvent {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Finished(Event event) {
		super(event);
	}

	public void terminateEvent() {
		
	}

	public void cancelEvent() {
		this.getEvent().setStateEvent(new Canceled(this.getEvent()));
		this.setEvent(null);
	}

	public void activateEvent() {
		this.getEvent().setStateEvent(new Actived(this.getEvent()));
		this.setEvent(null);

	}

	public boolean state() {
		return false;
	}

}
