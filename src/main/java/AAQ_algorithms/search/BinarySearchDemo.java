package AAQ_algorithms.search;

/**

* important: when calling binarySearch recursively, we have to use return keyword (return binarySearch() ) so that, when the number

* is found at midIndex in iteration N, we go the recursion backwards and have to return the int value each time until

* the value is returned to main program

*

*

*/

 

 

public class BinarySearchDemo {

 

    public static int binarySearch(int [] arr, int l, int r, int x){

 

        if(r >=1){

 

            int midIndex = (l + r) / 2; //first iteration: l = 0, r = 7, midIndex = 3.5 or 3

 

            if(arr[midIndex] == x){ //first iteration: on index 3, we have number 4

                return midIndex;

            }

 

            //element is in left array

            if(arr[midIndex] > x){ //number 3 is smaller than 4, so true

                return BinarySearchDemo.binarySearch(arr,l,midIndex,x); //first iteration: left = 0 and right 3, so deliver arr with {1,2,3,4}. here we cant use midIndex-1, because in this case we would not find the number at index. so we have to deliver the checked midIndex again

            }

 

            //number is in right array

            return BinarySearchDemo.binarySearch(arr,midIndex+1,arr.length-1,x); //midIndex = index 3, so start right array with m+1 and end it with arr.length-1 (last index)

 

        }

 

        return -1;

    }

 

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8};

        int size = arr.length; //8

        int index= BinarySearchDemo.binarySearch(arr,0,size-1,8);

        System.out.println(index);

    }

}
