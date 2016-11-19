package webService;

import javax.ws.rs.Path;

import services.ServiceEvent;

@Path("/event")
public class EventWebService {
	
	private ServiceEvent serviceEvent;

	public ServiceEvent getServiceEvent() {
		return serviceEvent;
	}

	public void setServiceEvent(ServiceEvent serviceEvent) {
		this.serviceEvent = serviceEvent;
	}

}
