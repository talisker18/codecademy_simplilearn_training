package AAA_core;

/**
 * not used a lot because of readability
 * 
 * better to use array or a List instead of varargs
 * 
 * */


public class VarargsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doSomething("1","2","3");

	}
	
	
	public static void doSomething(String... args) {
		
		for(String str: args) {
			System.out.println(str);
		}
	}

}
