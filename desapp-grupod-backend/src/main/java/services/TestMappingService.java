package services;

import model.TestMapping;
import persistence.TestMappingRepository;

public class TestMappingService extends GenericService<TestMapping> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TestMappingRepository repositorio;

	public TestMappingRepository getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(TestMappingRepository repositorio) {
		this.repositorio = repositorio;
	}


	
}
