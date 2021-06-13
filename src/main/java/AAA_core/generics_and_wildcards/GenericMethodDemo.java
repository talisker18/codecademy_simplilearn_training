package AAA_core.generics_and_wildcards;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class GenericMethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strArray = {"1","2"};
		List<String> strList = GenericMethodDemo.fromArrayToList(strArray);
		System.out.println(strList);
		
		Integer[] intArray = {1,2}; //int does not work. probably generic type T does not work with primitive data types. Use its wrapper classes!!
		List<Integer> intList = GenericMethodDemo.fromArrayToList(intArray);
		System.out.println(intList);
		
		System.out.println();
		
		//use void method to print directly
		GenericMethodDemo.printArray(strArray);
		GenericMethodDemo.printArray(intArray);
		
	}
	
	//converts an array to List. Use of generic type (T)
	public static <T> List<T> fromArrayToList(T[] a) {   //the first <T> in the method signature implies that the method will be dealing with generic type T. This is needed even if the method is returning void.
		
	    return Arrays.stream(a).collect(Collectors.toList());
	}
	
	//example with void method
	public static <T> void printArray(T[] a) { //the <T> is also needed, even it is void method. It implies that we will use generic type in this method
		for(T element:a) {
			System.out.println(element);
		}
	}
	
	
	/**
	 *  the method can deal with more than one generic type, where this is the case, all generic types must be added to the method signature, 
	 *  for example, if we want to modify the above method to deal with type T and type G, it should be written like this:
	 * 
	 * */
	
	
	/*
	 * We're passing a function that converts an array with the elements of type T to list with elements of type G. 
	 * An example would be to convert Integer to its String representation:
	 * 
	 * */
	public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
	    return Arrays.stream(a)
	      .map(mapperFunction)
	      .collect(Collectors.toList());
	}
	
	@Test
	public void givenArrayOfIntegers_thanListOfStringReturnedOK() {
	    Integer[] intArray = {1, 2, 3, 4, 5};
	    List<String> stringList
	      = GenericMethodDemo.fromArrayToList(intArray, Object::toString);
	 
	    assertThat(stringList, hasItems("1", "2", "3", "4", "5")); //hasItems is of hamcrest API
	}

}
