package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

//@XmlRootElement(name = "friendmanager")
@Entity
@Table(name="FriendManager")
public class FriendManager extends model.Entity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_user")
	private Set<User> users = new HashSet<>();
	
	public FriendManager() {
		this.users = new HashSet<>();
	}
	
	public void removeFriend(User friend){
		this.getUsers().remove(friend);
	}
	
	public void addFriend(User friend){
		this.getUsers().add(friend);
	}
	
	
	
	//-------------------------------getters and setters----------------------
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
