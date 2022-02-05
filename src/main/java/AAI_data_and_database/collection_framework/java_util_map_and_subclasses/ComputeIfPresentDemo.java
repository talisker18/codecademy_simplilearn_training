package AAI_data_and_database.collection_framework.java_util_map_and_subclasses;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/*
 * The computeIfPresent(Key, BiFunction) method of HashMap class which allows you to compute value of a mapping for specified key if key is already associated with a value (or is mapped to null).

    If mapping function of this method returns null, the mapping is removed.
    If the remapping function throws an exception, the exception is rethrown, and the mapping is left unchanged.
    During computation, modification this map using this method is not allowed.
 * 
 * 
 * Parameters: This method accepts two parameters:

    key: key with which the value is to be associated.
    remappingFunction: function to do the operation on value.

Returns: This method returns new remapped value associated with the specified key, or null if mapping returns null.
 * 
 * 
 * */



//there is also a computeIfAbsent method
public class ComputeIfPresentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BiFunction<String, Integer, Integer> bifunction = (key,val) -> val+100; //first param is the key, so its a string
		
		Map<String,Integer> map = new HashMap<String, Integer>();
		
		map.put("key1", 1);
		map.put("key2", 2);
		map.put("key3", 3);
		
		System.out.println(map);
		
		//add +100 to value if key is present in map
		map.computeIfPresent("key1", bifunction);
		map.computeIfPresent("key4", bifunction);
		
		System.out.println(map); //key1 is increased by 100

	}

}
