package AAA_core.wrapper_classes_casting;

/**
 * type casting is the casting of primitive data types
 * there are 2 types of casting:
 * 		Widening Casting (automatically) - converting a smaller type to a larger type size: byte -> short -> char -> int -> long -> float -> double
 * 		Narrowing Casting (manually) - converting a larger type to a smaller size type: double -> float -> long -> int -> char -> short -> byte 
 * 
 * */
public class TypeCastingEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double d1 = 1.5;
		//Integer i1 =d1; -> with wrapper class, type casting does not work!!!!!!!!!!!!!!!!
		
		double d2 = 1.5;
		int i2 = (int) d2; //narrowing casting, double -> int
		
		int i3 = 5;
		double d3 = i3; //widening casting, int -> double...no explicit casting necessary

	}

}
