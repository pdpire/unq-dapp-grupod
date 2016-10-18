package testModel;

import org.junit.Test;

import factory.UserFactory;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import model.Event;
import model.FriendManager;
import model.Profile;
import model.User;

public class UserTest{

	@Test
	public void addFriendTest(){
		
		FriendManager friendManager = mock(FriendManager.class);
		User user = UserFactory.anyUser();
		User friend = UserFactory.anyUser();
		
		user.setFriends(friendManager);
		
		doNothing().when(friendManager).addFriend(friend);
		
		user.addFriend(friend);
		
		verify(friendManager, times(1)).addFriend(friend);
	}
	
	@Test
	public void removeFriendTest(){
		FriendManager friendManager = mock(FriendManager.class);
		User user = UserFactory.anyUser();
		User friend = UserFactory.anyUser();
		user.setFriends(friendManager);
		
		doNothing().when(friendManager).removeFriend(friend);
		
		user.removeFriend(friend);
		
		verify(friendManager, times(1)).removeFriend(friend);
	}
	
	@Test
 	public void matchingProfilesTest(){
		Profile profile = mock(Profile.class);
		Event event = mock(Event.class);
		User user = UserFactory.anyUser();
		user.setProfile(profile);
		
		when(profile.matchingProfiles(event)).thenReturn(true);
		
		boolean res = user.matchingProfiles(event);
		
	    verify(profile, times(1)).matchingProfiles(event);
		assertTrue(res);
	}
//	
//	@Test
//	public void createEventTest(){
//		HandlerEvent handlerEvent = mock(HandlerEvent.class);
//		User user = UserFactory.userWithHandlerEvent(handlerEvent);
//		User guest1 = new User();	
//		User guest2 = new User();
//		Date date = mock(Date.class);
//		
//		Place place = mock(Place.class);
//		ArrayList<Place> places = new ArrayList<Place>();
//		places.add(place);
//		
//		ArrayList<User> guests = new ArrayList<User>();
//		guests.add(guest1);
//		guests.add(guest2);
//		
//		doNothing().when(handlerEvent).createEvent(user, guests,date, places);
//		
//		user.createEvent(user, guests, date, places);
//		
//		verify(handlerEvent, times(1)).createEvent(user, guests,date, places);
//	}
//


}
