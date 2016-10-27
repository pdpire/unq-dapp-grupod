package model;

import java.util.ArrayList;
import java.util.List;

public class FriendManager {
	
	private List<User> users;

	public FriendManager() {
		this.users = new ArrayList<User>();
		
	}
	
	public void removeFriend(User friend){
		this.getUsers().remove(friend);
	}
	
	public void addFriend(User friend){
		this.getUsers().add(friend);
	}
	
	
	
	//-------------------------------getters and setters----------------------
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
