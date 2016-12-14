package factory;

import model.EventStandart;
import model.Place;

public class EventFactory {
	
	public static EventStandart eventWithPlace(Place place){
		
		EventStandart event = new EventStandart(null, null, null, null, place);
		
	    return event;
	}

}
