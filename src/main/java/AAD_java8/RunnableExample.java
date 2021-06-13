package AAD_java8;

import java.util.Set;

public class RunnableExample {
	
	private static void runThread() {
		System.out.println("method ref thread");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		
		threadSet.stream().forEach(t ->System.out.println(t));
		
		System.out.println("/////////////////");
		
		//anonymous inner class
		Thread myThread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("printed in runnable");
				
			}
			
		});
		
		myThread.start();
		
		Thread myLambdaThread = new Thread(()-> System.out.println("lambda thread"));
		myLambdaThread.start();
		
		Thread myMethodRefThread = new Thread (RunnableExample::runThread);
		myMethodRefThread.start();
		
		Set<Thread> threadSet2 = Thread.getAllStackTraces().keySet();
		
		threadSet2.stream().forEach(System.out::println);
		
		for (Thread t : threadSet2) {
		    String name = t.getName();
		    Thread.State state = t.getState();
		    int priority = t.getPriority();
		    String type = t.isDaemon() ? "Daemon" : "Normal";
		    System.out.printf("%-20s \t %s \t %d \t %s\n", name, state, priority, type);
		}

	}

}
