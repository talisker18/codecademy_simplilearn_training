package ZAB_apps.scanner_apps.calculator;

public class CalculatorDemo {
	
	//
	
	//this class uses 2 int variables and does all the arithmetic operations
	private int result;
	
	public void addition(int a, int b) {
		System.out.println("addition of "+a+" and "+b+" will be calculated");
		this.result = a+b;
		System.out.println("addition is: "+result);
	}
	
	public void substraction(int a, int b) {
		System.out.println("substraction of "+a+" and "+b+" will be calculated");
		this.result = a-b;
		System.out.println("substraction is: "+result);
	}
	
	public void multiplication(int a, int b) {
		System.out.println("multiplication of "+a+" and "+b+" will be calculated");
		this.result = a*b;
		System.out.println("multiplication is: "+result);
	}
	
	public void division(int a, int b) {
		System.out.println("division of "+a+" and "+b+" will be calculated");
		this.result = a/b;
		System.out.println("division is: "+result);
	}

}
