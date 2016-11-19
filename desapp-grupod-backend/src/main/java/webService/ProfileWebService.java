package webService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
	
	@DELETE
	@Path("/deleteprofile/{id}")
	@Produces("application/json")
	public String deleteProfile(@PathParam("id") final Integer id) {

		try {
			Profile profile = this.getServiceProfile().getId(id);
			this.getServiceProfile().delete(profile);
		} catch (Exception e) {
			return "Profile not found";
		}
		return "Profile deleted";
	}
	
	@GET
	@Path("/getprofiles")
	@Produces("application/json")
	public List<Profile> getProfiles() {
		return this.getServiceProfile().retriveAll();
	}
	
	@GET
	@Path("/getprofile/{id}")
	@Produces("application/json")
	public Profile getProfile(@PathParam("id") final Integer id) {
		Profile profile = this.getServiceProfile().getId(id);
		return profile;
	}
	
	@POST
	@Path("/addprofilejson/")
	@Consumes("application/json")
	@Produces("application/json")
	public Profile addProfilejson(final Profile profile) {
		this.getServiceProfile().save(profile);
		return profile;
	}

	
	@POST
	@Path("/addmoviegenre/{id}/{value}")
	@Produces("application/json")
	public Profile addMovieGenreProfile(@PathParam("id") final int id, @PathParam("value") final String value) {
		MovieGenre mg = new MovieGenre(value);
		Profile profile = this.getProfile(id);
		profile.getMoviesGenres().add(mg);
		this.getServiceProfile().update(profile);
		return profile;
	}
	
	@POST
	@Path("/musicalgenre/{id}/{value}")
	@Produces("application/json")
	public Profile addMusicalGenreProfile(@PathParam("id") final int id, @PathParam("value") final String value) {
		MusicalGenre mg = new MusicalGenre(value);
		Profile profile = this.getProfile(id);
		profile.getMusicalGenres().add(mg);
		this.getServiceProfile().update(profile);
		return profile;
	}
	
	@POST
	@Path("/addprofile/{amountMax}")
	@Produces("application/json")
	public Profile addProfile(@PathParam("amountMax") final int amountMax) {
		Set<MusicalGenre> musicalGenres = new HashSet<>();
		MusicalGenre mg = new MusicalGenre("POP");
		musicalGenres.add(mg);
		Set<MovieGenre> moviesGenres = new HashSet<>();
		MovieGenre mgenres = new MovieGenre("terror");
		moviesGenres.add(mgenres);
		Set<FoodStyle> foodStyles = new HashSet<>();
		FoodStyle fs = new FoodStyle("carne");
		FoodStyle fs2 = new FoodStyle("carne2");
		foodStyles.add(fs);
		foodStyles.add(fs2);

		Profile profile = new Profile( musicalGenres , moviesGenres, foodStyles, amountMax);
		this.getServiceProfile().save(profile);

		return profile;
	}
	
	

}

