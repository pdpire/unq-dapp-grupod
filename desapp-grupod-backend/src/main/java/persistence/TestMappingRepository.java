package persistence;

import model.TestMapping;

public class TestMappingRepository extends HibernateGenericDAO<TestMapping> implements GenericRepository<TestMapping> {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<TestMapping> getDomainClass() {
		return TestMapping.class;
	}

}
