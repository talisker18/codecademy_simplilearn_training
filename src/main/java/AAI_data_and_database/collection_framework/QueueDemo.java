package AAI_data_and_database.collection_framework;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> q = new PriorityQueue<String>(); //does sorting too
		
		q.add("Dog");
		q.add("Cat");
		q.add("Cow");
		q.add("Bull");
		q.add("Ox");
		q.peek();
	
		for(String str: q) {
			System.out.println(str);
		}
		
		System.out.println("---------");
		System.out.println(q.peek()); //print head of the queue (=beginning)
		
		//queue -> ist eine Liste von Elementen, bei der die Elemente auf einer Seite 
		//eingefügt (enqueue, am ende der queue) und in derselben Reihenfolge auf der 
		//anderen Seite (dequeue, am anfang der queue) wieder entnommen werden:
		
		//deque Double-ended queue, ausgesprochen "Deck" -> 
		//ist eine Liste von Elementen, bei der die Elemente sowohl auf der 
		//einen als auch auf der anderen Seite eingefügt und entnommen werden können:

	}

}
