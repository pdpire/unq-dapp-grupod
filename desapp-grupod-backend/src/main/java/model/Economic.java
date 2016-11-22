package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Economic extends Filter {

	public Set<Event> suggestEvents(User user, Calendar date) {
		
		Set<Event> retEvents = new HashSet<Event>();
		for (Event event : this.getRepositoryEvent().getEvents()) {
			if(user.getProfile().getAmountMax() >= event.getCost() && event.getState() && event.iCanAttend(user)){
				retEvents.add(event);
			}
		}
		return retEvents;
		
	}
	

}
