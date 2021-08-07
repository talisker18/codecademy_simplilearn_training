package AAE_packages.java_lang;

public class StringImmutableDemo {
	
	public static void main(String[] args) {
		String a = "hello world";
		
		System.out.println(a);
		
		changeString(a); //will not change value because String class is immutable
		
		System.out.println(a);
		
		a.replace('h', 'H'); //will not change value because String class is immutable
		System.out.println(a);
		
		a = a.replace('h', 'H'); //this will work. we create completely new object containing "Hello world". a is now pointing to that object and not to object "hello world" anymore
		System.out.println(a);
	}
	
	public static void changeString(String str) { //str is a copy of String "a"...see AAA_core.passing_by_value package as well
		str.replace('h', 'H'); //we try to change value of the copy "str". this should work because java is passing by value...but it wont because String
		//class is immutable
	}
}
