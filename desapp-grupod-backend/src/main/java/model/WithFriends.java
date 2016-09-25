package model;

import java.util.ArrayList;
import java.util.Calendar;

public class WithFriends extends Filter {

	public ArrayList<Event> suggestEvents(User user, Calendar date) {
		ArrayList<User> friends = user.getFriendsToNextEvent();
		
		ArrayList<Event> retEvents = new ArrayList<Event>();
		for (Event event : this.getRepositoryEvent().getEventsActives()) {
			if(event.iCanAttend(user) && user.matchingProfiles(event) && this.matchingInvites(event, friends)){
				retEvents.add(event);
			}
		}
		return retEvents;
	}
	
	public boolean matchingInvites(Event event, ArrayList<User> invited){
		boolean ret = false;
		for (User user : invited) {
			if(user.matchingProfiles(event)){
				ret = true;
			}
		}
		return ret;
	}

}
