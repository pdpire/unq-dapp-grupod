package model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

//@XmlRootElement(name = "user")
@Entity
@Table(name="User")
public class User extends model.Entity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_friendmanager")
	private FriendManager friendsManager;
	
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_profile")
	private Profile profile;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_halforange")
	private User halfOrange;
	
//	@OneToOne(fetch = FetchType.EAGER)
//	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
//	@JoinColumn(name = "id_handlerEvent")	
	private HandlerEvent handlerEvent;
	
	public User(){
	}

	
	public User(String nameUser, String emailUser){
		Set<MusicalGenre> musicalGenres = new HashSet<>();
		Set<MovieGenre> moviesGenres = new HashSet<>();
		Set<FoodStyle> foodStyles = new HashSet<>();
		this.email = emailUser;
		this.name = nameUser;
		this.profile = new Profile(musicalGenres, moviesGenres, foodStyles, nameUser ,0, emailUser);
	}

	public User(String nameUser, String password, String emailUser,
			Set<MusicalGenre> musicalGenres, Set<MovieGenre> moviesGenres, Set<FoodStyle> foodStyles, int amountMax) {
		this.friendsManager = new FriendManager();
		this.email = emailUser;
		this.password = password;
		this.name = nameUser;
		this.profile = new Profile(musicalGenres, moviesGenres, foodStyles, nameUser ,amountMax, emailUser);
//		this.halfOrange = new User();
//		how to improve! 	
//		this.handlerEvent = new HandlerEvent(this);
	}
	
	
	public Set<User> friends() {
		return this.friendsManager.getUsers();
	}

	public boolean matchingProfiles(Event event) {
		return this.getProfile().matchingProfiles(event);
	}
	
	public void createEvent(Set<User> guests, EventType eventType , Calendar date, Place place) {
		this.getHandlerEvent().createEvent(guests, eventType, date, place);
	}
	
	public void addFriend(User user){
		this.friendsManager.addFriend(user);
	}
	
	public void removeFriend(User user){
		this.friendsManager.removeFriend(user);
	}

	//-------------------------------getters and setters----------------------
	
	
	
	public HandlerEvent getHandlerEvent() {
		return handlerEvent;
	}

	public void setHandlerEvent(HandlerEvent handlerEvent) {
		this.handlerEvent = handlerEvent;
	}
	
	
	
	public User getHalfOrange() {
		return halfOrange;
	}

	public void setHalfOrange(User halfOrange) {
		this.halfOrange = halfOrange;
	}
	
	public FriendManager getFriendsManager() {
		return friendsManager;
	}

	public void setFriendsManager(FriendManager friendsManager) {
		this.friendsManager = friendsManager;
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
	

	
}