package AAA_core.wrapper_classes_casting;

public class ParseStringToPrimitiveDatatype {

	
	public static void main(String[] args) {
		System.out.println("100 im dezimalsystem: "+Integer.parseInt("100"));
		System.out.println("100 im oktalsystem: "+Integer.parseInt("100", 8));
		System.out.println("100 im hexadezimalsystem: "+Integer.parseInt("100", 16));
		
		double d = Double.parseDouble("1.5");
	}
}
