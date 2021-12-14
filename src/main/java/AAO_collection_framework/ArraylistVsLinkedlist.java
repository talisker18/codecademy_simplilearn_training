package AAO_collection_framework;

import java.util.LinkedList;

public class ArraylistVsLinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//linked lists are using pointers
		LinkedList<String> list = new LinkedList<String>();
		list.add("string1"); //like arraylist
		//new methods
		list.addFirst("stringFirst"); //but for this we need a LinkedList obj because List does not have that method
		list.addLast("stringLast");
		
		for(String str: list) {
			System.out.println(str);
		}

		
		//so in LinkedList, insertion and deleting is faster than in ArrayList
		//but searching is faster in ArrayList, becfause in LinkedList we have to visit every element one by one
		
		//in array, if u delete or insert something, the elements before and after have to be shifted on position
		
		//whereas in linkedlist, there is only a pointer to the element. this pointer has only
		//to be deleted or inserted
		
		
		
	}

}
