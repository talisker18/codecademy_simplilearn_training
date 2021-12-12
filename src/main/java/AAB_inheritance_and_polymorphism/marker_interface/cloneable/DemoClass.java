package AAB_inheritance_and_polymorphism.marker_interface.cloneable;

/*Cloneable is only a marker interface
 * 
 * An interface that does not contain methods, fields, and constants is known as marker interface. 
 * In other words, an empty interface is known as marker interface or tag interface
 * 
 * Cleanable interface in Java is also a marker interface that belong to java.lang package. 
 * It generates replica (copy) of an object with different name. We can implement the interface in the 
 * class of which class object to be cloned. It indicates the clone() method of the Object class. 
 * If we do not implement the Cloneable interface in the class and invokes the clone() method, it throws the ClassNotSupportedException. 
 * 
 * */

public class DemoClass implements Cloneable{
	
	String text;
	
	public DemoClass(String text) {
		this.text=text;
	}
	
	//here we are overriding the clone() method of object class
	//this is the actual funcionality. implementing Cloneable just marks that we have defined a clone() method in this class
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
