package AAN_strings;

public class PlaceholderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "hello %s%d";
		
		String str2 = "joel";
		int i = 69;
		
		str1 = str1.formatted("joel",69);
		
		System.out.println(str1);

	}

}
