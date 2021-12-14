package AAG_threads.thread_examples;

public class ThreadPrioDemo implements Runnable {

	public static void main(String[] args) {
		
		/*
		 * As we already know java being completely object-oriented works within a multithreading 
		 * environment in which thread scheduler assigns the processor to a thread based on the 
		 * priority of thread. Whenever we create a thread in Java, it always has some priority assigned 
		 * to it. Priority can either be given by JVM while creating the thread or it can be given by the 
		 * programmer explicitly. 
		Priorities in threads is a concept where each thread is having a priority which in layman’s language 
		one can say every object is having priority here which is represented by numbers ranging from 1 to 10.
		 * 
		 * 
		 * 
		 * 
		 * */
		// TODO Auto-generated method stub
		//we only need 1 runnable / ThreadPrioDemo obj
		ThreadPrioDemo d1 = new ThreadPrioDemo();
		Thread t1 = new Thread(d1);
		t1.setName("T1");
		
		Thread t2 = new Thread(d1);
		t2.setName("T2");
		
		Thread t3 = new Thread(d1);
		t3.setName("T3");
		
		//in Thread class we have public final static int MIN, NORM and MAX_PRIORITY
		
		//t1.setPriority(100); //this will throw exception because 100 is not valid prio number
		//because we only have 1, 5 or 10 for XX_PRIORITY
		
		//with setPriority() we do have some control over threads
		t1.setPriority(10); //lowest prio
		t2.setPriority(5);
		t3.setPriority(1);
		
		//we can also use t1.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		
		
		/**
		 * but with this we do not have 100% control
		 * for better control we need to implement e.g. locks
		 * 
		 * but it can be useful to get the prio of a thread and compare it with other concurrent thread
		 * to e.g. choose which thread can lock a resource first
		 * 
		 * */

	}

	@Override
	public void run() {
		System.out.println("thread started: "+Thread.currentThread().getName());
		
	}

}
