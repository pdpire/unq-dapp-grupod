package factory;


import model.HandlerEvent;
import model.User;

public class UserFactory {

	public static User userWithHandlerEvent(HandlerEvent handlerEvent) {

		User user = new User();
		user.setHandlerevent(handlerEvent);

		return user;
	}

}
