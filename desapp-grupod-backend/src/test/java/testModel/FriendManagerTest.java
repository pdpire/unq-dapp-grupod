package testModel;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import model.FriendManager;
import model.User;

public class FriendManagerTest {
	
	@Test
	public void addFriendTest(){
		FriendManager friendManager = new FriendManager();
		User user = mock(User.class);
		
		friendManager.addFriend(user);
		
		assertEquals(friendManager.getUsers().size(),1);
//		assertEquals(friendManager.getUsers().get(0), user);
	}
	
	
	@Test
	public void removeFriendTest(){
		FriendManager friendManager = new FriendManager();
		User user = mock(User.class);
		friendManager.getUsers().add(user);
		
		friendManager.removeFriend(user);
		
		assertEquals(friendManager.getUsers().size(),0);
	}


}
