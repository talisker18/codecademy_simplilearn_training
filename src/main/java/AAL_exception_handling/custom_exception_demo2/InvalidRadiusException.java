package AAL_exception_handling.custom_exception_demo2;

public class InvalidRadiusException extends Exception {
	
	int radius;
	
	public InvalidRadiusException() {
		System.out.println("default constr");
	}
	
	public InvalidRadiusException(int radius) {
		this.radius = radius;
		System.out.println("the value of radius = "+this.radius+" was invalid");
	}

}
