package testModel;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
//
//import java.util.ArrayList;
//
import org.junit.Test;

import model.Event;
//
import model.HandlerEvent;
import model.User;
//import model.HandlerFilter;
//import model.Place;

public class HandlerEventTest {
	
//	@Test
//	public void createEventTest(){
//		HandlerFilter handlerFilter = mock(HandlerFilter.class);
//		HandlerEvent handlerEvent = new HandlerEvent(handlerFilter);
//	
//		Place place1 = mock(Place.class);
//		Place place2 = mock(Place.class);
//		
//		ArrayList<Place> places = new ArrayList<Place>();
//		places.add(place1);
//		places.add(place2);
//		
//        when(place1.getCost()).thenReturn(5);
//        when(place2.getCost()).thenReturn(10);
//	
//		handlerEvent.createEvent(null, null, null, places);
//		
//		assertEquals(handlerEvent.getEvents().size(), 1);
//	}
//	
	
	@Test
	public void gotToEventTest(){
		HandlerEvent handlerEvent = new HandlerEvent();
		
		Event event = mock(Event.class);
		User user = mock(User.class);
		
		handlerEvent.setUserAdmin(user);
		
		doNothing().when(event).addGuest(user);
		
		handlerEvent.goToEvent(event);
		
		verify(event, times(1)).addGuest(user);
		
	}


}
