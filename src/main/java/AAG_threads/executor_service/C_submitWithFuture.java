package AAG_threads.executor_service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class C_submitWithFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService ex = Executors.newSingleThreadExecutor();
		
		@SuppressWarnings("rawtypes") //we do not need a type param for future because run() is void. Compare that with F_invokeAllCallable.java where we use call() of Callable interface, returning a object.
		//there, we set a type param
		Future future = ex.submit(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("thread "+Thread.currentThread().getName()+" executing task");
				try {
					System.out.println("start of sleep");
					Thread.sleep(5000);
					System.out.println("end of sleep");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		System.out.println("from main thread before future.get()");
		
		future.get(); //wait here until task has finished, then continue the main thread
		
		System.out.println("from main thread after future.get()");
		
		System.out.println(future.get());
		
		ex.shutdown();

	}

}
