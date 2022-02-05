package AAG_threads.some_more_examples.B_shared_method;

/*
 * lets use synchronized method and look at the result
 * 
 * first thread entering the method increaseValue() will lock the method and finish the loop
 * 
 * ---> instead of synchronizing the whole method we just can synchronize the for loop
 * 
 * 
 * --> see next demo
 * 
 * */

public class B_SharedMethod {
	
	private static int counter = 0;
	
	synchronized public static void increaseValue() {
		
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
		B_Runner runner = new B_Runner();
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


class B_Runner implements Runnable{

	@Override
	public void run() {
		B_SharedMethod.increaseValue();
	}
	
}