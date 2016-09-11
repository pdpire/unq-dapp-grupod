package model;

import java.util.ArrayList;
import java.util.Date;

public class User {
	private FriendManager friends;
	private Profile profile;
	private String name;
	private String password;
	private String email;
	private HandlerEvent handlerevent;
	
	
	public void createEvent(User owner, ArrayList<User> guests, Date date, ArrayList<Place> places) {
		this.getHandlerevent().createEvent(owner, guests, date, places);
	}
	
	public void addFriend(User user){
		this.getFriends().addFriend(user);
	}
	
	public void removeFriend(User user){
		this.getFriends().removeFriend(user);
	}
	

	//-------------------------------getters and setters----------------------
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
	
	
	
}
