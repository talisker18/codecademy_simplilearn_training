package AAG_threads.different_implementations;

public class Ex0b_ThreadingWithThreadClass extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex0b_ThreadingWithThreadClass thread = new Ex0b_ThreadingWithThreadClass();
		
		thread.start(); //führt die methode run aus, welche wir weiter unten überschreiben

	}
	
	@Override
	public void run() { //Thread class hat bereits die methode run. man muss sie aber nicht overriden, da sie nicht abstract ist
		System.out.println("test");
	}

}
