package AAC_logging.logging_ex;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingDemoUseLoggerOfOtherClass {

	public static void main(String[] args) {
		
		//ConfigLogger l = new ConfigLogger();
		
		//use logger of /codecademy_simplilearn_training/src/main/java/AAC_logging/logging_ex/ConfigLogger.java
		ConfigLogger.logger.log(Level.INFO,"test info"); //will not be logeed because console handler of used logger is on SEVERE
		ConfigLogger.logger.log(Level.SEVERE,"test severe");
	}

}
