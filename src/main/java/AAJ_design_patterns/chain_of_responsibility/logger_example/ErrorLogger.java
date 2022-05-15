package AAJ_design_patterns.chain_of_responsibility.logger_example;

public class ErrorLogger extends AbstractLogger{
	
	public ErrorLogger(int level) {
		super.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("error logger: "+ message);
	}

}
