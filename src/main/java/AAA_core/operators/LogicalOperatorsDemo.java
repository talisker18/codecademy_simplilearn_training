package AAA_core.operators;


/**
 * 
 * returns true or false
 * 
 * && --> check 2. condition only if 1. condition is true
 *||
 *
 *!(condition)
 * 
 * */

public class LogicalOperatorsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//we can also use the short way operator to assign new boolean value
		boolean a = false;
		boolean b = true;
		
		b |= b|a;  //this means: b = b || a; --> true
		System.out.println(b);
		
		//same with AND
		b &= b&a;
		System.out.println(b); // b = b&&a --> false

	}

}
