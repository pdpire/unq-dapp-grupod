package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepositoryEvent {
	
    private static RepositoryEvent INSTANCE = null;
    private Set<Event> events;

    // Private constructor suppresses 
    public RepositoryEvent(){
    	this.events = new HashSet<Event>();
    }

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new RepositoryEvent();
        }
    }

    public static RepositoryEvent getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    public void addEvents(Event event) {
    	this.getEvents().add(event);
    }
    
    public static Set<EventStandart> getEventsType(EventType eventType, Calendar date) throws NoFoundTypeEventException{
    	HashSet<EventStandart> retEvents = new HashSet<EventStandart>();
		for (EventStandart event : RepositoryEvent.getInstance().getEventsStandart()) {
			if(
					RepositoryEvent.getInstance().verifyDayAndMonth(event, date) && 
					event.getState() &&
					RepositoryEvent.getInstance().isTypeEvent(event, eventType, 00, 02)){
				retEvents.add(event);
			}
		}
		if(retEvents.isEmpty()){
			throw new NoFoundTypeEventException();
		}
		
		return retEvents;	
    }
    
    public static ArrayList<Event> getEventsActives(){
		ArrayList<Event> retEvents = new ArrayList<Event>();
		for (Event event : RepositoryEvent.getInstance().getEvents()) {
			if(event.getState()){
				retEvents.add(event);
			}
		}
		return retEvents;	
    	
    } 
    
    public ArrayList<EventStandart> getEventsStandart(){
    	ArrayList<EventStandart> retEvents = new ArrayList<EventStandart>();
		for (Event event : RepositoryEvent.getInstance().getEvents()) {
			if(event.getType().getValue() != "allnight"){
				retEvents.add((EventStandart) event);
			}
		}
		return retEvents;	
    }

	public boolean isTypeEvent(Event event, EventType type, int startHour, int endHour){
		return event.getType().compare(type.getValue()); 
//				&& this.verifyHour(event, startHour, endHour));
	}
    
	public boolean verifyDayAndMonth(Event event, Calendar date){
		return event.getDate().compareTo(date) == 0;
	}

	
//	public boolean verifyHour(Event event, int startHour, int endHour){
//		return (event.getDate().HOUR_OF_DAY >= startHour && event.getDate().HOUR_OF_DAY <= endHour);
//	}
    
	//-------------------------------getters and setters----------------------
    
	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

}