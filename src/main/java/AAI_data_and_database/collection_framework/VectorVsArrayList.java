package AAI_data_and_database.collection_framework;

import java.util.ArrayList;
import java.util.Vector;

public class VectorVsArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList();
		al.add("1");
		al.add("1");
		al.add("1");
		al.add("1");
		al.add("1");
		
		System.out.println(al.size());
		
		
		Vector v = new Vector();
		v.add("1");
		v.add("1");
		v.add("1");
		v.add("1");
		v.add("1");
		v.add("1");
		v.add("1");
		v.add("1");
		v.add("1");
		v.add("1");
		v.add("1");
		v.add("1");
		v.add("1");
		v.add("1");
		v.add("1");
		
		System.out.println(v.size());
		System.out.println(v.capacity()); //vector has only capacity of 10 by default
		//if u increase size, capacity will increased automatically by 10, e.g.
		//if we have 15 elements, capacity will be increased to 10
		//because of this, vector can waste memory so its not used anymore
		
		//BUT!!! vector has synchronized methods, so its thread safe. thats the only advantage over ArrayList
		//-> (ArrayList is not thread safe!!!)

	}

}
