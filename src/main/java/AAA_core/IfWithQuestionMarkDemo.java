package AAA_core;

/**
 * 
 * also called ternary operator
 * 
 * */

public class IfWithQuestionMarkDemo {
	
	public static String printEvenOrOdd(int digit) {
		
		/*same as: 
			if even -> return even
			if odd -> return odd
			*
			*/
		return (digit % 2 == 0) ? "Even": "Odd";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(printEvenOrOdd(3));
	}

}
