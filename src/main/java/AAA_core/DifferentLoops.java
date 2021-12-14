package AAA_core;

public class DifferentLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int counter = 0;
		
		//increment i by 2
		
		for(int i=0; i <=100; i = i+2) {
			System.out.println(i);
			counter++;
		}
		
		System.out.println("counter for increment by 2: "+counter);
		
		System.out.println("---------------------");
		
		
		//increment with multiplier
		
		counter = 0;
		
		for(int i=1; i <=100; i = i*2) {
			System.out.println(i);
			counter++;
		}
		
		System.out.println("counter for increment multiply with 2: "+counter);
		
		System.out.println("---------------------");
		
		//do while loop
		
		boolean abort = true;
		
		do {
			System.out.println("do while loop"); //this line will executed at least once. in this case, there are no iterations of the while loop
			
		}while(!abort);
		
		int i = 0;
		
		System.out.println("---------------------");
		
		
		//do while with iterations in the loop
		do {
			System.out.println("i incremented, i = "+i);
			i++;
		}while(i<10);

	}

}
