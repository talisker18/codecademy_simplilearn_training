package AAQ_algorithms.sort;

import ZAB_apps.file_app.helper.SortingHelper;

/*
 * demo of merge sort. there are sort and merge methods for int [] and String []
 * 
 * see also Example with own Comparators: package ZAB_apps.file_app;
 * 
 * */

public class MergeSortDemo {
	
	int [] arr;
	String [] arrStr;
	
	//after the array is initialized by invoking the constructor, the sort method sorts this array when method is called by the instance
	public MergeSortDemo(int [] arr) {
		this.arr = arr;
	}
	
	public MergeSortDemo(String [] arrStr) {
		this.arrStr = arrStr;
	}
	
	void mergeInt(int l, int m, int r){
        
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) {
        	L[i] = this.arr[l + i];
        }
           
        for (int j=0; j<n2; ++j) {
        	R[j] = this.arr[m + 1+ j];
        }

        int i = 0, j = 0;

        int k = l;
        
        while (i < n1 && j < n2){
        	
            if (L[i] <= R[j]){
            	this.arr[k] = L[i];
                i++;
            }else{
            	this.arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while (i < n1){
        	this.arr[k] = L[i];
            i++;
            k++;
        }

        
        while (j < n2){
        	this.arr[k] = R[j];
            j++;
            k++;
        }
    }
	
	void mergeStrings(int l, int m, int r){
        
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        String L[] = new String [n1];
        String R[] = new String [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) {
        	L[i] = this.arrStr[l + i];
        }
           
        for (int j=0; j<n2; ++j) {
        	R[j] = this.arrStr[m + 1+ j];
        }

        int i = 0, j = 0;

        int k = l;
        
        while (i < n1 && j < n2){
        	
            if (L[i].compareTo(R[j]) <= R[j].compareTo(L[i])){
            	this.arrStr[k] = L[i];
                i++;
            }else{
            	this.arrStr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while (i < n1){
        	this.arrStr[k] = L[i];
            i++;
            k++;
        }

        
        while (j < n2){
        	this.arrStr[k] = R[j];
            j++;
            k++;
        }
    }
	
    void sortInt(int l, int r){
        if (l < r){
            
            int m = (l+r)/2;

            sortInt(l, m);
            
            sortInt(m+1, r);
            
            System.out.println("merge: l = "+l+", mid = "+m+", right = "+r);

            mergeInt(l, m, r);
        }
    }
    
    void sortStr(int l, int r){
        if (l < r){
            
            int m = (l+r)/2;

            sortStr(l, m);
            
            sortStr(m+1, r);
            
            System.out.println("merge: l = "+l+", mid = "+m+", right = "+r);

            mergeStrings(l, m, r);
        }
    }

    void printArray(){
        	
	        int n = this.arr.length;
	        for (int i=0; i<n; ++i) {
	        	System.out.print(this.arr[i] + " ");
	        }

	        System.out.println();
    }
    
    void printArrayStr(){
    	
        int n = this.arrStr.length;
        for (int i=0; i<n; ++i) {
        	System.out.print(this.arrStr[i] + " ");
        }

        System.out.println();
    }
    
    void setArray(int [] arr) {
    	this.arr = arr;
    }

	
	public static void main(String[] args) {
		int [] arr = {5,77,23,5,1};
		MergeSortDemo helper = new MergeSortDemo(arr);
		helper.printArray();
		helper.sortInt(0, arr.length-1);
		helper.printArray();
		
		String [] strArr = {"hello", "aa", "bu", "za", "fo", "aaa"};
		
		MergeSortDemo helper2 = new MergeSortDemo(strArr);
		helper2.printArrayStr();
		helper2.sortStr(0, strArr.length-1);
		helper2.printArrayStr();
	}

}
