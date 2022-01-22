package AAN_strings;

public class StringPoolVsHeapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "hello";
		String s2 = "hello";
		
		if(s1==s2) { //they are equal because they are pointing to same object in string pool.
			//string pool: when declaring string without new operator, JVM will look up in string pool if there is a string
			//with "hello". if yes, point s1 and s2 to that object. if no, create new object with "hello" and point s1 and s2 to it
			System.out.println("equal");
		}else {
			System.out.println("different");
		}
		
		String s3 = new String("hello");
		String s4 = new String("hello");
		
		if(s3==s4) {
			System.out.println("equal");
		}else {
			System.out.println("different");
		}
		
		/*
		 * 
		 * When we create a String object using the new() operator, it always creates a new object in heap memory. 
		 * On the other hand, if we create an object using String literal syntax e.g. “Baeldung”, it may 
		 * return an existing object from the String pool, if it already exists. Otherwise, it will create a 
		 * new String object and put in the string pool for future re-use.
		 * 
		 * */
		
		
		
		//for primitive vars, the values are compared because there is no object
		int i = 10;
		int j = 10;
		
		if(i==j) {
			System.out.println("equal");
		}else {
			System.out.println("different");
		}

	}

}
