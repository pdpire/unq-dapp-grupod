package model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//import java.util.Random;

public class SaturdayNightFever extends Filter {



	public Set<Event> suggestEvents(User user, Calendar date) throws NoFoundTypeEventException {
		Set<Event> events = new HashSet<Event>();
		for (int i = 0; i < 5; i++) {
			events.add( new EventAllNight(date, null ,this.createSuggestNightEvent(date)));
		}
		return events;

	}	
	
	public Set<EventStandart> createSuggestNightEvent(Calendar date) throws NoFoundTypeEventException{
		Set<EventStandart> suggest = new HashSet<EventStandart>();
		
		Set<EventStandart> dinnerList     = this.getRepositoryEvent().getEventsType(new EventType("food"), date);
		Set<EventStandart> postDinnerList = this.getRepositoryEvent().getEventsType(new EventType("entertainment"), date);
		Set<EventStandart> endNightList   = this.getRepositoryEvent().getEventsType(new EventType("entertainment"), date);
		
		EventStandart dinner     = ((List<EventStandart>) dinnerList).get(anyEvent(dinnerList));
		EventStandart postDinner = ((List<EventStandart>) postDinnerList).get(anyEvent(postDinnerList));
		EventStandart endNight   = ((List<EventStandart>) endNightList).get(anyEvent(endNightList));
		
		suggest.add(dinner);
		suggest.add(postDinner);
		suggest.add(endNight);
		

		return suggest;
	}
	
	public int anyEvent(Set<EventStandart> events){
		int num = (int) (Math.random()* (events.size()-1) + 0);
		return num;
	}
	


}
