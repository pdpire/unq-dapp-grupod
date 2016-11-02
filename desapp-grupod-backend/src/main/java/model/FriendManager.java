package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "friendmanager")
public class FriendManager implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> users;
	private Integer id;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
