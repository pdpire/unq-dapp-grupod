package model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class TwoSome extends Filter {

	public Set<Event> suggestEvents(User user, Calendar date) throws NoHalfOrangeException {
		Set<Event> retEvents = new HashSet<Event>();
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
