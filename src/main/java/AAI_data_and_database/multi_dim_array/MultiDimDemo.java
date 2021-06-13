package AAI_data_and_database.multi_dim_array;

public class MultiDimDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int iarr[][]  = new int[2][3];
		iarr[0][0] = 1; 					// Initializing elements
		iarr[0][1] = 2;
		iarr[0][2] = 3;
		iarr[1][0] = 4;
		iarr[1][1] = 5;
		iarr[1][2] = 6;
		
		System.out.println(iarr.length); //prints 2, so the legnth of first array
		System.out.println(iarr[0].length); //prints 3. this is the first row which containts 3 values / 3 columns
		System.out.println(iarr[1].length); //same, this is row nr 2
		
		for (int i = 0; i < iarr.length; i = i + 1) //this for loop chooses the row
		{
		       for(int j=0; j < iarr[i].length; j = j + 1) //this for loop chooses the column
		      {
		             System.out.print(iarr[i][j]);  
		             System.out.print(" ");
		       }
		 }
		
		

		int iarr2[][][]  = new int[2][2][2]; //3d koordinaten würfel, 2*2*2 werte können gespeichert werden
		iarr2[0][0][0]=1;
		iarr2[0][0][1]=2;
		
		iarr2[0][1][0]=3;
		iarr2[0][1][1]=4;
		
		iarr2[1][0][0]=5;
		iarr2[1][0][1]=6;
		iarr2[1][1][0]=7;
		iarr2[1][1][1]=8;
		
		int iarr3[][][][]=new int [2][2][2][2]; //hyperwürfel 4d, 2*2*2*2 werte, also 16/
		

	}

}
