package AAJ_design_patterns.chain_of_responsibility.logger_example;

public class FileLogger extends AbstractLogger{
	
	public FileLogger(int level) {
		super.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("file logger: "+ message);
		
	}

}
