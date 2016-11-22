package testArchitecture;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.Test;

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

}