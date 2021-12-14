package AAN_strings;

public class DemoToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A("Joel");
		
		System.out.println(a); //normally, this will print the memory address of the object...but with the string method it will print the specified string

	}

}

class A{
	String name;
	
	public A(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "the name is: "+this.name;
	}
}
