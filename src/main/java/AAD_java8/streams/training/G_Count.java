package AAD_java8.streams.training;

import java.util.stream.Stream;

public class G_Count {
	public static void main(String[] args) {
		int count = (int)Stream.of("Al","Ankit","Kushal","Brent","Sarika","amanda","Hans","Shivika","Saskia")
				.map(name -> name.toLowerCase()) //returns strings in lowerCase
				.filter(name -> name.startsWith("a")) //filter names that were made toLowercase
				.count();
		
		System.out.println(count);
	}

}
