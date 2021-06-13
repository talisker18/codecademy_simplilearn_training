package AAG_threads;

public class ExampleDeadlockForever {
	 public static Object Lock1 = new Object();
	 public static Object Lock2 = new Object();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadDemo1 T1 = new ThreadDemo1();
	    ThreadDemo2 T2 = new ThreadDemo2();
	    T1.start();
	    T2.start();
	    
	    /**
	     * here we have an infinite deadlock because
	     * both threads are started at same time and
	     * 1. thread 1 has lock1
	     * 2. thread 2 has lock2
	     * 
	     * 3. thread2 sleep of 10 ends
	     * 4. thread2 tries to execute synchronized (Lock1), but this is still locked by thread1
	     * 5. so thread2 is waiting until lock1 is released by thread1
	     * 
	     * 6. thread1 sleep of 20 ends
	     * 7. thread1 tries to execute synchronized (Lock2), but this is still locked by thread2
	     *  -->it is still locked by thread2 because synchronized(Lock2) block has not finished yet
	     *  -->in thread2. it stays at line 58, waiting thread1 to release Lock1
	     * 8. same on thread1: thread1 stays at line 43 until thread2 releases Lock2
	     * 
	     * 
	     * ---------------solution for this deadLock: change order of the locks, see another example
	     * 
	     * */

	}
	
	private static class ThreadDemo1 extends Thread { //inner class
	      public void run() {
	         synchronized (Lock1) {
	            System.out.println("Thread 1: Holding lock 1...");
	            
	            try { Thread.sleep(20); }
	            catch (InterruptedException e) {}
	            System.out.println("Thread 1: Waiting for lock 2...");
	            
	            synchronized (Lock2) {
	               System.out.println("Thread 1: Holding lock 1 & 2...");
	            }
	         }
	      }
	}
	
	private static class ThreadDemo2 extends Thread { //inner class
	      public void run() {
	         synchronized (Lock2) {
	            System.out.println("Thread 2: Holding lock 2...");
	            
	            try { Thread.sleep(10); }
	            catch (InterruptedException e) {}
	            System.out.println("Thread 2: Waiting for lock 1...");
	            
	            synchronized (Lock1) {
	               System.out.println("Thread 2: Holding lock 1 & 2...");
	            }
	         }
	      }
	}

}
