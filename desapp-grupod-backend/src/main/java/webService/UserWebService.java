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
	public Response getUsers() {
		try{
			return Response.status(Response.Status.OK).entity(new UserDTO().copyOnList(this.getServiceUser().retriveAll())).build();
		}catch (Exception e) {
			return Response.status(Response.Status.OK).entity("Error").build();
		}
	}
	
	@POST
	@Path("/adduser/{email}/{name}")
	@Produces("application/json")
	public Response addUser(@PathParam("email") final String email, @PathParam("name") final String name) {
	
		try{
			User user = this.getServiceUser().getUserByEmail(email);
			if(user == null){
				User user1 = new User(name, email);
				this.getServiceUser().save(user1);
				return Response.status(Response.Status.OK).entity("OK").build();
			}
			return Response.status(Response.Status.OK).entity("OK").build();
			
		}catch (Exception e) {
			return Response.status(Response.Status.EXPECTATION_FAILED).entity("FALLO").build();
		}
	}
	
	@DELETE
	@Path("/deleteuser/{id}")
	@Produces("application/json")
	public Response deleteProfile(@PathParam("id") final Integer id) {

		try {
			User user = this.getServiceUser().getId(id);
			this.getServiceUser().delete(user);
		} catch (Exception e) {
			return Response.status(Response.Status.OK).entity("User not found").build();
		}
		return Response.status(Response.Status.OK).entity("OK").build();
	}
	
	

}
