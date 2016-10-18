package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
	
	
	public static void main(String[] args) throws NoFoundTypeEventException, NoHalfOrangeException {
		
//		ArrayList<MusicalGenres> enums = new ArrayList<MusicalGenres>();
//		enums.add(MusicalGenres.CLASSICAL);
//		enums.add(MusicalGenres.POP);
//		
//		ArrayList<Enum> pp = new ArrayList<Enum>();
//		pp.add(MusicalGenres.CLASSICAL);
//		pp.add(MusicalGenres.POP);
//		
//		System.out.println(enums.contains(pp.get(0)));
		
		
		
		
		ArrayList<MusicalGenres> musicalGenres = new ArrayList<MusicalGenres>();
		musicalGenres.add(MusicalGenres.CLASSICAL);
		ArrayList<MoviesGenres> moviesGenres = new ArrayList<MoviesGenres>();
		moviesGenres.add(MoviesGenres.ACTION);
		ArrayList<FoodStyle> foodStyles = new ArrayList<FoodStyle>();
		foodStyles.add(FoodStyle.FASTFOODS);
		
		User user1 = new User("user", "passUser", "user@mail.com", musicalGenres, moviesGenres, foodStyles, 250);
		User user2 = new User("user", "passUser", "user@mail.com", musicalGenres, moviesGenres, foodStyles, 500);
		
		
		ArrayList<Place> places = new ArrayList<Place>();
		Place place1 = new Place(musicalGenres, moviesGenres, foodStyles, 10, 1000);
		Place place2 = new Place(musicalGenres, moviesGenres, foodStyles, 10, 1000);
		places.add(place1);
		places.add(place2);
		
//		event creado por el usuario
		
		ArrayList<User> guests = new ArrayList<User>();
		guests.add(user2);
		
		Calendar calendar = new GregorianCalendar(2013, 0, 31);
		
		Calendar calendar1 = new GregorianCalendar(2013, 0, 29);
		Calendar calendar2 = new GregorianCalendar(2013, 0, 30);
		Calendar calendar3 = new GregorianCalendar(2013, 0, 31);
		
		EventStandart eventStandart1 = new EventStandart(user2, EventType.ENTERTAINMENT, calendar, guests, place2);
		EventStandart eventStandart2 = new EventStandart(user2, EventType.ALLNIGHT, calendar, guests, place2);
		
		RepositoryEvent re1 = RepositoryEvent.getInstance();
		
		re1.addEvents(eventStandart1);
		re1.addEvents(eventStandart2);
		
//		user1.createEvent(guests, , places);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");

//		System.out.println(sdf.format(calendar.getTime()));
		
		user1.createEvent(guests, EventType.FOOD, calendar, place1);
		
		System.out.println(calendar2.compareTo(calendar3) <= 0);
		
		System.out.println(user2.getHandlerEvent().suggetsEvents(3, calendar));
			
		
		
//		//event standart
//		ArrayList<User> invited = new ArrayList<User>();		
//		
//		/*
//		User user2 = new User("nameUserTest1", "123", "nameUser@mail.com", musicalGenres, moviesGenres, foodStyles, transport, 100);
//		ArrayList<Place> places2 = new ArrayList<Place>();
//		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
//		String dateInString2 = "31-08-1982 10:20:56";
//		Date date2 = sdf2.parse(dateInString2);
//		user2.createEvent(user2.getFriends().getUsers(), date2, places2);
//		*/
//		
//		System.out.println(user1.getHandlerevent().suggetsEvents(0, date));
//		
//		/*
//		RepositoryEvent re1 = RepositoryEvent.getInstance();
//		RepositoryEvent re2 = RepositoryEvent.getInstance();
//		re1.addEvents(null);
//		re1.addEvents(null);
//		System.out.println(re1);
//		System.out.println(re2);
//		*/
	}
}