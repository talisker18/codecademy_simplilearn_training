package AAA_core.generics_and_wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoundedGenericsDemo {

	public static void main(String[] args) {
		
		/**upper bounds!!!!!!!!!!!!!!!!!!!!
		 * 
		 * 
		 * 
		 * 
		 * */
		// TODO Auto-generated method stub
		Integer[] arr1 = {1,2,3};
		List <Integer> list1 = BoundedGenericsDemo.doSomething(arr1);
		System.out.println(list1);
		
		Double[] arr2 = {1.0,2.0,3.0};
		List <Double> list2 = BoundedGenericsDemo.doSomething(arr2);
		System.out.println(list2);
		
		//but the following wont work because its not a child class of Number
		String[] arr3= {"1","2"};
		//List <String> list3 = BoundedGenericsDemo.doSomething(arr3); //compile error!!!!!!!!!!
		
		//bounded generics on classes
		Example <Integer> ex1 = new Example();
		ex1.setNum(14);
		System.out.println(ex1.getNum());
		
		Example <Double> ex2 = new Example();
		ex2.setNum(14.5);
		System.out.println(ex2.getNum());
		
		Example <String> ex3 = new Example(); 
		/**compile error: Bound mismatch: The type String is not a valid substitute for the bounded parameter <T extends Number> of the type Example<T>*/
		
		//some other example...look at the method doSomething2()
		Integer i1 = BoundedGenericsDemo.doSomething2(4);
		Double d1 = BoundedGenericsDemo.doSomething2(4.5);
		Number n1 = BoundedGenericsDemo.doSomething2(4.5);
		Object o1 = BoundedGenericsDemo.doSomething2(4.5); //Object also works with <T extends Number> because Number extends Object
		/*
		 * 				  object
		 * 					|
		 * 				  number
		 * 				  |     |
		 * 			  Integer  Byte...
		 * 
		 * -->remember: only 1 class can be extended!!
		 * 
		 * */
		String s1 = BoundedGenericsDemo.doSomething2("4.5"); //compile error
		
		
		
		/**lower bounds!!!!!!!!!!!!!!!!!!!!
		 * 
		 * 
		 * 
		 * 
		 * */
		@SuppressWarnings("unchecked") //without this we get a cast warning by compiler...see comment bellow or the next List with List<Number>
		List<Integer> list4 = (List<Integer>) BoundedGenericsDemo.addNumbers(); //ok, cast is necessary
		/*
		 * Sometimes, when we compile our Java source files, we see â€œunchecked castâ€? warning messages printed by the Java compiler.
		 * In this tutorial, we're going to take a closer look at the warning message. We'll discuss what this warning means, why we're warned, and how to solve the problem.
		 * Some Java compilers suppress unchecked warnings by default.
		 * 
		 * */
		for(Integer i: list4) {
			System.out.print(i);
		}
		System.out.println();
		
		List<Number> list5 = (List<Number>) BoundedGenericsDemo.addNumbers(); //ok, cast is necessary
		for(Number i: list5) {
			System.out.print(i);
		}
		
		System.out.println();
		
		@SuppressWarnings("unchecked")
		List<Object> list6 = (List<Object>) BoundedGenericsDemo.addNumbers(); //ok, cast is necessary
		for(Object i: list6) {
			System.out.print(i);
		}
		
		List<Double> list7 = (List<Double>) BoundedGenericsDemo.addNumbers();
		/**compile error: Cannot cast from List<capture#4-of ? super Integer> to List<Double>*/

	}
	
	//upper bound: this method accepts only arrays of class Number, meaning child and parent classes of Number (Integer, Double, Long...+Number, + Object).
	public static <T extends Number> List<T> doSomething(T[] array){
		return Arrays.stream(array).collect(Collectors.toList());
	}
	
	//upper bound another example . just return input Number...Object and Number work as well here, see examples in main
	public static <T extends Number> T doSomething2(T t) {
		return t;
	}
	
	//lower bound: this accepts only Lists with Integer and super types of it. super types are here: Number, Object. return type is the specified list during runtime
	//so comparing to upper bound, Double, Long etc are not possible here!!!!!!!!!!!!
	public static List<? super Integer> addNumbers() {
		List<? super Integer> list= new ArrayList<>();
	    for (int i = 1; i <= 10; i++) {
	        list.add(i);
	    }
	    return list;
	}

}


//upper bound: do the same with classes.
class Example<T extends Number> {
    private T num;

    void setNum(T num) { 
    	this.num = num; 
    }
    
    T getNum(){
    	return num;
    }
}
