package model;

import java.util.ArrayList;
import java.util.Calendar;

public class TwoSome extends Filter {

	public ArrayList<Event> suggestEvents(User user, Calendar date) throws NoHalfOrangeException {
		ArrayList<Event> retEvents = new ArrayList<Event>();
		try {
			User userHalfOrange = user.getHalfOrange();
			for (Event event : this.getRepositoryEvent().getEventsActives()) {
				if (event.iCanAttend(user) && user.matchingProfiles(event) && event.iCanAttend(userHalfOrange)
						&& userHalfOrange.matchingProfiles(event)) {
					retEvents.add(event);
				}
			}
		} catch (NullPointerException e) {
			throw new NoHalfOrangeException();
		}
		return retEvents;
	}

}
