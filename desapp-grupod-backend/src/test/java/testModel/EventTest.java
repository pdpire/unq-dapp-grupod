package testModel;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import org.junit.Test;

import factory.EventFactory;
import model.Event;
import model.Place;

public class EventTest {
	
	@Test
	public void calculateCost(){
		
		
		Place place1 = mock(Place.class);
		
        when(place1.getCost()).thenReturn(5);
       
        Event event = EventFactory.eventWithPlace(place1);
      
		assertEquals(event.getCost(), 5);
		
	}

}
