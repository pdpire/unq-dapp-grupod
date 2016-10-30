package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FriendManager friendsManager;
	private Profile profile;
	private String name;
	private String password;
	private String email;
	private HandlerEvent handlerEvent;
	private User halfOrange;
	private Integer id;
	
	public User(){
	}


	public User(String nameUser, String password, String emailUser,
			List<MusicalGenre> musicalGenres, List<MovieGenre> moviesGenres, List<FoodStyle> foodStyles, int amountMax) {
		this.friendsManager = new FriendManager();
		this.email = emailUser;
		this.password = password;
		this.name = nameUser;
		this.profile = new Profile(musicalGenres, moviesGenres, foodStyles, amountMax);
		this.halfOrange = null;
//		how to improve! 
//		this.handlerEvent = new HandlerEvent(new HandlerFilter(), this);
	}

	public boolean matchingProfiles(Event event) {
		return this.getProfile().matchingProfiles(event);
	}
	
	public void createEvent(List<User> guests, EventType eventType , Calendar date, Place place) {
		this.getHandlerEvent().createEvent(guests, eventType, date, place);
	}
	
	public void addFriend(User user){
		this.friendsManager.addFriend(user);
	}
	
	public void removeFriend(User user){
		this.friendsManager.removeFriend(user);
	}

	//-------------------------------getters and setters----------------------
	
	public FriendManager getFriendsManager() {
		return friendsManager;
	}

	public void setFriendsManager(FriendManager friendsManager) {
		this.friendsManager = friendsManager;
	}
	
	public User getHalfOrange() {
		return halfOrange;
	}

	public void setHalfOrange(User halfOrange) {
		this.halfOrange = halfOrange;
	}
	
	public List<User> getFriends() {
		return this.friendsManager.getUsers();
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public HandlerEvent getHandlerEvent() {
		return handlerEvent;
	}

	public void setHandlerEvent(HandlerEvent handlerEvent) {
		this.handlerEvent = handlerEvent;
	}
	
}