package model;

import java.util.ArrayList;
import java.util.Calendar;

public class HandlerFilter {
	private ArrayList<Filter> filters;
	
	public HandlerFilter() {
		ArrayList<Filter> filterSuggested = new ArrayList<Filter>();
		filterSuggested.add(new Economic());
		filterSuggested.add(new TwoSome());
		filterSuggested.add(new Surprise());
		filterSuggested.add(new WithFriends());
		filterSuggested.add(new SaturdayNightFever());
		this.setFilters(filterSuggested);
	}
	

	public ArrayList<Event> suggestEvents(int posicionCombo, User user, Calendar date) throws NoFoundTypeEventException, NoHalfOrangeException {
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
		return null;
	}
	
	
	public ArrayList<Filter> getFilters() {
		return filters;
	}


	public void setFilters(ArrayList<Filter> filters) {
		this.filters = filters;
	}



}
