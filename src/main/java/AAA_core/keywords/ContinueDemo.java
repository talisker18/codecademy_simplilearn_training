package AAA_core.keywords;

/**
 * 
 * The continue statement breaks one iteration (in the loop), if a specified condition occurs, and continues with the next iteration in the loop.

This example skips the value of 4:
 * 
 * */

public class ContinueDemo {

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			  if (i == 4) {
			    continue; //break current iteration in loop here and continue with next iteration
			  }
			  System.out.println(i);
		}
	}
}
