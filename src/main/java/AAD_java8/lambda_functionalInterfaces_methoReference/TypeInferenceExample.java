package AAD_java8.lambda_functionalInterfaces_methoReference;

public class TypeInferenceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		////////////////////////type inference///////////////////////////
		
		//= typ rückschluss
				
		//mit lambda, compiler macht type inference
		
		StringLengthLambda stringLength= (String s) -> s.length();		
		
		int a = stringLength.getLength("Hello World!");
		
		System.out.println(a);
		
		//hier kann compiler type inference machen. somit können wir sogar das String weglassen bei parameter übergabe, da er vom
		//interface her rückschliessen kann, dass input parameter vom typ string ist
		
		StringLengthLambda stringLength2= (s) -> s.length();
		
		//type inference auf return typ von getLength = int
		int b = stringLength2.getLength("Hello World!")-5;
		
		System.out.println(b);
		
		//nun geht es noch kürzer, wenn ich das ganze in eine static methode packe
		
		printLambdaStringLength(stringLength2, "Hello world!!!!!!!!!!!!!!!!!!!!!");
		

		

	}
	
	//inner interface
	
	interface StringLengthLambda{
		int getLength(String s);
	}
	
	public static void printLambdaStringLength(StringLengthLambda l, String s) {
		System.out.println(l.getLength(s));
	}

}
