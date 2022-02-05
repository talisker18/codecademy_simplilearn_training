package AAG_threads.multiThreadingHandling;

public class WithSynchroBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource3 r1 = new Resource3();
		Thread t1 = new Thread(r1);
		t1.start();
		
		Thread t2 = new Thread(r1);
		t2.start();

	}

}

class Resource3 implements Runnable{
	int count;
	String name;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<10;i++) {
			this.modify("hello");
		}
		
	}
	
	void modify(String str) {
		
		//non synchro
		this.name = this.name+str;
		System.out.println("string modified by "+Thread.currentThread().getName());
		System.out.println(this.name);
		
		synchronized (this) { //call synchro block for THIS obj
			count++;
			System.out.println(count+", "+Thread.currentThread().getName());
		}
		
	}
	
}
