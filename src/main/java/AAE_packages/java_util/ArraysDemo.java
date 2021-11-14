package AAE_packages.java_util;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2,3};
		
		System.out.println(arr); //prints memory address
		
		//we could print the values with a loop...but we can also use Arrays class from java.util package
		String toPrint = Arrays.toString(arr);
		System.out.println(toPrint);
		
		//with Arrays we can also create a List object from an [ ]. use the asList(T... a) method
		Integer[] arr2 = {1,2,3}; //here we have to use wrapper class Integer
		
		List<Integer> list = Arrays.asList(arr2);
		
		for(Integer i: list) {
			System.out.println(i.intValue());
		}

	}

}
