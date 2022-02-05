package AAI_data_and_database.collection_framework.java_util_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortinDemoCollection {

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
		
		//unsorted
		
		for(String ob: list) {
			System.out.println(ob.toString());
		}
		
		System.out.println("---------------------");
		
		//now do a sorting. For this use the CLASS Collections (not interface Collection)
		//this class is used e.g. to sort childs of Collection interface
		Collections.sort(list);
		
		for(String ob: list) {
			System.out.println(ob.toString());
		}

	}

}
