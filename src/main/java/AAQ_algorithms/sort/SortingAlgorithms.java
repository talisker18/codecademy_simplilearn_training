package AAQ_algorithms.sort;

public class SortingAlgorithms {

	public static void main(String[] args) {
		
		//worst sorting algo: bubble sort (compare neighbours and switch if necessary)
		
		//a bad case woud be: [50,40,30,20,10]
		//1st swap -> swap index 0 and 1 -> 40,50
		//2nd -> check 50 and 30 -> swap -> 30,50
		//and so on
		
		//after first iteration: [40,30,20,10,50]
		
		//and so on...many iterations are necessary!
		
		int array[] = {50,40,30,20,10};
		
		int n = array.length;
		
		for(int i = 0; i<n-1;i++) {
			for(int j = 0; j<n-i-1;j++) {
				if(array[j]>array[j+1]) {
					//swap
					int x = array[j];
					array[j] = array[j+1];
					array[j+1] = x;
				}
			}
		}
		
		
		//insertion sort
		//we have 5 cards in that order: 9,6,5,0,7
		
		//take 1st card = 9 in hand
		//take 2nd card = 6 in hand and check: is there a card higher than 6? -> yes, swap -> 6,9
		//take 3rd card = 5 -> check 1st index = value 6 -> its bigger, so swap -> 5,9,6
		//4rth card = 0 -> check with 1st index -> swap -> 0,9,6,5
		
		//and so on...also multiple iterations necessary
		
		n = array.length;
		
		for(int i = 1; i<n;i++) {
			
			int x = array[i];
			int j = i-1;
			
			while(j>=0 && array[j]>x) {
				array[j+1] = array[j];
				j = j-1;
			}
			array[j+1] = x;
		}

	}

}
