package aspects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class LoggingWithAspect {
	
	private static Logger log = Logger.getLogger(LoggingWithAspect.class.getName());

	public LoggingWithAspect() {

		PropertyConfigurator.configure("src/main/java/log4j.properties");
	}

	public Object tiempoPasado(ProceedingJoinPoint punto) throws Throwable {

		MethodSignature signature = (MethodSignature) punto.getSignature();
		String nameMethod = signature.getMethod().getName();
		log.info("*************** Start: " + nameMethod + " *************** ");
		this.printParameters(punto.getArgs());
		Long timeInitial = System.currentTimeMillis();
		Object response = punto.proceed();
		Long timeEnd = System.currentTimeMillis();
		log.info("***************  End: " + nameMethod + " *************** ");
		Long total = timeEnd - timeInitial;
		log.info("*************** Total time  milliseconds : " + total + " *************** ");
		return response;
	}

	public void printParameters(Object[] objects) {
		log.info("--------------------- Parameters -------------------------------");

		for (Object o : objects) {
			log.info(o.toString());
		}

		log.info("--------------------- Parameters -------------------------------");

	}
	
//	public Object invoke(final MethodInvocation methodInvocation) throws Throwable {
//		 
//		final long startTime = System.currentTimeMillis();
//		try {
//			return methodInvocation.proceed();
//		} 
//		finally {
//			// generamos la lista de argumentos que recibe el metodo separados por una coma
//			String arguments = new String();			
//			for (int i = 0; i < methodInvocation.getArguments().length; i++) {
//				arguments += methodInvocation.getArguments()[i] + " ,";				
//			}
//			
//			// el metodo recibe al menos un argumento quitamos el espacio y la coma del final
//			if (arguments.length()> 0) {
//				arguments = arguments.substring(0, arguments.length() - 2);
//			}
//			
//			log.debug("[ " +	(System.currentTimeMillis() - startTime) + " ms" + " ] " +
//						methodInvocation.getMethod().getDeclaringClass().getSimpleName() + "." +
//						methodInvocation.getMethod().getName() + "(" +
//						arguments + ")");
//		}
//	}

}
