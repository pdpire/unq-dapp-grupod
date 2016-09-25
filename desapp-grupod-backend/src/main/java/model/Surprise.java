package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Surprise extends Filter {

	public ArrayList<Event> suggestEvents(User user, Calendar date) {
		
		ArrayList<Event> retEvents = new ArrayList<Event>();
		for (Event event : this.getRepositoryEvent().getEventsActives()) {
			if(event.iCanAttend(user) && user.matchingProfiles(event)){
				retEvents.add(event);
			}
		}
		return retEvents;
		
	}

}
