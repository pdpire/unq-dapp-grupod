package model;

public abstract class StateEvent {
	
	public StateEvent(Event event){
		this.setEvent(event);
	}
	
	
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
