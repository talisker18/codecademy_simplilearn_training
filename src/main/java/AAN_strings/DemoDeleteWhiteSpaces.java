package AAN_strings;

public class DemoDeleteWhiteSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String test = "    welcome     joel     ";
		System.out.println(test.trim()); //deletes white spaces ONLY at beginning and end
		
		System.out.println("hello joel".trim());
		System.out.println("    hi".trim());
		
		//to delete ALL whitespaces...use regex and replace
		System.out.println("    hello     world     ".replaceAll("\\s", ""));

	}

}
