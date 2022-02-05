package AAI_data_and_database.array;

import java.util.Arrays;

public class ConvertArrayToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3};
		
		System.out.println(arr); //prints memory address
		
		//we could print the values with a loop...but we can also use Arrays class from java.util package
		String toPrint = Arrays.toString(arr);
		System.out.println(toPrint);

	}

}
