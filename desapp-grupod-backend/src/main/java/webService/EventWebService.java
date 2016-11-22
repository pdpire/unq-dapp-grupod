package webService;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import dto.EventDTO;
import model.Event;
import model.EventStandart;
import model.EventType;
import model.FoodStyle;
import model.MovieGenre;
import model.MusicalGenre;
import model.Place;
import model.Profile;
import model.User;
import services.ServiceEvent;

@Path("/event")
public class EventWebService {
	
	private ServiceEvent serviceEvent;

	public ServiceEvent getServiceEvent() {
		return serviceEvent;
	}

	public void setServiceEvent(ServiceEvent serviceEvent) {
		this.serviceEvent = serviceEvent;
	}
	
	@GET
	@Path("/getevents")
	@Produces("application/json")
	public Set<EventDTO> getEvents() {
		
		 return new EventDTO().copyOnList(this.getServiceEvent().retriveAll());
	}
	
	@POST
	@Path("/addevent/{type}")
	@Produces("application/json")
	public Response addEvent(@PathParam("type") final String type) {
		
		EventType et = new EventType(type);
		
		Calendar d = Calendar.getInstance();
		
		Set<MusicalGenre> musicalGenres = new HashSet<>();
		MusicalGenre mg = new MusicalGenre("POP");
		musicalGenres.add(mg);
		Set<MovieGenre> moviesGenres = new HashSet<>();
		MovieGenre mgenres = new MovieGenre("terror");
		moviesGenres.add(mgenres);
		Set<FoodStyle> foodStyles = new HashSet<>();
		FoodStyle fs = new FoodStyle("carne");
		foodStyles.add(fs);
		
		User us = new User();
		Place p = new Place(musicalGenres, moviesGenres, foodStyles, 100, 200);
		
		User in1 = new User();
		User in2 = new User();
		
		Set<User> invs = new HashSet<User>();
		invs.add(in1);
		invs.add(in2);

		Event event = new EventStandart(us, et, d, invs, p);

		this.getServiceEvent().save(event);

		 Response resp = Response.status(Response.Status.OK).entity("OK").build();
		 
		 return resp;

	}

}
