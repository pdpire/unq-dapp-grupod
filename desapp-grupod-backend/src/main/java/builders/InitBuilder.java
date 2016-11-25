package builders;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.DependsOn;

import model.Event;
import model.EventStandart;
import model.EventType;
import model.FoodStyle;
import model.MovieGenre;
import model.MusicalGenre;
import model.Place;
import model.User;
import services.ServiceEvent;

public class InitBuilder {
	
	ServiceEvent serviceEvent;

	public ServiceEvent getServiceEvent() {
		return serviceEvent;
	}

	public void setServiceEvent(ServiceEvent serviceEvent) {
		this.serviceEvent = serviceEvent;
	}

	@PostConstruct
	@DependsOn("org.springframework.context.config.internalBeanConfigurerAspect")
	public void create(){
		
		EventType et1 = new EventType("food");
		EventType et2 = new EventType("enterteinment");
		
		Calendar d1 = Calendar.getInstance();
		
		Set<MusicalGenre> musicalGenres = new HashSet<>();
		MusicalGenre mg = new MusicalGenre("POP");
		musicalGenres.add(mg);
		Set<MovieGenre> moviesGenres = new HashSet<>();
		MovieGenre mgenres = new MovieGenre("terror");
		moviesGenres.add(mgenres);
		Set<FoodStyle> foodStyles = new HashSet<>();
		FoodStyle fs = new FoodStyle("carne");
		foodStyles.add(fs);
		
		User us1 = new User();
		User us2 = new User();
		Place p1 = new Place(musicalGenres, moviesGenres, foodStyles, 100, 200);
		Place p2 = new Place(musicalGenres, moviesGenres, foodStyles, 300, 400);
		
		User in1 = new User();
		User in2 = new User();
		
		Set<User> invs = new HashSet<User>();
		invs.add(in1);
		invs.add(in2);

		Event event1 = new EventStandart(us1, et1, d1, invs, p1);
		Event event2 = new EventStandart(us2, et2, d1, invs, p2);

		this.getServiceEvent().save(event1);
		this.getServiceEvent().save(event2);
	}

}
