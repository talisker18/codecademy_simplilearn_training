package AAG_threads.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * 
 * The Java ExecutorService interface, java.util.concurrent.ExecutorService, represents an asynchronous execution mechanism which is 
 * capable of executing tasks concurrently in the background. In this Java ExecutorService tutorial I will explain how to create a 
 * ExecutorService, how to submit tasks for execution to it, how to see the results of those tasks, and how to shut down the 
 * ExecutorService again when you need to. 
 * 
 * 
 * ---> see important comment of ex.shutdown();
 * 
 * */

public class A_DemoFixedThreadPoolSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService ex = Executors.newFixedThreadPool(10); //First an ExecutorService is created using the Executors newFixedThreadPool() factory method. This creates a thread pool with 10 threads executing tasks.
		
		//execute method is called 3 times. each time, a thread from the pool delegates the task doing System.out.println("thread "+Thread.currentThread().getName()+" executing task");
		//and these 3 tasks are done in parallel, since 3 threads are started in parallel
		
		ex.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("thread "+Thread.currentThread().getName()+" executing task from Runnable");
				try {
					System.out.println("start of sleep, "+Thread.currentThread().getName());
					Thread.sleep(5000);
					System.out.println("end of sleep, "+Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("sleep of "+Thread.currentThread().getName()+" was interrupted");
					e.printStackTrace();
				}
				
			}
			
		});
		
		ex.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("thread "+Thread.currentThread().getName()+" executing task from Runnable");
				try {
					System.out.println("start of sleep, "+Thread.currentThread().getName());
					Thread.sleep(5000);
					System.out.println("end of sleep, "+Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("sleep of "+Thread.currentThread().getName()+" was interrupted");
					e.printStackTrace();
				}
				
			}
			
		});
		
		ex.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("thread "+Thread.currentThread().getName()+" executing task from Runnable");
				try {
					System.out.println("start of sleep, "+Thread.currentThread().getName());
					Thread.sleep(8000);
					System.out.println("end of sleep, "+Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("sleep of "+Thread.currentThread().getName()+" was interrupted");
					e.printStackTrace();
				}
				
			}
			
		});
		
		/*
		 * When you are done using the Java ExecutorService you should shut it down, so the threads do not keep running. 
		 * If your application is started via a main() method and your main thread exits your application, the application 
		 * will keep running if you have an active ExexutorService in your application. The active threads inside this ExecutorService 
		 * prevents the JVM from shutting down. 
		 * 
		 * */
		
		
		/*
		 * To terminate the threads inside the ExecutorService you call its shutdown() method. The ExecutorService will not shut down immediately, 
		 * but it will no longer accept new tasks, and once all threads have finished current tasks, the ExecutorService shuts down. 
		 * All tasks submitted to the ExecutorService before shutdown() is called, are executed
		 * 
		 * 
		 * */
		//ex.shutdown();
		
		/*
		 * If you want to shut down the ExecutorService immediately, you can call the shutdownNow() method. This will attempt to stop 
		 * all executing tasks right away, and skips all submitted but non-processed tasks. 
		 * 
		 * There are no guarantees given about the executing tasks. Perhaps they stop, perhaps the execute until the end. It is a best effort attempt
		 * 
		 * 
		 * 
		 * */
		//ex.shutdownNow();
		
		
		/*
		 * -->comment by me: so better use here shutDown() so that the 3. thread will finish his task also because the sleep is 8 seconds there
		 * by using shutDOwnNow() it could happen that the 3. thread and his task will be aborted
		 * 
		 * -> use it in combination with awaitTermination
		 * 
		 * 
		 * */
		
		try {
			/*
			 * The ExecutorService awaitTermination() method will block the thread calling it until either the ExecutorService has shutdown completely, 
			 * or until a given time out occurs. The awaitTermination() method is typically called after calling shutdown() or shutdownNow()
			 * 
			 * 
			 * --> in this scenario its makes sense to call
			 * */
			ex.shutdown(); //if not calling shutdown, the program will not terminate --> comment out to test
			ex.awaitTermination(10000L, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
