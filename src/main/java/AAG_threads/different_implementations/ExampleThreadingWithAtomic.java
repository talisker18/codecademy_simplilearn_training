package AAG_threads.different_implementations;

import java.util.concurrent.atomic.AtomicInteger;

public class ExampleThreadingWithAtomic {

    public static void main(String[] args) throws InterruptedException {
    
    	ProcessingThread2 pt = new ProcessingThread2();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        //wait for threads to finish processing
        t1.join();
        t2.join(); //wenn die joins gleich nach dem jeweiligen start aufgerufen werden, erreicht man auch eine art thread safety
        System.out.println("Processing count="+pt.getCount()); // getCount not always 8
        System.out.println("processing atomic count = "+pt.getAtomicCount()); // will always be 8
    }

}

class ProcessingThread2 implements Runnable{
    private int count;
    private AtomicInteger atomicCount=new AtomicInteger(); //initialize with value 0
    
    @Override
    public void run() {
        for(int i=1; i < 5; i++){
            processSomething(i);
        	count++; //not atomic operation
        	atomicCount.incrementAndGet(); // this method does atomic operation
        }
    }

    public int getCount() {
        return this.count;
    }
    
    public int getAtomicCount() {
    	return atomicCount.get(); //returns int value of atomicCount
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
