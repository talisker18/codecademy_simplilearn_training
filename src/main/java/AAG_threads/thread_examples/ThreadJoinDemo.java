package AAG_threads.thread_examples;

public class ThreadJoinDemo implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadJoinDemo d1 = new ThreadJoinDemo();
		Thread t1 = new Thread(d1);
		t1.setName("T1");
		t1.start();
		try {
			t1.join(); //go further in main thread when t1 has finished. t1 uses/blocks all cpu cores
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Thread t2 = new Thread(d1);
		t2.setName("T2");
		t2.start(); //it will start when T1 has finished because of the t1.join()
		
		//we can do join on multiple threads
		Thread t3 = new Thread(d1);
		t3.setName("T3");
		t3.start();
		
		Thread t4 = new Thread(d1);
		t4.setName("T4");
		t4.start();
		
		try {
			t3.join();
			
			t4.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Thread t5 = new Thread(d1);
		t5.setName("T5");
		t5.start();
		try {
			t5.join(3000); //t5 sleeps 10 seconds. but after 3sec, t6 will start
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Thread t6 = new Thread(d1);
		t6.setName("T6");
		t6.start(); //so T6 will start appr. 3 seconds after T5 because join of T5 was 3 seconds long
		
		

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread started: "+Thread.currentThread().getName());
		System.out.println("thread will sleep for 10 sec: "+Thread.currentThread().getName());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
