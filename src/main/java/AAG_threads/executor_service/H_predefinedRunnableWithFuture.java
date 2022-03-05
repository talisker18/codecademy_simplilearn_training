package AAG_threads.executor_service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class H_predefinedRunnableWithFuture implements Runnable{
	
	private int counter = 0;
	private static Object LOCK = new Object();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.increase();
		
	}
	
	private void increase() {
		synchronized(LOCK) {
			System.out.println("locked by thread: "+Thread.currentThread().getName());
			this.counter++;
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		H_predefinedRunnableWithFuture runner = new H_predefinedRunnableWithFuture();
		
		ExecutorService ex = Executors.newFixedThreadPool(10);
		
		Future future1 = ex.submit(runner);
		Future future2 = ex.submit(runner);
		Future future3 = ex.submit(runner);
		
		List<Future> list = Arrays.asList(future1,future2,future3);
		
		//wait until all 3 tasks are done
		for(Future f: list) {
			System.out.println("call future get");
			f.get();
			System.out.println("task finished");
		}
		
		//comment out ex.shutdown(), you will see that the application does not terminate
		ex.shutdown();
		
		
	}

}
