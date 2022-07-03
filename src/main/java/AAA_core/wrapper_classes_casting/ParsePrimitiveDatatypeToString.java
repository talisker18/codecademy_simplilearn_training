package AAA_core.wrapper_classes_casting;

public class ParsePrimitiveDatatypeToString {
	
	public static void main(String[] args) {
		
		double d = 1.5;
		Double dWrapper = 1.5;
		String str1 = String.valueOf(d);
		String str2 = String.valueOf(dWrapper);
		
		//we can do same with e.g. boolean and all other primitive datatypes because there are overloaded methods
		String str3 = String.valueOf(true);
		
		//what happens inside valueOf() method?
		
		/*
		 * method valueOf():
		 * 
		 * public static String valueOf(double d){
		 * 	return Double.toString(d);
		 * }
		 * 
		 * 
		 * ....and than the toString method of Double class
		 * 
		 * public static String toString(double d){
		 * 	return new FloatingDecimal(d).toJavaFormatString();	
		 * }
		 * 
		 * 
		 * */
	}

}
