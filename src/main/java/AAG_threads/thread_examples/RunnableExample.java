package AAG_threads.thread_examples;

public class RunnableExample implements Runnable {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//here we have to call the static method currentThread() with Thread class
		System.out.println("thread started: "+Thread.currentThread().getName());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableExample r1 = new RunnableExample();
		//here we do not have start method because its method of Thread
		//even here, no parallel execution with run()
		r1.run();
		
		RunnableExample r2 = new RunnableExample();
		r2.run();
		
		//for parallel execution we need to create a thread object
		Thread t1 = new Thread(r1);
		t1.start();
		
		Thread t2 = new Thread(r2);
		t2.start();
		
		
		/*
		 * 
		 * conclusion: better use Runnable because its an interface and u can implement mutliple
		 * 
		 * with thread, you have already extended a class
		 * 
		 * */
		
		
	}

}
