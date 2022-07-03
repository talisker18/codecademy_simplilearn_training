package AAA_core.conventions;

/*
 * see also: /codecademy_simplilearn_training/src/main/java/AAA_core/wrapper_classes_casting/ParseStringToPrimitiveDatatype.java
 * 
 * 
 * */

public class RepresentationOfNumbers {

	
	public static void main(String[] args) {
		int num1 = 014; //octal represenation -> 12 in decimal
		int num2 = 0x14; //hexadecimal -> 20 in decimal
		int num3 = 0b1; //binary
		int num4 = 0b1111; // binary
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		
		
		double d1 = .5;
		double d2 = 5E2; // 5 * 10^2
		System.out.println(d2); //500
		double d3 = 5E4; // 5 * 10 ^4
		System.out.println(d3);
		
		double d4 = 5.5E3; //5.5 * 1000
		System.out.println(d4);
		
		double d5 = 5E-2; // 0.05 -> 5 * 10^-2 -> 5 * 1/10^2 -> 5 * 1/100 -> 5 * 0.01
		System.out.println(d5);
		System.out.println(5 * Math.pow(10, -2));
	}
}
