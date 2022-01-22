package AAI_data_and_database.collection_framework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		//Map is an interface
		Map<String,String> m = new HashMap<String,String>();
		
		m.put("1", "1");
		m.put("2", "2");
		m.put("3", "3");
		
		//get all keys of the map
		Set<String> keys = m.keySet();
		
		for(String str: keys) {
			System.out.println(str+", value: "+m.get(str));
		}
		
		//...or iterate directly the map
		for(Map.Entry<String, String> entry: m.entrySet()) {
			System.out.println("key: "+entry.getKey()+"; value: "+entry.getValue());
		}
	}

}
