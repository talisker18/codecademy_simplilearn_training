package AAG_threads.different_implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Ex4_ThreadSafetyWithSynchronizedCollections {
	
	/*
	 * 
	 * We can easily create thread-safe collections by using the set of synchronization wrappers included within the collections framework.

We can use, for instance, one of these synchronization wrappers to create a thread-safe collection:

Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
Thread thread1 = new Thread(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
Thread thread2 = new Thread(() -> syncCollection.addAll(Arrays.asList(7, 8, 9, 10, 11, 12)));
thread1.start();
thread2.start();

Let's keep in mind that synchronized collections use intrinsic locking in each method (we'll look at intrinsic locking later).

This means that the methods can be accessed by only one thread at a time, while other threads will be blocked until the method is unlocked by the first thread.
	 * 
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
		
		Thread thread1 = new Thread(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
		Thread thread2 = new Thread(() -> syncCollection.addAll(Arrays.asList(7, 8, 9, 10, 11, 12)));
		thread1.start();
		thread2.start();
		
		
		//join the threads so the iterator will print all values. if not joining, maybe not all values will be printed
		try {
			thread1.join();
			thread2.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator <Integer> iterator=syncCollection.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next()); //entweder kommen zuerst alle int von thread2 oder zuerst alle int von thread1...jedoch nie durcheinander
			//da synchronized collection
		}
		

	}

}
