package AAI_data_and_database.collection_framework;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//in sets, duplicate values are not possible
		//hashset uses functionality of linkedlist
		Set<String> set = new HashSet<String>();
		
		set.add("string1");
		set.add("string1");
		set.add("string2");
		
		for(String s: set) {
			System.out.println(s);
		}
		
		//set does not use index and cannot be sorted
		//Collections.sort(set);

	}

}
