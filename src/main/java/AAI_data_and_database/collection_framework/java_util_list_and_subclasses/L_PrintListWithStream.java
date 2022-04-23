package AAI_data_and_database.collection_framework.java_util_list_and_subclasses;

import java.util.Arrays;
import java.util.List;

public class L_PrintListWithStream {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList(new String[] {"1","2"});
		
		list.forEach(System.out::println);
	}

}
