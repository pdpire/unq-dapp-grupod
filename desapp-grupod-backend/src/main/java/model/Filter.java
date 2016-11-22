package model;


import java.util.Calendar;
import java.util.Set;


public abstract class Filter {
	
	private RepositoryEvent repositoryEvent;
	
	public Filter() {
		this.repositoryEvent = RepositoryEvent.getInstance();
	}

	public abstract Set<Event> suggestEvents(User user, Calendar date) throws NoFoundTypeEventException, NoHalfOrangeException;
	
//  ----------------------- getters && setters  ----------------------------

	public RepositoryEvent getRepositoryEvent() {
		return repositoryEvent;
	}

	public void setRepositoryEvent(RepositoryEvent repositoryEvent) {
		this.repositoryEvent = repositoryEvent;
	}
}