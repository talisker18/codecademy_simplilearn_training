package AAA_core.generics_and_wildcards;

import java.util.ArrayList;

/** naming convetions!!!
 * 
 * The most commonly used type parameter names are:

    E - Element (used extensively by the Java Collections Framework)
    K - Key
    N - Number
    T - Type
    V - Value
    S,U,V etc. - 2nd, 3rd, 4th types

 * 
 * 
 * */


/**
 * sometimes we need to declare the type in a method, before returning type or before void. This happens when we use a static method
 * while we are declaring the type in class signature, like here: public class GenericClassDemo<T>
 * --> see method public static <T> void printArray(T[] array)
 * 
 * */

import java.util.List;

public class GenericClassDemo<T> {
	private T t;
	private List<T> list = new ArrayList<T>();
	
	public void setT(T t){
		this.t=t;
	}
	
	public T getT() {
		return this.t;
	}
	
	public void addToList(T t) {
		this.list.add(t);
	}
	
	public void printList(List<T> list) {
		for(T element: list) {
			System.out.println(element);
		}
	}
	
	public static <T> void printArray(T[] array) { //the T in T[] array refers to the declared type in public static <T> void printArray
		
		//since we make a declaration in class signature, public class GenericClassDemo<T>, whenever we use a T
		//in methods or in instance variables (like private T t; or public T getT() ), we are refering 
		//to that T in public class GenericClassDemo<T>
		
		//in a static method: without <T> before return type, there would be 
		//compile error "Cannot make a static reference to the non-static type T"
		//this because the type in class signature, public class GenericClassDemo<T>, is only available when
		//we create an instance of this class. So the compiler thinks we are using the same T in static method as the T in
		//class signature...and this is illegal because for static method we do not need an instance. 
		//so we have to declare the type separately in static method, to say that we are using a different <T> than the <T> in
		//class signature
		for(T element: array) {
			System.out.println(element);
		}
	}
	
	
	
	public static void main(String[] args) {
		GenericClassDemo <Integer> g1 = new GenericClassDemo<Integer>();
		g1.setT(10);
		
		GenericClassDemo <String> g2 = new GenericClassDemo<String>();
		g2.setT("hello");
	}

}
