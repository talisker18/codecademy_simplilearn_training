package AAD_java8.GreetingDemo;

//runner class
public class Greeter {
	
	//nimmt ein interface obj auf. dadurch können alle interface implementationen behandelt werden, in diesem beispiel die HelloWorldGreeting implementation
	public void greet(Greeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//classic OOP mit inferface, impl of interface und runner class
		Greeter greeter = new Greeter();
		HelloWorldGreeting hellow = new HelloWorldGreeting();
		greeter.greet(hellow); //hellow ist ein objekt der klasse HelloWorldGreeting, fungiert hier aber als behavior, da dort hello world ausgegeben wird
		
		
		//lambda style. mit lambda kann man das system out println, also eine aktion, direkt einer variablen zuweisen.
		//ursprünglich würde es so aussehen:
		
		/*
		 * greetingFunction = public void perform() {
		 * 
		 * 		System.out....
		 * }
		 * 
		 * das public, void und methodenname kann man entfernen. wenn es nur 1 zeile in der methode gibt kann man {} auch
		 * weglassen:
		 * 
		 * greetingFunction = () -> System.out.println();
		 * 
		 * weiteres beispiel:
		 * 
		 * doubleNumberFunction = public int perform(int a){
		 * 
		 * 		return 2*a;
		 * 
		 * }
		 * 
		 * --> ergibt:
		 * 
		 * doubleNumberFunction = (int a) -> a*2; --> return kann man auch weglassen, da der compiler merkt, ob es void oder eine rückgabe ist
		 * 
		 * 
		 * weiteres beispiel:
		 * 
		 * addFunction= (int a, int b) -> a+b;
		 * 
		 * safeDivideFunction = (int a, int b) -> {
		 * 
		 * 		if (b == 0) return 0;
		 * 
		 * 		return a/b;
		 * }
		 * 
		 * stringLengthCountFunction = (String s) -> s.length();
		 * 
		 * */
		
		//lambda style, um behavior zu machen. dazu braucht es ein interface mit einer methode (methodenname egal!!!). die methode muss die gleiche signatur haben wie die methode in
		//der lambda expression, hier void und ohne parameterübergabe
		
		//type von variable ist ein interface!!!
		MyLambda myLambdaFunction = () -> System.out.println("Hello world myLambdaFunction");
		
		//mit foo() gibt man nun Hello world myLambdaFunction aus, bzw man führt methode foo() erst hier aus. oben wird sie nur einer var zugewiesen
		myLambdaFunction.foo();
		
		//weiteres beispiel: methode foo2() vom interface MyAdd der variable addFunction zuweisen
		MyAdd addFunction = (int a, int b) -> a+b;
		
		//foo2() ausführen in einem println
		
		System.out.println(addFunction.foo2(2, 2)); //gibt 2+2 aus, also 4		
		
		
		
		
		
		//nun kann man natürlich gleich die perform methode nutzen von Greeting interface------------------------------
		
		Greeting myLambdaFunction2 = () -> System.out.println("Hello World"); 
		
		myLambdaFunction2.perform();
		
		//via inner anonym class (klasse innerhalb einer klasse, ohne klassenname). sprich die inner class ist eine implementation von greeting interface
		//das macht das genau gleiche wie mit myLambdaFunction2. jedoch ist das lambda nicht ein shortcut für inner classes!!!
		
		Greeting innerClass = new Greeting() {
			public void perform(){
				System.out.println("hello inner class");
			}
		};
		
		innerClass.perform();
		
		//alternative über greeter class
		
		greeter.greet(innerClass);
		
	

	}
	
	interface MyLambda{
		void foo();
	}
	
	interface MyAdd{
		int foo2(int a, int b);
	}

}
