package AAA_core.operators;


/**
 * 
 * unary operators require only 1 operator
 * 
 * */

public class UnaryOperatorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean val1 = false;
		int val2 = 0;
		int val3 = 0;
		
		while(!val1) { // ! is an unary operator
			
			val2++; //++ is an unary operator
			val3 = val3 -1; //this is also an unary operator
			
			if(val2 == 10) {
				val1 = true;
			}
			
		}
		
		System.out.println(val3++); //this will first print val3 and then increment
		System.out.println(++val3); //this will first increment then print

	}

}
