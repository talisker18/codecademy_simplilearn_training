package AAD_java8.lambda_functionalInterfaces_methoReference.MathExample;

public class SubstractionClass implements OwnMathFunctionalInterface {
	public double a;
	public double b;

	@Override
	public double executeAndReturnCalculation(double a, double b) {
		// TODO Auto-generated method stub
		return a-b;
	}

}
