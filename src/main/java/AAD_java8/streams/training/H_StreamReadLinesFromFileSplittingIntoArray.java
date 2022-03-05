package AAD_java8.streams.training;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class H_StreamReadLinesFromFileSplittingIntoArray {
	
	public static void main(String[] args) throws IOException {
		Stream<String> rows = Files.lines(Paths.get("src/main/java/AAD_java8/streams/training/files/some.txt")); //put each line into the stream
		
		int rowCount = (int) rows
				.map(line -> line.split(",")) //get each line from the stream and split it. the lambda function returns a String[]
				.filter(array -> array.length == 3) //filter all String[] with length = 3
				.count();
		
		System.out.println(rowCount);
		
		rows.close();
	}

}
