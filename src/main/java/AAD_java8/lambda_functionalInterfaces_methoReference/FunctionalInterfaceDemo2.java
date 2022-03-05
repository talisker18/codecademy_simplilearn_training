package AAD_java8.lambda_functionalInterfaces_methoReference;

public class FunctionalInterfaceDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringFunction exclaim = (String s) -> {
			return s + "!";
			}
		;
		
		//but we can also leave out the {} and the type String of param
	    StringFunction ask = (s) -> s + "?";
	    printFormatted("Hello", exclaim);
	    printFormatted("Hello", ask);
		

	}
	

	public static void printFormatted(String str, StringFunction format) {
	    String result = format.run(str);
	    System.out.println(result);
	}

}

interface StringFunction{
	String run(String str);
}
