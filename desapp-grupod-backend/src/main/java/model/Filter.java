package model;


import java.util.ArrayList;
import java.util.Calendar;


public abstract class Filter {
	
	private RepositoryEvent repositoryEvent;
	
	public Filter() {
		this.repositoryEvent = RepositoryEvent.getInstance();
	}

	public abstract ArrayList<Event> suggestEvents(User user, Calendar date);
	
//  ----------------------- getters && setters  ----------------------------

	public RepositoryEvent getRepositoryEvent() {
		return repositoryEvent;
	}

	public void setRepositoryEvent(RepositoryEvent repositoryEvent) {
		this.repositoryEvent = repositoryEvent;
	}
}