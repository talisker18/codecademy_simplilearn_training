package AAG_threads.some_more_examples.B_shared_method;

/*
 * lets use a locking Object instead of locked D_SharedMethod instance
 * 
 * actually there is no difference between D_SharedMethod and C_SharedMethod
 * 
 * --->using Locks like this, in an environment with many threads, some threads can 'starve', meaning that
 * not all threads are treated fair
 * --->synchronized blocks with Lock objects make no guarantees about what thread is being granted access if more thread is waiting to enter.
 * meaning that it could happen than second thread started waits longer than 4th or 5th thread to enter the synchro block (= starvation)
 * 
 * */

public class D_SharedMethod {
	
	private static int counter = 0;
	private final static Object LOCK = new Object();
	
	static void increaseValue() {
		
		synchronized (LOCK) { //instead of locking an object of D_SharedMethod, we use Object class
			
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
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		D_Runner runner = new D_Runner();
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


class D_Runner implements Runnable{

	@Override
	public void run() {
		D_SharedMethod.increaseValue();
	}
	
}