package testModel;

import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;

import model.FriendManager;
import model.HandlerEvent;
import model.Place;
import model.User;

public class UserTest{
	
	@Test
	public void addFriendTest(){
		FriendManager friendManager = mock(FriendManager.class);
		User user = new User();
		User friend = new User();
		user.setFriends(friendManager);
		
		doNothing().when(friendManager).addFriend(friend);
		
		user.addFriend(friend);
		
		verify(friendManager, times(1)).addFriend(friend);
	}
	
	@Test
	public void removeFriendTest(){
		FriendManager friendManager = mock(FriendManager.class);
		User user = new User();
		User friend = new User();
		user.setFriends(friendManager);
		
		doNothing().when(friendManager).removeFriend(friend);
		
		user.removeFriend(friend);
		
		verify(friendManager, times(1)).removeFriend(friend);
	}
	
	@Test
	public void createEventTest(){
		HandlerEvent handlerEvent = mock(HandlerEvent.class);
		User user = new User();
		user.setHandlerevent(handlerEvent);
		User guest1 = new User();
		User guest2 = new User();
		
		Date date = mock(Date.class);
		
		Place place = mock(Place.class);
		ArrayList<Place> places = new ArrayList<Place>();
		places.add(place);
		
		ArrayList<User> guests = new ArrayList<User>();
		guests.add(guest1);
		guests.add(guest2);
		
		doNothing().when(handlerEvent).createEvent(user, guests,date, places);
		
		user.createEvent(user, guests, date, places);
		
		verify(handlerEvent, times(1)).createEvent(user, guests,date, places);
	}



}
