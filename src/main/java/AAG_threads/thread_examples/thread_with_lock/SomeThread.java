package AAG_threads.thread_examples.thread_with_lock;

class SomeThread extends Thread{
	private String s1;
	private String s2;
	
	SomeThread(String s1, String s2){
		this.s1 = s1;
		this.s2 = s2;
	}
	
	@Override
	public void run() {
		try {
			ThreadWithLockDemo.print(this.s1, this.s2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
