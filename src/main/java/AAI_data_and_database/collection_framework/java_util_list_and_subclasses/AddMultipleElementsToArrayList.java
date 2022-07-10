package AAI_data_and_database.collection_framework.java_util_list_and_subclasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddMultipleElementsToArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("hello","good morning");
		
		System.out.println(list);
		
		//or
		List<String> list2 = new ArrayList<>();
		Collections.addAll(list2, "hello","good morning");

	}

}
