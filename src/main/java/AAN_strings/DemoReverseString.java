package AAN_strings;

/*
 * 
 * java interview!!!
 * 
 * */

public class DemoReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. option: simply put into char []
		String test = "abc";
		
		char [] arr = new char[test.length()];
		
		int indexCounter = 0;
		
		for(int i = test.length()-1; i>=0;i--) {
			arr[indexCounter] = test.charAt(i);
			indexCounter++;
		}
		
		//convert back to string
		String testReversed = new String(arr);
		System.out.println(testReversed);
		
		
	}

}
