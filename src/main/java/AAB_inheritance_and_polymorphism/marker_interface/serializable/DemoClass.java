package AAB_inheritance_and_polymorphism.marker_interface.serializable;

import java.io.Serializable;

//since this is only a marker interface, we do not have to implement anything from interface

public class DemoClass implements Serializable{

	public String name;
	public String address;
	public transient int SSN; //this will not be serialized
	public int number;
	
	public DemoClass(String name, String address, int sSN, int number) {
		super();
		this.name = name;
		this.address = address;
		SSN = sSN;
		this.number = number;
	}
	
	
	
}
