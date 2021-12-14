package AAL_exception_handling;

public class StackOverflowExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StackOverflowExceptionDemo demo = new StackOverflowExceptionDemo();
		
		demo.doSomethin();
		
		

	}
	
	
	public void doSomethin() {
		System.out.println("wait for stack overflow by calling method recursively");
		this.doSomethin();
	}

}
