package model;

public class Canceled extends StateEvent {
	
	public Canceled(Event event){
		super(event);
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
