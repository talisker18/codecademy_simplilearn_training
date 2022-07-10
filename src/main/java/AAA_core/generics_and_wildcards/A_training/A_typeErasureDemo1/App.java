package AAA_core.generics_and_wildcards.A_training.A_typeErasureDemo1;

public class App {
	
	public static void main(String[] args) {
		Stack s1 = new IntegerStack(5); //compiler warning if we use raw type here: 'Stack is a raw type. References to generic type Stack<E> should be parameterized'
		s1.push("hello"); //compiler warning as well. And we can push a String. When running this programm, it will throw a 'java.lang.ClassCastException'
		
		//correct way would be (comment error code above out)
		Stack<Integer> s2 = new IntegerStack(5); //no compiler warning
		s2.push("hello"); // compilation error, we need an Integer
		
		//or use IntegerStack as reference type
		IntegerStack s3 = new IntegerStack(10);
		s3.push("hello"); //compiler recognize the error because IntegerStack extends Stack<Integer> and the unbound type param 'E' of Stack.class becomes 'Integer'
		
		/**
		 * 
		 * conclusion: to avoid unchecked exceptions (runtime errors), pay attention to compiler warnings
		 * 
		 * 
		 * */
		
	}

}
