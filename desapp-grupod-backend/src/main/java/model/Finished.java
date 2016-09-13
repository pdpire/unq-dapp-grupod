package model;

public class Finished extends StateEvent {
	

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
