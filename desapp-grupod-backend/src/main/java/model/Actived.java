package model;

import javax.persistence.Entity;

import org.hibernate.annotations.ForeignKey;

@Entity
@ForeignKey(name = "fk_Actived")
public class Actived extends StateEvent {

	public Actived(Event event) {
		super(event);
	}

	public void terminateEvent() {
		
	}

	public void cancelEvent() {
		this.getEvent().setStateEvent(new Canceled(this.getEvent()));
		this.setEvent(null);
	}

	public void activateEvent() {
		
	}

	public boolean state() {
		return true;
	}

}
