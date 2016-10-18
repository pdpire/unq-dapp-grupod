package persistence;

import model.FoodStyle;

public class FoodStyleRepositories extends HibernateGenericDAO<FoodStyle> implements GenericRepository<FoodStyle>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7407312481050889417L;

	@Override
	protected Class<FoodStyle> getDomainClass() {
		
		return FoodStyle.class;
	}

	
}
