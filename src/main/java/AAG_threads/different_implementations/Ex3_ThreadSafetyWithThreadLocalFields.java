package AAG_threads.different_implementations;

import java.util.Arrays;
import java.util.List;

public class Ex3_ThreadSafetyWithThreadLocalFields {
	
	/*
	 * 
	 * we can create thread-safe classes that don't share state between threads by making their fields thread-local.
	 * We can easily create classes whose fields are thread-local by simply defining private fields in Thread classes.
	 * 
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadA t1=new ThreadA();
		t1.start();
		
		ThreadB t2=new ThreadB();
		t2.start();

	}

}

class ThreadA extends Thread {
    
    private final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    
    @Override
    public void run() {
        numbers.forEach(System.out::println);
    }
}

class ThreadB extends Thread {
    
    private final List<String> letters = Arrays.asList("a", "b", "c", "d", "e", "f");
    
    @Override
    public void run() {
        letters.forEach(System.out::println);
    }
}
