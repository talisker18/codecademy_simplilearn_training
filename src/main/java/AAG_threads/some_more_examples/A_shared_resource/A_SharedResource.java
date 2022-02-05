package AAG_threads.some_more_examples.A_shared_resource;

/**
 * Demo A: main thread is reading shared resource 'counter' at different places. This shows that we can not expect always the same value of 'counter'
 * at a certain place of the program, it differs. Because we do not coordinate the threads changing the shared resource
 * 
 * */

public class A_SharedResource {
	
	//this will be increased by 100 by each thread
	public static int counter = 0;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
		for(int i = 0; i<100; i++) {
			System.out.println("increased by thread: "+Thread.currentThread().getName());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			A_SharedResource.counter++;
		}
		
	}
	
}
