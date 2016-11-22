package factory;

import model.User;

public class UserFactory {
//
//	public static User userWithHandlerEvent(HandlerEvent handlerEvent) {
//
//		User user = new User();
//		user.setHandlerevent(handlerEvent);
//
//		return user;
//	}
	
	public static User anyUser(){
		
	
		User us = new User(null, null, null, null, null, null, 0);
		
		return us;
	}

}
