package AAD_java8.streams.training;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class I_StreamReadLinesFromFileMultipleFilter {
	public static void main(String[] args) throws IOException {
		Stream<String> rows = Files.lines(Paths.get("src/main/java/AAD_java8/streams/training/files/some.txt")); //put each line into the stream
		
		rows
				.map(line -> line.split(",")) //get each line from the stream and split it. the lambda function returns a String[]
				.filter(array -> array.length == 3) //filter all String[] with length = 3
				.filter(array -> Integer.parseInt(array[1]) > 15) //we have to parse because above we got String[]...only filter String[] which contain number > 15 at second place
				.forEach(array -> System.out.println(array[0])); //only print the letters of the rows which are filtered
		
		rows.close();
	}

}
