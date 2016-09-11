package model;

import java.util.ArrayList;
import java.util.Date;

public abstract class Filter {

	public abstract ArrayList<Event> suggestEvents(User user, Date date, ArrayList<Event> events);
}
