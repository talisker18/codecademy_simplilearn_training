package AAG_threads.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class G_predefinedRunnable implements Runnable{

	private int counter = 0;
	private static Object LOCK = new Object();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		G_predefinedRunnable runner = new G_predefinedRunnable();
		
		ExecutorService ex = Executors.newFixedThreadPool(10);
		//start multiple threads in parallel
		ex.execute(runner); //execute one thread
		ex.execute(runner); //execute one thread
		ex.execute(runner); //execute one thread
		ex.execute(runner); //execute one thread
		
		System.out.println(runner.getCounter());
		
		try {
			ex.shutdown();
			ex.awaitTermination(10, TimeUnit.MILLISECONDS); //main program does not wait here. it just waits with shutting down when this method is called
			System.out.println(runner.getCounter());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		this.increase();
		
	}
	
	private void increase() {
		synchronized (LOCK) {
			System.out.println("locked by thread: "+Thread.currentThread().getName());
			this.counter++;
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public int getCounter() {
		return this.counter;
	}

}
