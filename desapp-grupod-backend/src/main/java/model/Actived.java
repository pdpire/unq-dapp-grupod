package model;

public class Actived extends StateEvent {

	public Actived(Event event) {
		super(event);
	}

	public void termiteEvent() {
		
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