package model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class HandlerFilter {
	
	private Set<Filter> filters;
	
	public HandlerFilter() {
		Set<Filter> filterSuggested = new HashSet<Filter>();
		filterSuggested.add(new Economic());
		filterSuggested.add(new TwoSome());
		filterSuggested.add(new Surprise());
		filterSuggested.add(new WithFriends());
		filterSuggested.add(new SaturdayNightFever());
		this.setFilters(filterSuggested);
	}
	

	public Set<Event> suggestEvents(int posicionCombo, User user, Calendar date) throws NoFoundTypeEventException, NoHalfOrangeException {
		/*
		if(posicionCombo == 0){
			return this.getFilters().get(0).suggestEvents(user, date);
		}
		if(posicionCombo == 1){
			return this.getFilters().get(1).suggestEvents(user, date);
		}
		if(posicionCombo == 2){
			return this.getFilters().get(2).suggestEvents(user, date);
		}
		if(posicionCombo == 3){
			return this.getFilters().get(3).suggestEvents(user, date);
		}
		if(posicionCombo == 4){
			return this.getFilters().get(4).suggestEvents(user, date);
		}
		
		*/
		return null;
	}
	
	
	public Set<Filter> getFilters() {
		return filters;
	}


	public void setFilters(Set<Filter> filters) {
		this.filters = filters;
	}



}
