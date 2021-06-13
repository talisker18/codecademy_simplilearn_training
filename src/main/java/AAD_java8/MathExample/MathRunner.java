package AAD_java8.MathExample;

public class MathRunner {
	
	//one method needed for execute all math operations. As param, we need a function from OwnMathFunctionalInterface
	public static double calculate(OwnMathFunctionalInterface ownMathFunction, double a, double b) { //here we give FunctionalInterface as param. so we can give reference variables 
		//of AdditionClass, SubstractionClass etc as arguments. this works because AdditionClass etc IS CHILD OF FunctionalInterface
		return ownMathFunction.executeAndReturnCalculation(a, b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdditionClass adder = new AdditionClass(10.0, 20.0); //here, we first create just an object of AdditionClass which inherits from FunctionalInterface. So we can
		//call on that object the executeAndReturnCalculation(a,b) method
		double result1 = MathRunner.calculate(adder, adder.getA(), adder.getB());
		System.out.println(result1);
		
		//instead of using calculate, just call the executeAndReturnCalculation(a,b) directly like on a normal object
		double result6 = adder.executeAndReturnCalculation(55, 5);
		//-> the above example with passing function to calculate is imo unnecessary code...best imo is directly assign a function to instance of OwnMathFunctionalInterface, as following
		
		
		//instead of making SubtractionClass, we directly use function
		OwnMathFunctionalInterface ownMathFunction = (a,b) -> a-b; //here, we save the specified function into the reference var ownMathFunction. 
		//On ownMathFunction, we can call then ownMathFunction.executeAndReturnCalculation(a,b) like for a normal object
		double result2 = MathRunner.calculate(ownMathFunction, 50, 30);
		System.out.println(result2);
		
		//do the same but inline, with division
		double result3 = MathRunner.calculate(
				(a,b) -> a/b, //define a function, here division
				100, //input 1
				20 //input 2
				);
		
		System.out.println(result3);
		
		//use a child class for substraction
		SubstractionClass sub = new SubstractionClass();
		sub.a = 30;
		sub.b= 20;
		
		double result4 = MathRunner.calculate(sub, sub.a, sub.b);
		
		
		//or do it without ref var of SubstractionClass
		OwnMathFunctionalInterface subType = (a,b) -> a-b;
		double result5 = MathRunner.calculate(subType, 100 , 70);
		System.out.println(result5);
		
		//do some more complex stuff
		//OwnMathFunctionalInterface ownFunction = (a,b,c) -> a+b+c; -> this does not work, input is different from interface
		OwnMathFunctionalInterface ownFunction = (a,b) -> {
			
			if(a>b) {
				return 100;
			}else {
				return 200;
			}
		};
		
		System.out.println(MathRunner.calculate(ownFunction, 100, 50));
		System.out.println(MathRunner.calculate(ownFunction, 20, 50));
		

	}

}
