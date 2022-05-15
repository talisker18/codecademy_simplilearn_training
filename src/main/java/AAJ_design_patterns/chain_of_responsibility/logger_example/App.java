package AAJ_design_patterns.chain_of_responsibility.logger_example;

public class App {
	
	public static void main(String[] args) {
		
		//get last logger in the chain / get complete chain
		AbstractLogger loggerChain = getChainOfLoggers();
		loggerChain.logMessage(AbstractLogger.INFO, "info log msg");
		System.out.println("---------");
		loggerChain.logMessage(AbstractLogger.DEBUG, "debug log msg");
		System.out.println("---------");
		loggerChain.logMessage(AbstractLogger.ERROR, "error log msg");
		
	}
	
	private static AbstractLogger getChainOfLoggers() {
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
		
		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
		
		return errorLogger; //error logger is the last in the chain, containing all other loggers
		
	}

}
