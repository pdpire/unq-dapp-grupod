package webService;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import dto.UserDTO;
import model.FoodStyle;
import model.MovieGenre;
import model.MusicalGenre;
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
	public Set<UserDTO> getUsers() {
		return new UserDTO().copyOnList(this.getServiceUser().retriveAll());
	}
	
	@POST
	@Path("/adduser/{email}/{name}")
	@Produces("application/json")
	public Response addUser(@PathParam("email") final String email, @PathParam("name") final String name) {
		Set<UserDTO> usersDtos = this.getUsers();
		boolean f = true;
		
		for (UserDTO userDTO : usersDtos) {
			if(userDTO.getEmail().equals(email)){
				f = false;
			}
		}
		if(f){
			Set<MusicalGenre> musicalGenres = new HashSet<>();
			Set<MovieGenre> moviesGenres = new HashSet<>();
			Set<FoodStyle> foodStyles = new HashSet<>();
			User user1 = new User(name, "", email, musicalGenres, moviesGenres, foodStyles, 0);
			this.getServiceUser().save(user1);
			return Response.status(Response.Status.OK).entity("OK").build();
		}else{
			return Response.status(Response.Status.OK).entity("Usuario creado").build();
		}
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
