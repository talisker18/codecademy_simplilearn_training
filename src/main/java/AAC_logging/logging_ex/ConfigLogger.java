package AAC_logging.logging_ex;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/*
 * this Logger will be used in /codecademy_simplilearn_training/src/main/java/AAC_logging/logging_ex/LoggingDemoUseLoggerOfOtherClass.java
 * 
 * */

public class ConfigLogger {
	public static Logger logger = Logger.getLogger(ConfigLogger.class.getName());
	
	//make logger config in static block
	static {
		System.out.println("static block called");
		LogManager.getLogManager().reset();
		logger.setLevel(Level.ALL);

		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.SEVERE);
		logger.addHandler(ch);
	}
	
	public ConfigLogger() {
		System.out.println("from constr");
	}

}
