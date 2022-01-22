package AAI_data_and_database.collection_framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		
		//list.add(5, "string"); //add at specific index...but to insert in index 5, we need already at least
		//5 items
		list.add("string1");
		list.add("string5");
		list.add("string2");
		list.add("string3");
		list.add("string4");
		list.add(5, "string6");
		list.add("string");
		
		int index = Collections.binarySearch(list, "string1"); //returns the first index which contains the string
		System.out.println(index);

	}

}