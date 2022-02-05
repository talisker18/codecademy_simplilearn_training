package AAG_threads.some_more_examples.B_shared_method;

/*
 * lets use synchronized block instead of synchronized method
 * 
 * here, both threads use the same C_Runner object. The C_Runner constructor needs an instance of C_SharedMethod. This instance 'o1' is used among both threads,
 * meaning that the first threads which is calling the increaseValue() method of o1 will lock the o1 object and finish the for loop
 * 
 * */

public class C_SharedMethod {
	
	private static int counter = 0;
	
	public void increaseValue() {
		
		synchronized (this) { //here the C_SharedMethod object gets locked. In this case, the ref var o1 is pointing to 'this'. Ref var o1 is used by both threads
			
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
		C_SharedMethod o1 = new C_SharedMethod(); //this o1 is shared between t1 and t2
		
		C_Runner runner = new C_Runner(o1);
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


class C_Runner implements Runnable{
	
	C_SharedMethod o1;
	
	public C_Runner(C_SharedMethod o1) {
		this.o1 = o1;
	}

	@Override
	public void run() {
		this.o1.increaseValue();
	}
	
}