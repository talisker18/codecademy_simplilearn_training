package AAG_threads.different_implementations;

public class Ex0a_NotThreadSafe implements Runnable{
	public static int counter=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex0a_NotThreadSafe myRunnable = new Ex0a_NotThreadSafe();
		(new Thread(myRunnable)).start();
		System.out.println("ausgabe main "+counter);
		counter++;
		System.out.println("ausgabe main "+counter);

	}

	@Override
	public void run() {
		counter++;
		System.out.println("ausgabe thread "+counter);
		
	}

}
