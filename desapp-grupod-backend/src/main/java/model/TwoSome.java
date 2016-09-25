package model;

import java.util.ArrayList;
import java.util.Calendar;

public class TwoSome extends Filter {

	public ArrayList<Event> suggestEvents(User user, Calendar date) {
		User userHalfOrange = user.getHalfOrange();
		
		ArrayList<Event> retEvents = new ArrayList<Event>();
		for (Event event : this.getRepositoryEvent().getEventsActives()) {
			if(event.iCanAttend(user) && user.matchingProfiles(event) &&
			event.iCanAttend(userHalfOrange) && userHalfOrange.matchingProfiles(event)){
				retEvents.add(event);
			}
		}
		return retEvents;
	}

}
