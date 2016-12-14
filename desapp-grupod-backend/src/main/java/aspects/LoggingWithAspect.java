package aspects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;

import org.springframework.util.StopWatch;


public class LoggingWithAspect{
	
	private static Logger log = Logger.getLogger(LoggingWithAspect.class.getName());

	public LoggingWithAspect() {

		PropertyConfigurator.configure("src/main/java/log4j.properties");
	}
	
	public Object timeMethod(ProceedingJoinPoint call) throws Throwable {
		 
        StopWatch clock = new StopWatch("log method");
         
        try {
            clock.start(call.toShortString());
            return call.proceed();
        } finally {
            clock.stop();
            
            String arguments = new String();			
			for (int i = 0; i < (call).getArgs().length; i++) {
				arguments += (call).getArgs()[i] + " ,";				
			}
            		
			log.info(clock.prettyPrint() + "-parameters: " + arguments);
        }
    }

}
