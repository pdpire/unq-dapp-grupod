
package webService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Event;
import model.EventStandart;
import model.EventType;
import model.FoodStyle;
import model.MoviesGenres;
import model.MusicalGenres;
import model.Place;
import model.Profile;
import model.TestMapping;
import model.User;
import services.TestMappingService;

@Path("/service")
public class ServiceFacade {

	private TestMappingService serviceMapTest;
	
//	private ServiceProfile serviceProfile;

	// private FoodStyleService foodService;
	//
	// public FoodStyleService getFoodService() {
	// return foodService;
	// }
	//
	// public void setFoodService(FoodStyleService foodService) {
	// this.foodService = foodService;
	// }
	
	
	
	
	@GET
	@Path("/getprofiles")
	@Produces("application/json")
	public List<Profile> getProfiles() {
		List<Profile> profiles = new ArrayList<Profile>();
		ArrayList<MusicalGenres> musicalGenres = new ArrayList<MusicalGenres>();
		musicalGenres.add(MusicalGenres.CLASSICAL);
		ArrayList<MoviesGenres> moviesGenres = new ArrayList<MoviesGenres>();
		moviesGenres.add(MoviesGenres.ACTION);
		moviesGenres.add(MoviesGenres.COMEDY);
		ArrayList<FoodStyle> foodStyles = new ArrayList<FoodStyle>();
		foodStyles.add(FoodStyle.FASTFOODS);
		Profile tm1 = new Profile(musicalGenres, moviesGenres, foodStyles, 10);
		Profile tm2 = new Profile(musicalGenres, moviesGenres, foodStyles, 20);
		profiles.add(tm1);
		profiles.add(tm2);
		return profiles;
	}
	
	@GET
	@Path("/getevents")
	@Produces("application/json")
	public Event getEvents() {
		
		ArrayList<MusicalGenres> musicalGenres = new ArrayList<MusicalGenres>();
		musicalGenres.add(MusicalGenres.CLASSICAL);
		
		ArrayList<MoviesGenres> moviesGenres = new ArrayList<MoviesGenres>();
		moviesGenres.add(MoviesGenres.ACTION);
		moviesGenres.add(MoviesGenres.COMEDY);
		
		ArrayList<FoodStyle> foodStyles = new ArrayList<FoodStyle>();
		foodStyles.add(FoodStyle.FASTFOODS);
		
		Place place = new Place(musicalGenres, moviesGenres, foodStyles, 10, 1000);
		User user = new User("user", "passUser", "user@mail.com", musicalGenres, moviesGenres, foodStyles, 500);
		
		ArrayList<User> guests = new ArrayList<User>();
		guests.add(user);
		
		Calendar calendar = new GregorianCalendar(2013, 0, 31);
		EventStandart eventStandart1 = new EventStandart(user, EventType.ENTERTAINMENT, calendar, guests, place);
//		EventStandart eventStandart2 = new EventStandart(user2, EventType.ALLNIGHT, calendar, guests, place2);
		
//		ArrayList<EventStandart> ret = new ArrayList<EventStandart>();
//		ret.add(eventStandart1);
//		ret.add(eventStandart2);
		
		return eventStandart1;
	}
	
	@GET
	@Path("/testmapping/{id}")
	@Produces("application/json")
	public TestMapping testMapping(@PathParam("id") final Integer id) {
		TestMapping testMapping = this.getServiceMapTest().getRepository().findById(id);
		return testMapping;
	}
	
	@POST
	@Path("/testmappingupdate/{id}/{name}")
	@Produces("application/json")
	public TestMapping testMappingUpdate(@PathParam("id") final Integer id, @PathParam("name") final String name) {
		
		TestMapping testMapping = this.getServiceMapTest().getRepository().findById(id);
		testMapping.setName(name);
		this.getServiceMapTest().update(testMapping);
		
		return testMapping;
	}
	
	@GET
	@Path("/testmappings")
	@Produces("application/json")
	public List<TestMapping> testMappings() {
		return this.getServiceMapTest().retriveAll();
	}

	@POST
	@Path("/addtestmappings/{name}")
	@Produces("application/json")
	public TestMapping addTestMappings(@PathParam("name") final String name) {

		TestMapping testMapping = new TestMapping();
		testMapping.setName(name);
		this.getServiceMapTest().save(testMapping);

		return testMapping;
	}

	public TestMappingService getServiceMapTest() {
		return serviceMapTest;
	}

	public void setServiceMapTest(TestMappingService serviceMapTest) {
		this.serviceMapTest = serviceMapTest;
	}

//	public ServiceProfile getServiceProfile() {
//		return serviceProfile;
//	}
//
//	public void setServiceProfile(ServiceProfile serviceProfile) {
//		this.serviceProfile = serviceProfile;
//	}
}
