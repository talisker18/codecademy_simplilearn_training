package AAQ_algorithms.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class SearchingAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double temp[] = {-19.0, 45.5, 23.0, 55.0, -17.0, -17.34};
		String city [] = {"A","B", "C", "D", "E", "F"};
		
		double benchmark = 20.0;
		
		SortedSet<String> set = new TreeSet<String>();
		
		//linear search...visit every element
		for(int i =0; i<temp.length;i++) {
			if(temp[i] < benchmark) {
				set.add(city[i]);
			}
		}
		
		for(String str: set) {
			System.out.println(str);
		}
		
		System.out.println("------------");
		
		/**binary search (divide and conquer)*/
		
		//e.g. we have an array with 6 indices. low = 0, high = 6. binary search
		//uses mid = 3 to start the search. for this, the array has to be sorted first
		
		//then in part 1 of array, low = 0 and high = 2
		//in part 2 of array, low = 4 and high = 6
		
		//check first if index 3 is the element? when no: is value of index 3 higher or lower?
		//-> if lower: continue in array part 1. if higher, continue in array part 2
		
		//-> check in both of mid (index 1 or index) = searched element
		
		//so its good to use TreeSet or TreeMap to use with binary search because its
		//sorted automatically
		
		//binary search is half of the time of linear search
		
		//search the temp
		//first to sorting
		Double[] tempWrapped = new Double[temp.length];
		
		for(int i = 0; i<temp.length;i++) {
			tempWrapped[i] = temp[i];
		}
		
		List<Double> listWithAllTemp = Arrays.asList(tempWrapped);
		
		Collections.sort(listWithAllTemp);
		
		System.out.println(listWithAllTemp);
		
		double searchedTemp = 55.0;
		
		int low = 0;
		int high = listWithAllTemp.size()-1; //last index
		
		int counterOfIterations = 0;
		
		while(low <= high) {
			
			counterOfIterations++;
			
			int mid = (low+high)/2;
			
			if(listWithAllTemp.get(mid) < searchedTemp) { //if searchedTemp is greater, search in right part of array
				low = mid+1;
			}else if(listWithAllTemp.get(mid) == searchedTemp) {
				System.out.println("found");
				break;
			}else {
				high = mid -1; //search in left part of array
			}
		}
		
		if(low>high) {
			System.out.println("not found");
		}
		
		System.out.println("number of iterations = "+counterOfIterations);
		
		
		//exponential search -> 2^n
		//if we have 10 elements, it takes 2^10 
		
		
		double temp2 [] = {10.0, 12.0, 13.0, 14.0, 21.0, 25.0, 30.0, 35.0,50,60,67,69,70,75};
		
		benchmark = 21.0;
		
		int i = 1;
		while(i<temp2.length-1 && temp2[i]<=benchmark) {
			//first iteration check index 1
			
			i=i*2; //second iteration check index 2; 3 iteration check index 2*2, then 4*2
			//--> we skipping a lot of indices to gain time because each time we check temp2[i]<=benchmark

			//next step: to do a usefull expo search, combine it with binary search and then it can be useful for really
			//big arrays
			
			if(temp2[i] == benchmark) {
				System.out.println("found");
				break;
			}
		}
		
		//...as mentioned, combine it now with binary search
		//now we have an index of i, thats our new starting point because the while loop breaked...e.g. its 8 (power of 2)
		
		
		
		//in the last search, the loop breaked when i = 16. so we have to divide it with 2 to get the correct starting point
		//(because 16 is out of bound)
		
		//so search with binary search from a specific index to another specific index
		//pick the smaller of i vs temp2.length-1 to get the toIndex value, meaning: 16 vs lenght of array = 14
		Arrays.binarySearch(temp2, i/2, Math.min(i, temp2.length-1), benchmark);
		
	}

}
