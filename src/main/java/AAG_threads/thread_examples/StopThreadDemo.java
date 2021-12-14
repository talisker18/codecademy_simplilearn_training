package AAG_threads.thread_examples;

public class StopThreadDemo implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StopThreadDemo s1 = new StopThreadDemo();
		Thread t1 = new Thread(s1);
		
		t1.start();
		
		while(t1.isAlive()) {
			//block the main thread while t1 is running
		}
		
		//in other words: if the run method of a thread has reached last line
		//or was returned (like in this example), the thread will be killed
		
		System.out.println("t1 thread was killed");

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread started: "+Thread.currentThread().getName());
		for(int i = 0; i<10; i++) {
			System.out.println("we are in the loop: "+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(i == 5) {
				return; //this will stop the thread because we return to the place where method was called
			}
		}
		
		
	}

}
