package AAA_core.inner_classes;

import AAA_core.inner_classes.InnerClassDemo1.Inner;

public class InnerClassDemo2 {
	
	private String msg = "Welcome to java";
	
	 void display(){  
		 class Inner{  
			 void msg(){
				 System.out.println(msg);
			 }  
		 } 
		 
		 Inner i = new Inner();
		 i.msg();
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerClassDemo2 outerClass = new InnerClassDemo2();
		outerClass.display();
		
		//again, we cant create an obj of Inner outside the class
		//Inner inner = new Inner();
		//...and we cant create Inner class obj through InnerClassDemo2 because Inner
		//class is inside a method of InnerClassDemo2
		//InnerClassDemo2.Inner innerClassObj = outerClassObj.new Inner();

	}

}
