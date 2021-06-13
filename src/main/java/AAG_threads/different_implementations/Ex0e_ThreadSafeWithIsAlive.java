package AAG_threads.different_implementations;

public class Ex0e_ThreadSafeWithIsAlive implements Runnable{
	public static int counter=0;

	public static void main(String[] args) {
		Ex0e_ThreadSafeWithIsAlive myRunnable = new Ex0e_ThreadSafeWithIsAlive();
		Thread thread = new Thread(myRunnable);
		thread.start();
		while(thread.isAlive()) {
			System.out.println("waiting...");
		}
		System.out.println(counter);
		counter++;
		System.out.println(counter);

	}

	@Override
	public void run() {
		counter++;
		
	}

}
