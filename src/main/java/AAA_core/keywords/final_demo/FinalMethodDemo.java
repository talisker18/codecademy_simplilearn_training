package AAA_core.keywords.final_demo;

/*
 * The final modifier for finalizing the implementations of classes, methods, and variables.

We can declare a method as final, once you declare a method final it cannot be overridden. So, you cannot modify a final method from a sub class.

The main intention of making a method final would be that the content of the method should not be changed by any outsider.
 * 
 * 
 * */

public class FinalMethodDemo {
	
	   public final void display(){
	      System.out.println("Hello welcome to Tutorialspoint");
	   }
	   
	   class Sample extends FinalMethodDemo{
	      public void display(){ //can not be overriden since method is final
	         System.out.println("hi");
	      }
	   }
	   
	   public static void main(String args[]){
		      new FinalMethodDemo().display();
		   }
	}
