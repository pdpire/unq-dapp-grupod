package webService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.FoodStyle;
import model.MovieGenre;
import model.MusicalGenre;
import model.Profile;
import services.ServiceProfile;

@Path("/profile")
public class ProfileWebService {
	
	private ServiceProfile serviceProfile;

	public ServiceProfile getServiceProfile() {
		return serviceProfile;
	}

	public void setServiceProfile(ServiceProfile serviceProfile) {
		this.serviceProfile = serviceProfile;
	}
	
	
	@GET
	@Path("/getprofiles")
	@Produces("application/json")
	public List<Profile> getProfiles() {
		return this.getServiceProfile().retriveAll();
	}
	
	@POST
	@Path("/addprofile/{amountMax}")
	@Produces("application/json")
	public Profile addProfile(@PathParam("amountMax") final int amountMax) {
		ArrayList<MusicalGenre> musicalGenres = new ArrayList<MusicalGenre>();
		MusicalGenre mg = new MusicalGenre("POP");
		musicalGenres.add(mg);
		ArrayList<MovieGenre> moviesGenres = new ArrayList<MovieGenre>();
		MovieGenre mgenres = new MovieGenre("terror");
		moviesGenres.add(mgenres);
		ArrayList<FoodStyle> foodStyles = new ArrayList<FoodStyle>();
		FoodStyle fs = new FoodStyle("carne");
		foodStyles.add(fs);

		Profile profile = new Profile( musicalGenres , moviesGenres, foodStyles, amountMax);
		this.getServiceProfile().save(profile);

		return profile;
	}
	

}
