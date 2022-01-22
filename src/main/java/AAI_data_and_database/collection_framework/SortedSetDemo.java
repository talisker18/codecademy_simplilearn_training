package AAI_data_and_database.collection_framework;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedSet<String> set = new TreeSet<String>(); //hashset not usable here
		
		set.add("Dog");
		set.add("Bull");
		set.add("Cow");
		set.add("Cat");
		
		for(String str: set) {
			System.out.println(str); //its sorted automatically
		}
		
		System.out.println("---------------");
		
		System.out.println(set.first());
		System.out.println(set.last());
		
		System.out.println("----------------");
		
		System.out.println(set.headSet("Cow")); //returns the strings before the given string -> prints bull, cat
		System.out.println(set.tailSet("Cow")); //same but vice versa....prints cow, dog

	}

}
