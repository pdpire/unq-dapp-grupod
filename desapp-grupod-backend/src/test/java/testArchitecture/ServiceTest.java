package testArchitecture;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;
import org.reflections.Reflections;

import services.GenericService;

import static org.junit.Assert.*;

public class ServiceTest {

	@Test
	public void transactionalTest() {

		Class serviceClass = GenericService.class;

		Method[] methods = serviceClass.getDeclaredMethods();

		boolean retFinal = false;

		for (Method method : methods) {

			Annotation[] annot = method.getAnnotations();

			int cont = 0;

			if (annot.length > 0) {

				for (Annotation annotation : annot) {

					if (annotation.annotationType().getSimpleName().equals("Transactional"))
						cont++;

				}

				retFinal = cont > 0;
			}

		}

		assertTrue(retFinal);
	}
	
	
	
	
	@Test
	public void testPackegeService() throws InstantiationException, IllegalAccessException {

		Integer errores = 0;

		ArrayList<String> packages = new ArrayList<String>();

		packages.add("model");
		packages.add("persistence");
		packages.add("webService");
		packages.add("dto");
		packages.add("builders");
		//packages.add("service");

		for (String pack : packages) {
			
			Object[] clases = this.getAllClassForPackage(pack, GenericService.class);
			errores += clases.length;
		}
		
		assertTrue(0 == errores);
	}
	
	public Object[] getAllClassForPackage(String namePackage, Class clase) {

		Reflections reflections = new Reflections(namePackage);
		Object[] classes = (reflections.getSubTypesOf(clase)).toArray();
		return classes;

	}

}