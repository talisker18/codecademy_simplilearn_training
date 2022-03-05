package AAG_threads.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class B_newSingleThreadExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService ex = Executors.newSingleThreadExecutor();
		
		//execute 3 times. since there is only 1 thread, the same thread is visible in the sysout
		//and since its only 1 thread, the tasks are NOT done in parallel (just run the program and see the output)
		
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
					Thread.sleep(5000);
					System.out.println("end of sleep, "+Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("sleep of "+Thread.currentThread().getName()+" was interrupted");
					e.printStackTrace();
				}
				
			}
			
		});
		
		ex.shutdown();
	}

}
