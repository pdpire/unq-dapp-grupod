package webService;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
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

	@POST
	@Path("/attend/{idEvent}")
	@Produces("application/json")
	public Response attend(@PathParam("idEvent") final int idEvent) {

		Event event = this.getServiceEvent().getId(idEvent);

		event.addGuest(new User());

		this.getServiceEvent().update(event);

		return Response.status(Response.Status.OK).entity("OK").build();
	}

	@GET
	@Path("/toName/{name}")
	@Produces("application/json")
	public Response getEventToName(@PathParam("name") final String name) {
		Set<EventDTO> ret = null;
		try {
			ret = this.getServiceEvent().getEvent(name);
		} catch (Exception e) {
			Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(ret).build();

	}

	@GET
	@Path("/eventByAmount/{amount}")
	@Produces("application/json")
	public Response getEventsBy(@PathParam("amount") final Integer amount) {

		Set<EventDTO> ret = null;
		try {

			ret = this.getServiceEvent().getEventByAmount(amount);

		} catch (Exception e) {
			Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(ret).build();
	}
	
	@GET
	@Path("/geteventssorprise")
	@Produces("application/json")
	public Response getEventsSorprise() {
		try {
			return Response.ok(this.getServiceEvent().getEventsRandom()).build();	
		}catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@GET
	@Path("/getevents")
	@Produces("application/json")
	public Response getEvents() {
		try {
		return Response.ok(new EventDTO().copyOnList(this.getServiceEvent().retriveAll())).build();
		}catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}	
		}

}
