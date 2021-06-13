package AAD_java8;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ForEachExampleWithConsumerInterface {

	public static void main(String[] args) {
		//in forEach() method of ArrayList, we can use the Consumer functional interface
		
		/**the Consumer Interface
		 * 
		 * @FunctionalInterface
			public interface Consumer<T>
			
			Represents an operation that accepts a single input argument and returns no result. Unlike most other functional interfaces, 
			Consumer is expected to operate via side-effects.
			
			This is a functional interface whose functional method is accept(Object).
		 * 
		 * */
		
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<Integer>();
	    numbers.add(5);
	    numbers.add(9);
	    numbers.add(8);
	    numbers.add(1);
	    numbers.forEach( (n) -> { //with Consumer, we can not specify a return value
	    	System.out.println(n); 
	    	} 
	    );
	    
	  //with Consumer, we can not specify a return value
	    /*numbers.forEach( (n) -> {
	    	return n; 
	    	} 
	    );*/
	    
	    System.out.println();
	    
	    ArrayList<Integer> numbers2 = new ArrayList<Integer>();
	    numbers2.add(5);
	    numbers2.add(9);
	    numbers2.add(8);
	    numbers2.add(1);
	    Consumer<Integer> method = (n) -> { 
	    	System.out.println(n); 
	    	}
	    ;
	    
	    numbers2.forEach(method);

	}

}
