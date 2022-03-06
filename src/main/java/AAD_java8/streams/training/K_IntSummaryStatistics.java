package AAD_java8.streams.training;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class K_IntSummaryStatistics {
	
	public static void main(String[] args) {
		IntSummaryStatistics summary = IntStream.of(7,2,19,88,73,4,10) //only works for int
				.summaryStatistics();
		
		System.out.println(summary);
	}

}
