package webService;

import java.util.ArrayList;
import java.util.List;

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
import model.User;
import services.ServiceUser;

@Path("/user")
public class UserWebService {
	
	private ServiceUser serviceUser;

	public ServiceUser getServiceUser() {
		return serviceUser; 
	}

	public void setServiceUser(ServiceUser serviceUser) {
		this.serviceUser = serviceUser;
	}
	
	@GET
	@Path("/getusers")
	@Produces("application/json")
	public List<User> getUsers() {
		return this.getServiceUser().retriveAll();
	}
	
	@POST
	@Path("/adduser/{name}")
	@Produces("application/json")
	public User addUser(@PathParam("name") final String name) {
		ArrayList<MusicalGenre> musicalGenres = new ArrayList<MusicalGenre>();
		musicalGenres.add(new MusicalGenre("classical"));
		ArrayList<MovieGenre> moviesGenres = new ArrayList<MovieGenre>();
		moviesGenres.add(new MovieGenre("action"));
		ArrayList<FoodStyle> foodStyles = new ArrayList<FoodStyle>();
		foodStyles.add(new FoodStyle("fastfood"));
		
		User user1 = new User(name, "passUser", "user@mail.com", musicalGenres, moviesGenres, foodStyles, 250);
		this.getServiceUser().save(user1);

		return user1;
	}
	
	@DELETE
	@Path("/deleteuser/{id}")
	@Produces("application/json")
	public String deleteProfile(@PathParam("id") final Integer id) {

		try {
			User user = this.getServiceUser().getId(id);
			this.getServiceUser().delete(user);
		} catch (Exception e) {
			return "User not found";
		}
		return "User deleted";
	}
	
	

}
