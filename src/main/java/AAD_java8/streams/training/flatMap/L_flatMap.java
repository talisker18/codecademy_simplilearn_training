package AAD_java8.streams.training.flatMap;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * In Java 8, we can use the flatMap to convert a 2 levels Stream into one Stream level or a 2d array into a 1d array.
 * 
 * why use flat?
 * 
 * It’s challenging to process a Stream containing more than one level, 
 * like Stream<String[]> or Stream<List<LineItem>> or Stream<Stream<String>>. 
 * 
 * And we flat the 2 levels Stream into one level, like Stream<String> or Stream<LineItem>, 
 * so that we can easily loop the Stream and process it.
 * 
 * */

public class L_flatMap {
	
	public static void main(String[] args) {
		String[][] arr = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

	  // array to a stream
	  Stream<String[]> stream1 = Arrays.stream(arr);

	  // same result
	  Stream<String[]> stream2 = Stream.of(arr);
	  
	  List<String[]> result = stream1
		      .filter(x -> !x.equals("a"))      // x is a String[], not String!
		      .collect(Collectors.toList());

	  System.out.println(result.size());    // 0

	  result.forEach(System.out::println);  // prints objects of List<String[]> instead of a List with strings != to "a"
	  
	  System.out.println("------------------");
	  
	  //so we have to use flat map...or first the ugly way!
	  stream1 = Arrays.stream(arr);
	  result = stream1
	          .filter(array -> { //filter uses Predicate, so it returns a boolean
	              for(String s : array){      // really?
	                  if(s.equals("a")){
	                      return false;
	                  }
	              }
	              return true;
	          }).collect(Collectors.toList());

	  // print array
	  result.forEach(array -> System.out.println(Arrays.toString(array)));
	  
	  System.out.println("--------------------");
	  
	  //now using flatMap
	  List<String> resultFlat = Stream.of(arr)     // Stream<String[]>
	          .flatMap(Stream::of)                // make Stream of each single array, collect them and return single Stream of: Stream<String>   
	          //lambda style would look like follows
	          //.flatMap(array -> Stream.of(array))
	          .filter(x -> !"a".equals(x))        // filter out the a
	          .collect(Collectors.toList());      // return a List

	  resultFlat.forEach(System.out::println);
	  
	  /**
	   * 
	   * another example using List
	   * 
	   * */
	  System.out.println("--------------------");
	  List<List<String>> multiList = Arrays.asList(
			  Arrays.asList("abc"),
			  Arrays.asList("bcd"),
			  Arrays.asList("cde")
			  );
	  
	  Stream<List<String>> stream = multiList.stream(); //convert (outer) List to Stream
	  
	  resultFlat = stream
	          .flatMap(Collection::stream) // make Stream of each single List<String>, collect them and return single Stream of: Stream<String>   
	          //lambda style would look like follows
	          //.flatMap(list -> list.stream())
	          .collect(Collectors.toList());      // return a List

	  resultFlat.forEach(System.out::println);
	  
	  /**
	   * 
	   * another example using Set
	   * 
	   * */
	  System.out.println("--------------------");
	  Set<String> set1 = new HashSet<String>();
	  set1.add("str1 set1");
	  set1.add("str2 set1");
	  set1.add("str3 set1");
	  
	  Set<String> set2 = new HashSet<String>();
	  set1.add("str1 set2");
	  set1.add("str2 set2");
	  set1.add("str3 set2");
	  
	  Set<String> set3 = new HashSet<String>();
	  set1.add("str1 set3");
	  set1.add("str2 set3");
	  set1.add("str3 set3");
	  
	  Set<Set<String>> multiSet = new HashSet<Set<String>>();
	  multiSet.add(set1);
	  multiSet.add(set2);
	  multiSet.add(set3);
	  
	  Stream<Set<String>> streamOfSets = multiSet.stream(); //convert (outer) List to Stream
	  
	  Set<String> resultFlatSet = streamOfSets
	          .flatMap(Collection::stream) // make Stream of each single Set<String>, collect them and return single Stream of: Stream<String>   
	          //lambda style would look like follows
	          //.flatMap(set -> set.stream())
	          .collect(Collectors.toSet());      // return a Set<String>

	  resultFlatSet.forEach(System.out::println);
	}
}
