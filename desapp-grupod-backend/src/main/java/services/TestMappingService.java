 package services;

import model.TestMapping;
import persistence.TestMappingRepository;

public class TestMappingService extends GenericService<TestMapping> {

	/**
	 * pedir el get aca
	 * cambiar privacidad de las variable
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
