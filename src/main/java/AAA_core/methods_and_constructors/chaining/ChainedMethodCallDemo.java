package AAA_core.methods_and_constructors.chaining;

/**
 * 
 * this pattern is used for e.g. BuilderPattern, see AAJ_design_patterns.builder_pattern
 * 
 * since we return an actual object of the class, we can chain multiple method calls
 * 
 * because: c1.doSomething1() returns a instance of ChainedMethodCallDemo. On that instance, we can call again a method and so on
 * 
 * */

public class ChainedMethodCallDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChainedMethodCallDemo c1 = new ChainedMethodCallDemo();
		
		c1.doSomething1().doSomething2();
		
		ChainedMethodCallDemo c2 = new ChainedMethodCallDemo();
		
		//but as soon as we use a method call with void, the chain breaks...
		
		c2.doSomething3(); //chain breaks after 1st method call
		
		c2.doSomething1().doSomething3(); //chain breaks after 2nd method call

	}
	
	public ChainedMethodCallDemo doSomething1() {
		System.out.println("doSomething1");
		return this;
	}
	
	public ChainedMethodCallDemo doSomething2() {
		System.out.println("doSomething2");
		return this;
	}
	
	public void doSomething3() {
		System.out.println("doSomething3");
	}

}
