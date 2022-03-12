package AAQ_algorithms.search;

/**

* important: when calling binarySearch recursively, we have to use return keyword (return binarySearch() ) so that, when the number

* is found at midIndex in iteration N, we go the recursion backwards and have to return the int value each time until

* the value is returned to main program

*

*

*/

 
/*
 * 
 * see also: src/main/java/AAI_data_and_database/collection_framework/java_util_list_and_subclasses/SearchDemo.java
 * 
 * */
 

public class BinarySearchDemo {

 

    public static int binarySearch(int [] arr, int left, int right, int x){

 
    	//following comments regard input of number 3 as x -> so search 3 in the int []

    	//array input is int[] arr = {1,2,3,4,5,6,7,8};
    	
        if(right >=left){ //if we search e.g. 9 which is not present in array: we will always continue search in right side array because 9 is always bigger than arr[midIndex], so arr[midIndex] > x is always false
        	//this means that left is always increasing. when last index is reached, left is 7 and right is 7 too (right was always 7). then number 9 is still not found and left is increased to 8
        	//so in next iteration, left is > right, therefore returning -1
        	
        	System.out.println("size of r: "+right);

            int midIndex = (left + right) / 2; //first iteration: l = 0, r = 7, midIndex = 3.5 or 3

 

            if(arr[midIndex] == x){ //first iteration: on index 3, we have number 4

                return midIndex;

            }

 

            //if true: element is in left array

            if(arr[midIndex] > x){ //number 3 = x is smaller than arr[midIndex] = 4, so true

                return BinarySearchDemo.binarySearch(arr,left,midIndex,x); //first iteration: left = 0 and right 3, so deliver arr with {1,2,3,4}. here we cant use midIndex-1, because in this case we would not find the number at index 0. so we have to deliver the checked midIndex again

            }

 

            //number is in right array

            return BinarySearchDemo.binarySearch(arr,midIndex+1,arr.length-1,x); //midIndex = index 3, so start right array with midIndex+1 and end it with arr.length-1 (last index) -> so in 1st iteration its midIndex+1 = 4

 

        }

 

        //number not found
        return -1;

    }

 

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8};

        int size = arr.length; //8

        int index= BinarySearchDemo.binarySearch(arr,0,size-1,9);

        System.out.println(index);

    }

}
