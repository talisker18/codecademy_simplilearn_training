package AAN_strings;

public class CompareToDemo {

	public static void main(String[] args) {
		
		/**
		 * java docu:
		 * 
		 * int compareTo(String anotherString)
		 * 
		 * Compares two strings lexicographically. 
		 * Returns an integer indicating whether this string is greater than (result is > 0), 
		 * equal to (result is = 0), or less than (result is < 0) the argument.
		 * 
		 * 
		 * */
		
		/*
		 * 
		 * char can be converted to int value. The int value of a char represents the ASCII value of that char.
		 * when comparing a string:  e.g. "aeeeee" compared to "eeeeaaaa" -> only 'a' from first string is compared to 'e' from second string
		 * 
		 * */
		
		int one = 'a';
		System.out.println(one); //ASCII value 97
		int two = 'e';
		System.out.println(two); //ASCII value 101
		
		System.out.println("aeeeee".compareTo("eeeeaaaa")); //-4, because 97 - 101
		
		one = 'b';
		System.out.println(one); //ASCII value 98
		two = 'z';
		System.out.println(two); //ASCII value 122
		
		System.out.println("be".compareTo("za")); //-24 because 98 - 122
		
	}

}
