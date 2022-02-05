package AAG_threads.executor_service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 
 *  The invokeAll() method invokes all of the Callable objects you pass to it in the collection passed as parameter. The invokeAll() returns a list of Future objects via which you 
 *  can obtain the results of the executions of each Callable.

Keep in mind that a task might finish due to an exception, so it may not have "succeeded". There is no way on a Future to tell the difference. 
 * 
 * 
 * when calling invokeAll(), the call() methods of Callable are executed NOT in parallel but one at a time, e.g. task1 is finished, then task3 and then task2 --> run program and see output
 * 
 * */

public class F_invokeAllCallable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService ex = Executors.newSingleThreadExecutor();
		Set<Callable<String>> setOfCallables = new HashSet<Callable<String>>(); //the call() method will return a String, so set the type param to String
		
		setOfCallables.add(new Callable<String>() {

			@Override
			public String call() throws Exception {
				String task = "task1";
				System.out.println("thread "+Thread.currentThread().getName()+" executing task from Callable: "+task);
				try {
					System.out.println("start of sleep, "+task);
					Thread.sleep(5000);
					System.out.println("end of sleep, "+task);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("sleep of "+task+" was interrupted");
					e.printStackTrace();
				}
				return task;
			}
			
		});
		
		setOfCallables.add(new Callable<String>() {

			@Override
			public String call() throws Exception {
				String task = "task2";
				System.out.println("thread "+Thread.currentThread().getName()+" executing task from Callable: "+task);
				try {
					System.out.println("start of sleep, "+task);
					Thread.sleep(5000);
					System.out.println("end of sleep, "+task);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("sleep of "+task+" was interrupted");
					e.printStackTrace();
				}
				return task;
			}
			
		});
		
		setOfCallables.add(new Callable<String>() {

			@Override
			public String call() throws Exception {
				String task = "task3";
				System.out.println("thread "+Thread.currentThread().getName()+" executing task from Callable: "+task);
				try {
					System.out.println("start of sleep, "+task);
					Thread.sleep(5000);
					System.out.println("end of sleep, "+task);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("sleep of "+task+" was interrupted");
					e.printStackTrace();
				}
				return task;
			}
			
		});
		
		System.out.println("from main thread before invoking all callables");
		
		List<Future<String>> list = null;
		
		try {
			list = ex.invokeAll(setOfCallables);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("from main thread after invoking all callables");
		
		for(Future<String> future: list) {
			try {
				System.out.println("print future get(): "+future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ex.shutdown();

	}

}
