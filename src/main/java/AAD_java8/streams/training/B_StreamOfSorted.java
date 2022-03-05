package AAD_java8.streams.training;

import java.util.stream.Stream;

public class B_StreamOfSorted {
	
	public static void main(String[] args) {
		Stream.of("Ava","Aneri","Alberto")
			.sorted()
			.findFirst()
			.ifPresent(System.out::println);
		
	}

}
