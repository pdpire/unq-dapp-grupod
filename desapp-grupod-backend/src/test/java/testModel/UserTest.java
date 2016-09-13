package testModel;

import org.junit.Test;

import static org.mockito.Mockito.*;

import model.FriendManager;
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



}
