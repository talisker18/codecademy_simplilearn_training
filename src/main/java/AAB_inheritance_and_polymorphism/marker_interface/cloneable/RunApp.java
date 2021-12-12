package AAB_inheritance_and_polymorphism.marker_interface.cloneable;

public class RunApp {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub

		DemoClass d1 = new DemoClass("test");
		
		DemoClass d2 = (DemoClass) d1.clone();
		
		System.out.println(d2.text);
	}

}
