package AAG_threads.some_more_examples.A_shared_resource;

/*
 * Demo B: in this Demo we wait until t1 finished, and then we wait again until t2 finished. we do this with join() method
 * 
 * */

public class B_SharedResource {
	//this will be increased by 100 by each thread
	public static int counter = 0;
	
	public static void main(String[] args) {
		B_Runner runner = new B_Runner();
		Thread t1 = new Thread(runner);
		t1.setName("thread 1");
		t1.start();
		
		Thread t2 = new Thread(runner);
		t2.setName("thread 2");
		
		try {
			t1.join();
			System.out.println("counter: "+counter+"; should be 100");
			t2.start(); //start second thread
			t2.join();
			System.out.println("counter: "+counter+"; should be 200");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


class B_Runner implements Runnable{

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
			B_SharedResource.counter++;
		}
		
	}
	
}