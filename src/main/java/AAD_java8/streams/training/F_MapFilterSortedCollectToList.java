package AAD_java8.streams.training;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class F_MapFilterSortedCollectToList {
	public static void main(String[] args) {
		List<String> listWithNamesFiltered = Stream.of("Al","Ankit","Kushal","Brent","Sarika","amanda","Hans","Shivika","Saskia")
				.map(name -> name.toLowerCase())
				.filter(name -> name.startsWith("a"))
				.sorted()
				.collect(Collectors.toList());
		
		for(String name: listWithNamesFiltered) {
			System.out.println(name);
		}
		System.out.println();
		
		//or
		listWithNamesFiltered.forEach(System.out::println);
	}
}
