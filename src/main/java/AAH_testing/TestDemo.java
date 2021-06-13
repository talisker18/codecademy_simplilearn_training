package AAH_testing;

public class TestDemo {

	private String message;
	
	public TestDemo(String message) {
		this.message=message;
	}
	
	public String printMessage() {
		System.out.println(this.message);
		return this.message;
	}

}
