package AAG_threads.different_implementations;

public class Ex0c_ThreadingWithJoin {

    public static void main(String[] args) throws InterruptedException {
    
        ProcessingThread pt = new ProcessingThread();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        //wait for threads to finish processing
        t1.join();
        t2.join(); //wenn die joins gleich nach dem jeweiligen start aufgerufen werden, erreicht man auch eine art thread safety
        System.out.println("Processing count="+pt.getCount());
    }

}

class ProcessingThread implements Runnable{
    private int count;
    
    @Override
    public void run() {
        for(int i=1; i < 5; i++){
            processSomething(i);
        	count++;
        }
    }

    public int getCount() {
        return this.count;
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
