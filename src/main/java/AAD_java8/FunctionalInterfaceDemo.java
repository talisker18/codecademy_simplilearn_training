package AAD_java8;

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//type 1: assign interface abstract method to an interface reference variable, then pass that variable as a param to another method-----------------------
		MyFunctionalInterface myFunction = () -> System.out.println("hello type1");
		doSomething(myFunction);
		
		
		//type 2: dont make reference var. pass the function inline and directly to another method----------------------------
		//or put the function directly as param
		doSomething( () -> System.out.println("hello type2")
				);
		
		//do some more complex stuff, type1
		
		MyFunctionalInterface myFunction2 = () -> {
			int a =10;
			int b = 20;
			if(b>10) {
				System.out.println("TESSSSSSSSSSSST type1");
			}
		};
		
		doSomething(myFunction2);
		
		//do some more complex stuff, type2
		
		doSomething(
				() -> {
					int a =10;
					int b = 20;
					if(b>10) {
						System.out.println("TESSSSSSSSSSSST type 2");
					}
				}
				);
		
		//type3: simply assign function to reference variable and use it directly------------------------
		MyFunctionalInterface myFunction3 = () -> System.out.println("hello type3");
		myFunction3.doSomething2();
		
		//type4: use of other interface with arguments------------------------------
		MyFunctionalInterface2 myFunction4 = (a,b) -> {
			return a+b;
		};
		
		int result = myFunction4.execute(10, 20);
		System.out.println(result);
		
		int result2 = myFunction4.execute(30, 20);
		System.out.println(result2);
		
		//multiply function
		MyFunctionalInterface2 myFunction5 = (a,b) ->  a*b; //we dont need to specify type of input nor return statement nor type of return type
		System.out.println(myFunction5.execute(12, 14));
		

	}
	
	public static void doSomething(MyFunctionalInterface myFunction) {
		myFunction.doSomething2();
	}

}

@FunctionalInterface
interface MyFunctionalInterface{
	void doSomething2(); //by default public and abstract
}

@FunctionalInterface
interface MyFunctionalInterface2{
	int execute(int a, int b);
}
