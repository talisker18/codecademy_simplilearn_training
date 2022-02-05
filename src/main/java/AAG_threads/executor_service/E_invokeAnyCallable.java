package AAG_threads.executor_service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 *  The invokeAny() method takes a collection of Callable objects, or subinterfaces of Callable. Invoking this method does not return a Future, but returns the result of one of 
 *  the Callable objects. You have no guarantee about which of the Callable's results you get. Just one of the ones that finish.

If one Callable finishes, so that a result is returned from invokeAny(), then the rest of the Callable instances are cancelled.

If one of the tasks complete (or throws an exception), the rest of the Callable's are cancelled. 
 * 
 * 
 * 
 * 
 * 
 * */

public class E_invokeAnyCallable {

	public static void main(String[] args) throws ExecutionException {
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
		
		//invoke any of these callables
		System.out.println("from main thread before invoking callable");
		
		String str = null;
		
		try {
			//Executes the given tasks, returning the resultof one that has completed successfully (i.e., without throwingan exception), 
			//if any do. Upon normal or exceptional return,tasks that have not completed are cancelled --> therefore, the sleep of the next executed Callable will be interrupted and therefore
			//InterrupedException is thrown
			str = ex.invokeAny(setOfCallables);
		} catch (InterruptedException | ExecutionException e) { //there will be an InterrupedException of the other Callable 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("from main thread after invoking callable");
		
		System.out.println("print returned object from call(): "+str);
		
		ex.shutdown();

	}

}
