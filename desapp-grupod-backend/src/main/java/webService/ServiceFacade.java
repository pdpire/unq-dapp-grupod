
package webService;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Event;
import model.FoodStyle;
import model.MovieGenre;
import model.MusicalGenre;
import model.Profile;
import model.TestMapping;
import services.ServiceProfile;
import services.TestMappingService;


//CAMBIAR NOMBRE
@Path("/service")
public class ServiceFacade {

	private TestMappingService serviceMapTest;
	
//	private ServiceProfile serviceProfile;
//	
//	
//	@GET
//	@Path("/getprofiles")
//	@Produces("application/json")
//	public List<Profile> getProfiles() {
//		return this.getServiceProfile().retriveAll();
//	}
//	
//	@POST
//	@Path("/addprofile/{amountMax}")
//	@Produces("application/json")
//	public Profile addProfile(@PathParam("amountMax") final int amountMax) {
//		ArrayList<MusicalGenre> musicalGenres = new ArrayList<MusicalGenre>();
//		ArrayList<MovieGenre> moviesGenres = new ArrayList<MovieGenre>();
//		ArrayList<FoodStyle> foodStyles = new ArrayList<FoodStyle>();
//
//		Profile profile = new Profile( musicalGenres , moviesGenres, foodStyles, 1);
//		this.getServiceProfile().save(profile);
//
//		return profile;
//	}
//	
	
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
