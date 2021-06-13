package AAD_java8.MathExample;

public class AdditionClass implements OwnMathFunctionalInterface{
	private double a;
	private double b;
	
	public AdditionClass(double a, double b) {
		this.a=a;
		this.b=b;
	}

	@Override
	public double executeAndReturnCalculation(double a, double b) {
		// TODO Auto-generated method stub
		return a+b;
	}
	
	public double getA() {
		return this.a;
	}
	
	public double getB() {
		return this.b;
	}

}
