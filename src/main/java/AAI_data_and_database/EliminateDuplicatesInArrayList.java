package AAI_data_and_database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class EliminateDuplicatesInArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> listWithDuplicates = Arrays.asList("1","2","1","2");
		
		List<String> listWithoutDuplicates = new ArrayList<String>(new HashSet<String>(listWithDuplicates));
		
		System.out.println(listWithoutDuplicates);

	}

}
