package AAG_threads.multiThreadingHandling;

public class WithSynchroMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//each resource has its own thread
		Resource r1 = new Resource();
		Thread t1 = new Thread(r1);
		t1.start();
		
		Resource r2 = new Resource();
		Thread t2 = new Thread(r2);
		t2.start();
		
		//until here: no problem with multi threading
		
		//counter is most of the time 0 because main thread was faster
		System.out.println(r1.count);
		
		//when we reach this line, counter is not yet finished fully
		//because main thread and r2 thread are running in parallel
		System.out.println(r2.count);
		System.out.println("-------------------");
		
		//to ensure to get full counter of r1 when printing counter, we could join the threads
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//now it prints the full counter because also the main thread is waiting for the finish of joins
		System.out.println(r1.count);
		System.out.println(r2.count);
		
		//now we will share 1 resource on 2 threads
		System.out.println("---------------- multi threading on 1 resource");
		
		Resource r3 = new Resource();
		Thread t3 = new Thread(r3);
		t3.start();
		
		Thread t4 = new Thread(r3);
		t4.start();
		
		System.out.println(r3.count);
		
		//ok lets join both
		
		try {
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(r3.count); //now we almost got the double counter of the expected counter
		//because both threads were changing the value at the same time
		//we also see that the sysout in modify() is printing not the right order
		
		
		//this is bad, we have to control the threads better. do it with e.g. synchronization, see Resource2
		
		System.out.println("--------------------multi threading with synchro");
		
		Resource2 r4 = new Resource2();
		Thread t5 = new Thread(r4);
		t5.start();
		
		Thread t6 = new Thread(r4);
		t6.start();
		
		System.out.println(r4.count);
		
		//ok lets join both
		
		try {
			t5.join();
			t6.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(r4.count); //because of synchronization, now the counter is in better order
		//because the resource2 is locked when a thread is changing it
		//it unlocks for other thread until the operation is ACID

	}

}

class Resource implements Runnable{
	
	int count; //initial value = 0
	
	void modify() {
		count++;
		System.out.println(count+", "+Thread.currentThread().getName());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<1000;i++) {
			this.modify();
		}
		
	}
}

class Resource2 implements Runnable{
	
	int count; //initial value = 0
	
	synchronized void modify() {
		count++;
		System.out.println(count+", "+Thread.currentThread().getName());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<1000;i++) {
			this.modify();
		}
		
	}
}
