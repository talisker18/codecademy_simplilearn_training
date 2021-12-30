package AAG_threads.thread_examples.thread_with_lock;

public class ThreadWithLockDemo {
	private static Object LOCK = new Object();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new SomeThread("A", "1");
		t1.setName("Thread1");
		Thread t2 = new SomeThread("B", "2");
		t2.setName("Thread2");
		
		//threads will run in parallel. But first thread that reaches the synchro block will LOCK that block
		t1.start();
		t2.start();
		System.out.println("printout from main method after starting both threads");

	}
	
	//this method is called by threads. The execution should be controlled by programmer, e.g. by setting a synchronized block with LOCK Object
	static void print(String s1, String s2) throws InterruptedException {
		synchronized (LOCK) { //first thread that reaches this line: this thread will LOCK this synchro block until it has finished
			//second thread will wait here until first thread has finished
			//you can also do this block in the run method of the thread class
			
			System.out.println("LOCK obtained by: "+Thread.currentThread().getName());
			
			for(int i = 0; i<5; i++) {
				System.out.println(s1+" from "+Thread.currentThread().getName());
				Thread.sleep(1000);
			}
			
			System.out.println("LOCK released by: "+Thread.currentThread().getName());
		}
		
		
		//now do the same without LOCK
		
		//what happens: while Thread2 is obtaining the LOCK, it will print the letter B
		//while doing this, Thread1 is already in the non synchronized block, meaning that both threads are running in parallel and doing something
		//thus Thread1 starts printing his number 1
		for(int i = 0; i<5; i++) {
			System.out.println(s2+" from "+Thread.currentThread().getName()+", not in synchro block");
			Thread.sleep(1000);
		}
	}

}
