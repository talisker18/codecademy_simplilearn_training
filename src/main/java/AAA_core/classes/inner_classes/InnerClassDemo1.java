package AAA_core.classes.inner_classes;

/*
 * 
 * The purpose of nested classes is to group classes that belong together, 
 * which makes your code more readable and maintainable.
 * 
 * */



public class InnerClassDemo1 {
	
	private String msg = "Welcome to java";
	
	class Inner{
		void hello() {
			System.out.println(msg+", Lets start learning");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerClassDemo1 outerClassObj = new InnerClassDemo1();
		//Inner i2 = new Inner(); -> this is not possible, we need an instance of InnerClassDemo
		InnerClassDemo1.Inner innerClassObj = outerClassObj.new Inner();
		
		innerClassObj.hello();

	}

}
