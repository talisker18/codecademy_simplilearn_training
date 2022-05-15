package AAJ_design_patterns.chain_of_responsibility.logger_example;

public class ConsoleLogger extends AbstractLogger{
	
	public ConsoleLogger(int level) {
		super.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("standard console logger: "+ message);
		
	}

}
