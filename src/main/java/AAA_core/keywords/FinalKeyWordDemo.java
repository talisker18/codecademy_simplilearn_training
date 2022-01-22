package AAA_core.keywords;

/**
 * 
 * see also: /codecademy_simplilearn_training/src/main/java/AAJ_design_patterns/builder_pattern/static_builder_demo/Employee.java
 * 
 * */

public class FinalKeyWordDemo {
	
	final String str = "test1"; //this can not be changed
	final String firstName; //if we do nit initialize a final var here, we have to in constructor
	
	public FinalKeyWordDemo() {
		this.firstName = "joel";
		//this.str = "test2"; --> this is not possible because final var is already initialized
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
