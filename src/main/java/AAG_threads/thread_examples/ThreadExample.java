package AAG_threads.thread_examples;

public class ThreadExample extends Thread{
	
	public void run() {
		//implement the run method. when we start a thread, this method is called
		//automatically
		System.out.println("thread started: "+currentThread().getName());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//start multiple threads / multi threading
		ThreadExample t1= new ThreadExample();
		t1.start();
		
		ThreadExample t2= new ThreadExample();
		t2.start();
		
		ThreadExample t3= new ThreadExample();
		t3.start();
		
		ThreadExample t4= new ThreadExample();
		t4.start();
		
		
		//threads are started independent, so we cant control the startup
		//it depends which cpu core is used for each thread (its dynamically)
		
		
		//dont use run to start a thread
		/*
		 * 
		 * difference run and start
		 * 
		 * While if run method is executed directly than no new Thread is 
		 * created and code inside run() will execute on current Thread and 
		 * no multi-threading will take place.
		 * 
		 * *****************
		 * 
		 * If you just invoke run() directly, it's executed on the calling thread, 
		 * just like any other method call. Thread.start() is required to actually create 
		 * a new thread so that the runnable's run method is executed in parallel.
		 * 
		 * */
		
		
		ThreadExample t5= new ThreadExample();
		t5.run(); //this will print main thread
		//since we are executing the main thread when starting the program
		//the run method is called on the main thread
		
		ThreadExample t6= new ThreadExample();
		t6.run(); //this will print main thread

	}

}
