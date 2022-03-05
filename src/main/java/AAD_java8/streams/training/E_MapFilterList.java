package AAD_java8.streams.training;

import java.util.Arrays;
import java.util.List;

public class E_MapFilterList {
	public static void main(String[] args) {
		List<String> people = Arrays.asList("Al","Ankit","Kushal","Brent","Sarika","amanda","Hans","Shivika","Saskia");
		
		people
			.stream()
			//.map(name -> name.toLowerCase()) -> same as next line but in lambda
			.map(String::toLowerCase)
			.filter(name -> name.startsWith("a"))
			.forEach(System.out::println);
		
		System.out.println();
		//print a list without for loop
		people.forEach(System.out::println);
	}

}
