package AAG_threads.thread_examples;

public class WaitDemo implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaitDemo w1 = new WaitDemo();
		Thread t1 = new Thread(w1);
		t1.start();
		
		WaitDemo w2 = new WaitDemo();
		Thread t2= new Thread(w2);
		t2.start();
		try {
			t2.sleep(5000); //here, the main thread will sleep for 5000 seconds
			//still because we calling the sleep method from main thread / inside main method
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WaitDemo w3 = new WaitDemo();
		Thread t3= new Thread(w3);
		t3.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread started: "+Thread.currentThread().getName());
		System.out.println("thread "+Thread.currentThread().getName()+" will wait for 2 sec");
		//let the thread sleep after starting
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("thread "+Thread.currentThread().getName()+" finished with wait");
		
	}

}
