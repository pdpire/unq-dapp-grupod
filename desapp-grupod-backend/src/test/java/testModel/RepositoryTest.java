package testModel;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import model.Event;
import model.RepositoryEvent;


public class RepositoryTest {
	
	@Test
	public void addFriendTest(){
		
		Event event = mock(Event.class);
		RepositoryEvent re = new RepositoryEvent();
	
		re.addEvents(event);
		
		assertEquals(re.getEvents().size(), 1);
		
	}
	
}
