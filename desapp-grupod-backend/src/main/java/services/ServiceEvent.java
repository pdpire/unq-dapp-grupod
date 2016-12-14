package services;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.transaction.Transactional;

import dto.EventDTO;
import model.Event;
import persistence.EventRepository;

public class ServiceEvent extends GenericService<Event> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transactional
	public Set<EventDTO> getEvent(String name) {
		return (Set<EventDTO>) ((EventRepository) this.getRepository()).getEventsByName(name);
	}
	
	@Transactional
	public Set<EventDTO> getEventByAmount(Integer amount) {
		return (Set<EventDTO>) ((EventRepository) this.getRepository()).getEventsByAmount(amount);
	}
	
	@Transactional
	public Set<EventDTO> getEventsRandom() {
		Set<EventDTO> events = new EventDTO().copyOnList(this.getRepository().findAll());
		Set<EventDTO> ret = new HashSet<EventDTO>();
		for (EventDTO eventDTO : events) {
			if(eventDTO.getId() > ((int)(new Random().nextInt(10) + 1))) {
				ret.add(eventDTO);
			}
		}
		return ret;
	}
	

}
