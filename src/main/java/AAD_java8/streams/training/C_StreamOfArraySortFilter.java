package AAD_java8.streams.training;

import java.util.Arrays;

public class C_StreamOfArraySortFilter {
	
	public static void main(String[] args) {
		String [] names = {"Al","Ankit","Kushal","Brent","Sarika","amanda","Hans","Shivika","Saskia"};
		
		Arrays.stream(names) //same as Stream.of
			.filter(name -> name.startsWith("S"))
			.sorted()
			.forEach(System.out::println);
	}

}
