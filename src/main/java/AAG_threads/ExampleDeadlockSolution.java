package AAG_threads;

public class ExampleDeadlockSolution {
	 public static Object Lock1 = new Object();
	 public static Object Lock2 = new Object();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadDemo1 T1 = new ThreadDemo1();
	    ThreadDemo2 T2 = new ThreadDemo2();
	    T1.start();
	    T2.start();
	    
	    /**
	     *1. now we change order of locks. both threads will lock first Lock1. 
	     *2. so thread1 is starting first and locks Lock1
	     *3. thread2 starts and waits on line 43 because Lock1 is locked by thread1
	     *4. thread1 sleeps 2000
	     *5. thread1 locks Lock2, thread2 is still waiting for unlocked Lock1. Thread1 executes synchronized(Lock2) code block. 
	     *Now the whole synchronized(Lock1) code block of thread1 is executed, meaning that Lock1 is released. 
	     *Also Lock2 is released because its in Lock1 block
	     *
	     *6. thread2 continues at line xx after Lock1 is released
	     *7. thread2 sleeps 1000
	     *8. thread2 executeds Lock2 block, which is not locked in this moment
	     *9. finish (look at output)
	     *
	     * 
	     * */

	}
	
	private static class ThreadDemo1 extends Thread { //inner class
	      public void run() {
	         synchronized (Lock1) {
	            System.out.println("Thread 1: Holding lock 1...");
	            
	            try { Thread.sleep(2000); }
	            catch (InterruptedException e) {}
	            System.out.println("Thread 1: Waiting for lock 2...");
	            
	            synchronized (Lock2) {
	               System.out.println("Thread 1: Holding lock 1 & 2...");
	            }
	            System.out.println("Thread 1 has released lock2");
	         }
	         System.out.println("Thread 1 has released lock1");
	      }
	}
	
	private static class ThreadDemo2 extends Thread { //inner class
	      public void run() {
	         synchronized (Lock1) {
	            System.out.println("Thread 2: Holding lock 1...");
	            
	            try { Thread.sleep(1000); }
	            catch (InterruptedException e) {}
	            System.out.println("Thread 2: Waiting for lock 2...");
	            
	            synchronized (Lock2) {
	               System.out.println("Thread 2: Holding lock 1 & 2...");
	            }
	            System.out.println("Thread 2 has released lock2");
	         }
	         System.out.println("Thread 2 has released lock1");
	      }
	}

}
