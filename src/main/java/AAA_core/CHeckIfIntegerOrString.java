package AAA_core;

/*
 * in some cases we have to check, e.g. from an user input, if value is of type string or int
 * 
 * 
 * */

public class CHeckIfIntegerOrString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tryToParseInt("10");
		tryToParseInt("str");
		

	}
	
	private static void tryToParseInt(String str) {
		try {
			int i = Integer.parseInt(str);
			System.out.println("this is a number");
		} catch (NumberFormatException e) {
			System.out.println("this is NOT a number");
		}
	}

}
