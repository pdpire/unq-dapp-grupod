package model;

import java.util.ArrayList;
import java.util.Date;

public class Economic extends Filter {

	@Override
	public ArrayList<Event> suggestEvents(User user, Date date, ArrayList<Event> events) {
		
		ArrayList<Event> retEvents = new ArrayList<Event>();
		for (Event event : events) {
			if(user.getProfile().getAmountMax() >= event.getCost() && event.getState()){
				retEvents.add(event);
			}
		}
		return retEvents;
		
	}
	

}
