package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class SaturdayNightFever extends Filter {



	public ArrayList<Event> suggestEvents(User user, Calendar date) {
		ArrayList<Event> events = new ArrayList<Event>();
		for (int i = 0; i < 5; i++) {
			events.add( new EventAllNight(date, null ,this.createSuggestNightEvent(date)));
		}
		return events;

	}	
	
	public ArrayList<Event> createSuggestNightEvent(Calendar date){
		ArrayList<Event> suggest = new ArrayList<Event>();
		
		ArrayList<Event> dinnerList = this.getRepositoryEvent().getEventsType(EventType.FOOD, date);
		ArrayList<Event> postDinnerList = this.getRepositoryEvent().getEventsType(EventType.ENTERTAINMENT, date);
		ArrayList<Event> endNightList = this.getRepositoryEvent().getEventsType(EventType.ALLNIGHT, date);
		
		Event dinner = dinnerList.get(anyEvent(dinnerList));
		Event postDinner = postDinnerList.get(anyEvent(postDinnerList));
		Event endNight = endNightList.get(anyEvent(endNightList));
		
		suggest.add(dinner);
		suggest.add(postDinner);
		suggest.add(endNight);
		
		return suggest;
	}
	
	public int anyEvent(ArrayList<Event> events){
		Random rdm = new Random();
		int anyPos = rdm.nextInt(events.size() - 1);
		return anyPos;
	}
	


}
