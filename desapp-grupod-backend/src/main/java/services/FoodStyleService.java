package services;

import model.FoodStyle;

public class FoodStyleService extends GenericService<FoodStyle> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3079868537421832123L;
	private FoodStyleService service;

	public FoodStyleService getService() {
		return service;
	}

	public void setService(FoodStyleService service) {
		this.service = service;
	}

}
