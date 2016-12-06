package testModel;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import factory.ProfileFactory;

import model.Event;
import model.EventType;
import model.Profile;

public class ProfileTest {
	
	@Test
 	public void matchingProfileWithFoodTest(){
		
		Profile profile = ProfileFactory.profileWithFoodStyles();
		
		Event event = mock(Event.class);
		EventType et = mock(EventType.class);
		
		event.setType(et);
		
		when(event.getType()).thenReturn(et);
		
		when(et.compare("entertainment")).thenReturn(false);
		when(et.compare("food")).thenReturn(true);
		
		assertTrue(profile.matchingProfiles(event));
	}
	
	
	@Test
 	public void matchingProfileWithEntertainmentTest(){
		
		Profile profile = ProfileFactory.profileWithMoviesAndMusical();
		
		Event event = mock(Event.class);
		EventType et = mock(EventType.class);
		
		event.setType(et);
		
		when(event.getType()).thenReturn(et);
		
		when(et.compare("entertainment")).thenReturn(true);
		when(et.compare("food")).thenReturn(false);
		
		assertTrue(profile.matchingProfiles(event));
	}
	
	@Test
 	public void matchingProfileWithoutPleasures(){
		
		Profile profile = new Profile();
		
		Event event = mock(Event.class);
		EventType et = mock(EventType.class);
		
		event.setType(et);
		
		when(event.getType()).thenReturn(et);
		
		when(et.compare("entertainment")).thenReturn(true);
		when(et.compare("food")).thenReturn(false);
		
		assertTrue(! profile.matchingProfiles(event));
	}


}
