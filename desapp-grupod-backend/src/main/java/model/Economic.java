package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Economic extends Filter {

	public ArrayList<Event> suggestEvents(User user, Calendar date) {
		
		ArrayList<Event> retEvents = new ArrayList<Event>();
		for (Event event : this.getRepositoryEvent().getEvents()) {
			if(user.getProfile().getAmountMax() >= event.getCost() && event.getState() && event.iCanAttend(user)){
				retEvents.add(event);
			}
		}
		return retEvents;
		
	}
	

}
