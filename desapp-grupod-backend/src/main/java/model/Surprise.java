package model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Surprise extends Filter {

	public Set<Event> suggestEvents(User user, Calendar date) {
		
		Set<Event> retEvents = new HashSet<Event>();
		for (Event event : this.getRepositoryEvent().getEventsActives()) {
			if(event.iCanAttend(user) && user.matchingProfiles(event)){
				retEvents.add(event);
			}
		}
		return retEvents;
		
	}

}
