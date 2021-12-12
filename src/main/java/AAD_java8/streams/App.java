package AAD_java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get all values of the key ‘topicName’ and add to list
		List<String> allPrios = new ArrayList<String>();

		StreamOfEnumValuesDemo.stream().forEach(prio -> allPrios.add(prio.getPrio()));
		
		//print all prios
		System.out.println(allPrios);

	}

}
