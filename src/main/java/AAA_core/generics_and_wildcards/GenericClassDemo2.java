package AAA_core.generics_and_wildcards;

public class GenericClassDemo2 <K, V> { //with 2 types, key and value...same as interface Pair<K,V>
	private K key;
	private V value;
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	public void printAllKeysOfAList(GenericClassDemo2<K,V> [] array) {
		for(GenericClassDemo2<K,V> element: array) {
			System.out.println(element.getKey());
		}
	}
	
	public static void main(String[] args) {
		GenericClassDemo2 <Integer,String> g1 = new GenericClassDemo2<Integer, String>();
		
		g1.setKey(1);
		g1.setValue("hello");
	}
	
}
