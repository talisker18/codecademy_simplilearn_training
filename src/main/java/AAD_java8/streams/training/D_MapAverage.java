package AAD_java8.streams.training;

import java.util.Arrays;

public class D_MapAverage {
	public static void main(String[] args) {
		Arrays.stream(new int[] {2,4,6,8,10})
			.map(number -> number*number) //do an operation for every number. this function returns a new stream, containing the squares of each number, so 4,16,36 etc
			.average()
			.ifPresent(System.out::println);
	}
}
