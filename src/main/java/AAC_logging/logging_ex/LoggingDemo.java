package AAC_logging.logging_ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * see: https://www.tutorialspoint.com/log4j/log4j_sample_program.htm
 * 
 * ----> for logging with log4j
 * 
 * 
 * continue with youtube video
 * 
 * 
 * */

public class LoggingDemo {
	
	private static Logger logger = Logger.getLogger(LoggingDemo.class.getName()); //LoggingExample.class.getName() is the name of the logger
	//if we want to get the root logger: Logger logger = Logger.getLogger(""); --> this has by default console handler on it

	public static void main(String[] args) throws SecurityException, IOException {
		// TODO Auto-generated method stub
		/*
		 * different levels
		 * 
		 * SEVERE
		 * WARNING
		 * INFO
		 * CONFIG
		 * FINE
		 * FINER
		 * FINEST
		 * 
		 * */
		
		System.out.println(logger.getName());
		
		/**this will be logged **/
		logger.log(Level.INFO,"INFO test"); //at this point, the logger does not have any handler. so the handler of the root logger is used, and the root logger has per default only a console logger
		
		//console handler of root logger only logs INFO and above
		/**this wont be logged **/
		logger.log(Level.FINE,"FINE test");
		
		System.out.println("resetting the logger config");
		
		//reset the logger level. first reset log manager
		LogManager.getLogManager().reset(); //reset all NAMED loggers, but not the default one
		logger.setLevel(Level.ALL);
		
		//but we have also do config the handler of the logger
		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.SEVERE);
		
		//add handler
		logger.addHandler(ch);
		
		//since the handler has severe, only severe will be logged, it doesnt matter that the logger level is ALL
		/**this will be logged **/
		logger.log(Level.SEVERE,"test severe");
		/**this wont be logged **/
		logger.log(Level.WARNING,"test warning");
		
		System.out.println("change handler level to INFO. all level above INFO will be printed too");
		ch.setLevel(Level.INFO);
		logger.log(Level.INFO,"test info");
		logger.log(Level.SEVERE,"test severe");
		
		System.out.println("change logger level to SEVERE. the INFO will not be printed because logger level acts as an additional filter. so we have 2 filters, handler and logger");
		logger.setLevel(Level.SEVERE);
		
		logger.log(Level.INFO,"test info");
		logger.log(Level.SEVERE,"test severe");
		
		System.out.println("set logger level back to ALL");
		logger.setLevel(Level.ALL);
		
		System.out.println("lets add a filehandler");
		FileHandler fh = new FileHandler("logs.log");
		System.out.println("also create a Formatter. SimpleFormatter does simple output, but we can also define custom formatter");
		fh.setFormatter(new SimpleFormatter());
		fh.setLevel(Level.INFO);
		logger.addHandler(fh);
		
		logger.log(Level.INFO,"test info for console and filehandler (both got INFO at this point)");
		
		
		
		try {
			LogManager.getLogManager().readConfiguration(new FileInputStream("src/main/java/AAC_logging/logging.properties")); //load config into logger
			
			
			
			FileHandler fhandler = new FileHandler("Logfile.txt");
			logger.addHandler(fhandler);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
