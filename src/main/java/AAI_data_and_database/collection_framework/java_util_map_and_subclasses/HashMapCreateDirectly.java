package AAI_data_and_database.collection_framework.java_util_map_and_subclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapCreateDirectly {
	
	public static void main(String[] args) {
		Map<String,String> STOCK_DB = new HashMap<String, String>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put("key1", "val1");
				put("key2", "val2");
			}
			
			//here we could override existing methods of HashMap.class because our
			//anonymous class extends HashMap.class
			//...
			
			//here we could define complete new class body for our anonymous class
			public void doSomething() {
				
			}
		};
		
		STOCK_DB.entrySet().stream().forEach(System.out::println);
		
		/*
		 * this does not work with list.add() because add is method from interface List
		 * so we have to implement the interface method add()
		 * 
		 * */
		
		List<String> list = new ArrayList<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean add(String e) {
				// TODO Auto-generated method stub
				return super.add(e);
			}
		};
		
		list.add("test");
		list.add("test2");
		
		System.out.println(list);
	}
	

}
