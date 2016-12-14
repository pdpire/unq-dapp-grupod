package testArchitecture;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.reflections.Reflections;

import services.GenericService;

import static org.junit.Assert.*;

public class ServiceTest {

	@Test
	public void transactionalTest() {

		boolean retSuperClass = false;
		boolean retSubClasses = false;

		Class serviceClass = GenericService.class;

		retSuperClass = this.checkTransactional(serviceClass);

		Object[] clases = this.getAllClassForPackage("services", GenericService.class);

		//boolean retFinal = true;

		for (Object element : clases) {

			String name = element.toString();
			String[] sp = name.split(" ");
			List<String> spArray = new ArrayList<String>();

			for (String string : sp) {
				spArray.add(string);
			}

			Class clase = null;

			try {
				clase = Class.forName(spArray.get(1));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			retSubClasses = this.checkTransactional(clase);
			
			if(!retSubClasses)
				break;

		}
		
		

		assertTrue(retSuperClass && retSubClasses);

	}


	public boolean checkTransactional(Class clase) {

		boolean retFinal = true;

		Method[] methods = clase.getDeclaredMethods();

		for (Method method : methods) {

			if (method.getName() != "getRepository" && method.getName() != "setRepository") {

				Annotation[] annot = method.getAnnotations();
 				int cont = 0;

				// if (annot.length > 0) {

				for (Annotation annotation : annot) {

					if (annotation.annotationType().getSimpleName().equals("Transactional"))
						cont++;

				}

				retFinal = (cont > 0);

				if (!retFinal)
					break;

				// }

			}

		}

		return retFinal;
	}

	public Object[] getAllClassForPackage(String namePackage, Class clase) {

		Reflections reflections = new Reflections(namePackage);
		Object[] classes = (reflections.getSubTypesOf(clase)).toArray();
		return classes;

	}
	
	
//	@Test
//	public void testPackegeService() throws InstantiationException, IllegalAccessException {
//
//		Integer errores = 0;
//
//		ArrayList<String> packages = new ArrayList<String>();
//
//		packages.add("model");
//		packages.add("persistence");
//		packages.add("webService");
//		packages.add("dto");
//		packages.add("builders");
//		//packages.add("service");
//
//		for (String pack : packages) {
//			
//			Object[] clases = this.getAllClassForPackage(pack, GenericService.class);
//			errores += clases.length;
//		}
//		
//		assertTrue(0 == errores);
//	}

}