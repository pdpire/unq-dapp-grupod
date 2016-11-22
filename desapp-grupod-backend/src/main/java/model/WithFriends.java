package model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class WithFriends extends Filter {

	public Set<Event> suggestEvents(User user, Calendar date) {
		Set<User> friends = user.friends();
		
		Set<Event> retEvents = new HashSet<Event>();
		for (Event event : this.getRepositoryEvent().getEventsActives()) {
			if(event.iCanAttend(user) && user.matchingProfiles(event) && this.matchingInvites(event, friends)){
				retEvents.add(event);
			}
		}
		return retEvents;
	}
	
	public boolean matchingInvites(Event event, Set<User> invited){
		boolean ret = false;
		for (User user : invited) {
			if(user.matchingProfiles(event)){
				ret = true;
			}
		}
		return ret;
	}

}
