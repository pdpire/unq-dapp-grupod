package model;

import java.util.ArrayList;

public class FriendManager {
	
	private ArrayList<User> users;

	public FriendManager() {
		this.setUsers(new ArrayList<User>());
	}
	
	public void removeFriend(User friend){
		this.getUsers().remove(friend);
	}
	
	public void addFriend(User friend){
		this.getUsers().add(friend);
	}
	
	
	
	//-------------------------------getters and setters----------------------
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
}
