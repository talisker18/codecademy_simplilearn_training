package AAD_java8.streams.training;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class J_CollectToMap {
	
	public static void main(String[] args) throws IOException {
		Stream<String> rows = Files.lines(Paths.get("src/main/java/AAD_java8/streams/training/files/some.txt")); //put each line into the stream
		
		Map<String,Integer> map = new HashMap<String, Integer>();
		
		
		map = rows
				.map(line -> line.split(",")) //get each line from the stream and split it. the lambda function returns a String[]
				.filter(array -> array.length == 3) //filter all String[] with length = 3
				.filter(array -> Integer.parseInt(array[1]) > 15) //we have to parse because above we got String[]...only filter String[] which contain number > 15 at second place
				.collect(Collectors.toMap(
						array -> array[0], //key
						array -> Integer.parseInt(array[1]) //value
						));
		
		//print key value pairs
		System.out.println("printing with stream");
		map.entrySet().stream()
        .forEach(System.out::println);
		
		System.out.println("-----------");
		System.out.println("printing with for each");
		
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			System.out.println("key = "+entry.getKey()+", value = "+entry.getValue());
		}
		
		rows.close();
	}

}
