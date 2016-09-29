package model;

import java.util.ArrayList;
import java.util.Calendar;

public class User {
	
	private FriendManager friends;
	private Profile profile;
	private String name;
	private String password;
	private String email;
	private HandlerEvent handlerevent;
	private User halfOrange;
	private ArrayList<User> friendsToNextEvent;
	

	public User(String nameUser, String password, String emailUser,
			ArrayList<MusicalGenres> musicalGenres, ArrayList<MoviesGenres> moviesGenres, ArrayList<FoodStyle> foodStyles, int amountMax) {
		this.setFriends(new FriendManager());
		this.setEmail(emailUser);
		this.setPassword(password);
		this.setName(nameUser);
		this.setProfile(new Profile(musicalGenres, moviesGenres, foodStyles, amountMax));
//		how to improve! 
		this.setHandlerevent(new HandlerEvent(new HandlerFilter(), this));
		this.friendsToNextEvent = new ArrayList<User>();
	}
	
	
	public boolean matchingProfiles(Event event) {
		return this.getProfile().matchingProfiles(event);
	}
	
	
	public void createEvent(ArrayList<User> guests, EventType eventType , Calendar date, Place place) {
		this.getHandlerevent().createEvent(guests, eventType, date, place);
	}
	
	public void addFriend(User user){
		this.getFriends().addFriend(user);
	}
	
	public void removeFriend(User user){
		this.getFriends().removeFriend(user);
	}

	//-------------------------------getters and setters----------------------
	
	public User getHalfOrange() {
		return halfOrange;
	}

	public void setHalfOrange(User halfOrange) {
		this.halfOrange = halfOrange;
	}
	
	public FriendManager getFriends() {
		return friends;
	}
	public void setFriends(FriendManager friends) {
		this.friends = friends;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public HandlerEvent getHandlerevent() {
		return handlerevent;
	}
	public void setHandlerevent(HandlerEvent handlerevent) {
		this.handlerevent = handlerevent;
	}
	public ArrayList<User> getFriendsToNextEvent() {
		return friendsToNextEvent;
	}
	public void setFriendsToNextEvent(ArrayList<User> friendsToNextEvent) {
		this.friendsToNextEvent = friendsToNextEvent;
	}
	
}