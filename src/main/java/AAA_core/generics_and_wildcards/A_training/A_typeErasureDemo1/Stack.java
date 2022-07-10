package AAA_core.generics_and_wildcards.A_training.A_typeErasureDemo1;

public class Stack<E> {
	
	private E[] stackContent;
	private int counter = 0;
	
	public Stack(int capacity) {
		this.stackContent = (E[]) new Object[capacity]; // 'Cannot create a generic array of E' when try to create E[] directly. Use Object instead and make a cast
		//here we already see a 'Type safety: Unchecked cast'. Because compiler will replace all 'E' with 'Object'
	}
	
	public void push(E data) {
		System.out.println("push from Stack.class");
		this.stackContent[counter] = data;
		counter++;
	}
	
	public E pop() {
		System.out.println("pop from Stack.class");
		
		E current = this.stackContent[counter];
		
		if(counter == 0) {
			System.err.println("nothing to pop!");
		}else {
			System.out.println("pop from Stack.class");
			this.stackContent[counter] = null;
			counter--;
		}
		
		return current;
	}
	
	//upon compilation, the compiler replaces all 'E' with 'Object'
	
	/*
	 * 
	 * private Object[] stackContent;
	
	public Stack(int capacity) {
		this.stackContent = (Object[]) new Object[capacity]; 
	}
	
	public void push(Object data) {
		
	}
	
	public void pop() {
		
	}
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */

}
