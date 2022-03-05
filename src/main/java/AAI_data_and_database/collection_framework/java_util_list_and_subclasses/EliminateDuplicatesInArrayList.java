package AAI_data_and_database.collection_framework.java_util_list_and_subclasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EliminateDuplicatesInArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> listWithDuplicates = Arrays.asList("1","2","1","2");
		
		List<String> listWithoutDuplicates = new ArrayList<String>(new HashSet<String>(listWithDuplicates));
		
		System.out.println(listWithoutDuplicates);
		
		Map<String,String> map = new ConcurrentHashMap<String,String>();

	}

}
