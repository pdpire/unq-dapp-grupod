package services;

import model.FoodStyle;

public class FoodStyleService extends GenericService<FoodStyle> {

	private FoodStyleService service;

	public FoodStyleService getService() {
		return service;
	}

	public void setService(FoodStyleService service) {
		this.service = service;
	}

}
