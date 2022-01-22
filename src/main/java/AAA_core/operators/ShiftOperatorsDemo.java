package AAA_core.operators;


/**
 * 
 * used to shift the bits of a number to left or right
 * 
 * left: <<
 * right: >>
 * unsigned right shift operator: >>>
 * 
 * */

public class ShiftOperatorsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(20 << 2); //shift 10100 2 bits to the left -> 1010000 = 80
		
		System.out.println(20 >> 2); //shift 10100 2 bits to the right -> 101 = 5
		
		System.out.println(20 >>> 2); //same (?)

	}

}
