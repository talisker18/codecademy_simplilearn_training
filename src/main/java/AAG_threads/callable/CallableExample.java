package AAG_threads.callable;

import java.security.InvalidParameterException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * see also: AAG_threads.executor_service
 * 
 * */

public class CallableExample implements Callable<Integer>{
	
	private int number;
	
	public CallableExample(int number) {
		this.number = number;
	}

	@Override
	public Integer call() throws InvalidParameterException {
		if(this.number < 0) {
			throw new InvalidParameterException("number should be positive");
		}
		
		return this.number;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CallableExample c = new CallableExample(5);
		
		ExecutorService e = Executors.newSingleThreadExecutor();
		Future<Integer> f1 = e.submit(c);
		int result = f1.get().intValue();
		e.shutdown();
		System.out.println("print result: "+result);
		
		CallableExample c2 = new CallableExample(-5);
		
		e = Executors.newSingleThreadExecutor();
		Future<Integer> f2 = e.submit(c2); //until here we wont see the InvalidParameterException
		
		//to see the exception we have to call the get() method
		
		try {
			Integer result2 = f2.get();
		} catch (Exception e2) { //with f2.get() we receive the original InvalidParameterException
			System.out.println("printing the original exception, it should be InvalidParameterException");
			System.out.println(e2.getCause());
		}
		
		e.shutdown();
		
		//check if task is completed / done 
		c2 = new CallableExample(5);
		
		e = Executors.newSingleThreadExecutor();
		f2 = e.submit(c2);
		
		while(!f2.isDone()) {
			System.out.println("task not done yet");
		}
		
		System.out.println("task is done");
		e.shutdown();
		
		//
	}

}
