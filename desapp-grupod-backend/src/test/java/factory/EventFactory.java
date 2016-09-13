package factory;

import java.util.ArrayList;

import model.Event;
import model.Place;

public class EventFactory {
	
	public static Event eventWithPlaces(ArrayList<Place> places){
		
		Event event = new Event(null, null, null, places);
		
	    return event;
	}

}
