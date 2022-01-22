package AAI_data_and_database.collection_framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Collection<Object> col = new ArrayList<Object>(); //u can do this instead of List
		
		col.add("String");
		col.add(7);
		
		
		//because List implements Collection
		//...and ArrayList implements List...and e.g. AttributeList extends ArrayList
		
		
		//now if a class implements Iterable Interface, we can use for each loop
		
		//or we can use Iterator <E> to iterate over any member of Collection interface
		
		Iterator<Object> iter = col.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}

	}

}
