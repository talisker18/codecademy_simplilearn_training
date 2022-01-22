package AAA_core.methods_and_constructors.method_overloading;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape s = new Shape();
		
		System.out.println(s.findArea(5.0));
		System.out.println(s.findArea(3.0F));
		System.out.println(s.findArea(3, 5));

	}

}
