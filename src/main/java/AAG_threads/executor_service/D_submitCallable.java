package AAG_threads.executor_service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class D_submitCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

		ExecutorService ex = Executors.newSingleThreadExecutor();
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Future future = ex.submit(new Callable() {

			@Override
			public Object call() throws Exception {
				System.out.println("thread "+Thread.currentThread().getName()+" executing task");
				try {
					System.out.println("start of sleep");
					Thread.sleep(5000);
					System.out.println("end of sleep");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return "'some object'"; //if task has finished, this object will be returned and can be accessed through future.get()
			}
			
		});
		
		System.out.println("from main thread before future.get()");
		
		String str = (String) future.get(); //wait here until task has finished, then continue the main thread. the call() method will return a String
		
		System.out.println("from main thread after future.get()");
		
		System.out.println("print returned object from call(): "+str);
		
		ex.shutdown();
	}

}
