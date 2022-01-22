package AAA_core.operators;

/**
 * 
 *Bitwise operators are used to perform the manipulation of individual bits 
 *of a number. They can be used with any integral type 
 *(char, short, int, etc.). They are used when performing update and 
 *query operations of the Binary indexed trees.
 * 
 * */


public class BitwiseOperatorsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 5; //101
		int b = 7; //111
		
		//AND -> 101 & 111 = 101
		System.out.println("a & b: "+(a&b)); //set bit only if there is a 1 in both
		//OR -> 101 | 111 = 111
		System.out.println("a | b: "+(a|b)); //set bit if there is a 1 in at least one of the numbers
		//XOR, exclusive OR -> 101 ^ 111 = 10
		System.out.println("a ^ b: "+(a^b)); //set bit only at the place where a difference occurs (here at bit nr2)
		//NOT -> ~101 = 1010 -> -6
		System.out.println("~a: "+(~a)); //calculate the 2's complement -> invert 0101 (1 becomes to 0 and vice versa) -> 1010 -> add 1 -> 1011 -> -6
	}

}
