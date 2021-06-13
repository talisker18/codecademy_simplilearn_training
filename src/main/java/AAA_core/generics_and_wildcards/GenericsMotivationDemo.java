package AAA_core.generics_and_wildcards;

import java.util.ArrayList;
import java.util.List;

public class GenericsMotivationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//without use of generic (<String>)
		
		/**List v = new ArrayList();
		v.add("test"); // A String that cannot be cast to an Integer
		Integer i = (Integer)v.get(0); // Run time error!!!!!!!!!!!!!!!!!!!!!!!*/
		
		//with use of generic, it will give a compile error
		List<String> v = new ArrayList<String>(); //use of generic
		v.add("test");
		Integer i = (Integer)v.get(0); // (type error)  compilation-time error

	}

}
