package AAG_threads.different_implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Ex4_ThreadSafetyWithSynchronizedCollectionsWithException {
	
	/*
	 * 
	 * same as before, but now we demonstrate concurrent exception. we try to print collection after thread1 join. 
	 * 
	 * but while printing, thread2 is still filling the collection with numbers
	 * 
	 * */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
		List<Integer> list1 = new ArrayList<Integer>();
		
		for(int i = 1; i<1000; i++) {
			list1.add(i);
		}
		
		List<Integer> list2 = new ArrayList<Integer>();
		
		for(int i = 1001; i<2000; i++) {
			list2.add(i);
		}
		
		Thread thread1 = new Thread(() -> syncCollection.addAll(list1));
		Thread thread2 = new Thread(() -> syncCollection.addAll(list2));
		thread1.start();
		thread2.start();
		
		thread1.join();
		//thread2.join(); --> we do not wait for thread2 to be finished
		
		Iterator<Integer> iterator=syncCollection.iterator();
		
		while(iterator.hasNext()) { //iterate over list while thread2 is still using the collection --> ConcurrentModificationException
			System.out.println(iterator.next());
		}
	}

}
