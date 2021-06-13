package AAG_threads.different_implementations;

public class Ex0d_MultipleThreads{

	public static void main(String[] args){
	    System.out.println(Thread.currentThread().getName()); //main thread
	    for(int i=0; i<10; i++){
	      new Thread("" + i){
	        public void run(){
	          System.out.println("Thread: " + getName() + " running");
	        }
	      }.start(); //anonymous implementation
	    }
	    System.out.println("main thread wieder");
	  }

}
