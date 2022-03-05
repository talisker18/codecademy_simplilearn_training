package AAD_java8.streams.training;

import java.util.stream.IntStream;

public class A_IntegerStream {
	public static void main(String[] args) {
		
		//1. example
		IntStream
			.range(1, 10) 
			.forEach(System.out::print); //print 1 - 9
		System.out.println();
		
		//2. example
		IntStream
		.range(1, 10) 
		.skip(5) //skip the first 5 numbers
		.forEach(number -> System.out.print(number)); //print 6 - 9. instead of method ref, we use lambda here
		System.out.println();
	
		//3. example
		int sum = IntStream
				.range(1, 5) //1+2+3+4
				.sum();
		System.out.println(sum);
		
		//3.2 example using stream.reduce()
		//
		sum = IntStream
				.range(1, 5)
				.reduce(0,Integer::sum); //In this case, the Integer value 0 is the identity. It stores the initial value of the reduction operation and also the default result when the stream of Integer values is empty.
		System.out.println(sum);
	}

}
