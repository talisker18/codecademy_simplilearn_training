package AAG_threads.some_more_examples.B_shared_method;

/*
 * in AAG_threads.some_more_examples.A_shared_resource we saw how we can make a join on a thread to wait until he dies.
 * 
 * but if we cant control threads directly by join(), we need another solution
 * 
 * with this demo we show again that the method calls of increaseValue() is not coordinated, the 2 threads are calling 'in parallel'
 * 
 * --->but what if we want that the first thread calling increaseValue() will lock the method until the for loop has finished? Next thread will enter the loop when first thread has left the method
 * 
 * ---> see next demo class
 * */

public class A_SharedMethod {
	
	private static int counter = 0;
	
	public static void increaseValue() {
		
		for(int i = 0; i<100;i++) {
			counter++;
			System.out.println("method called by: "+Thread.currentThread().getName());
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		A_Runner runner = new A_Runner();
		Thread t1 = new Thread(runner);
		t1.setName("thread 1");
		t1.start();
		
		Thread t2 = new Thread(runner);
		t2.setName("thread 2");
		t2.start();
		
		System.out.println(counter); 
		
		Thread.sleep(1000);
		
		System.out.println(counter); 
		
		Thread.sleep(1000);
		
		System.out.println(counter);
		
		Thread.sleep(1000);
		
		System.out.println(counter);
		
		Thread.sleep(1000);
		
		System.out.println(counter);
		
		Thread.sleep(1000);
		
		System.out.println(counter);
		
		Thread.sleep(1000);
		
		System.out.println(counter);
		
		Thread.sleep(1000);
		
		System.out.println(counter);
	}

}


class A_Runner implements Runnable{

	@Override
	public void run() {
		A_SharedMethod.increaseValue();
	}
	
}