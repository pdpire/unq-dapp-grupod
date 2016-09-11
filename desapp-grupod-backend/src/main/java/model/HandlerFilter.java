package model;

import java.util.ArrayList;
import java.util.Date;

public class HandlerFilter {
	private ArrayList<Filter> filters;
	
	public HandlerFilter() {
		ArrayList<Filter> filterSuggested = new ArrayList<Filter>();
		filterSuggested.add(new Economic());
		this.setFilters(filterSuggested);
	}
	

	public ArrayList<Event> suggestEvents(int posicionCombo, User user, Date date, ArrayList<Event> events) {
		if(posicionCombo ==0){
			return this.getFilters().get(0).suggestEvents(user, date, events);
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
