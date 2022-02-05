package AAI_data_and_database.array;

import java.util.Arrays;
import java.util.List;

public class ConvertArrayToList {

	public static void main(String[] args) {
		//with Arrays we can also create a List object from an [ ]. use the asList(T... a) method
				Integer[] arr2 = {1,2,3}; //here we have to use wrapper class Integer
				
				List<Integer> list = Arrays.asList(arr2);
				
				for(Integer i: list) {
					System.out.println(i.intValue());
				}

	}

}
