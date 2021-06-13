package AAD_java8.PersonExample;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import AAD_java8.PersonExample.Unit1Exercise_lambdaStyle.AddCondition;

public class Unit1Exercise_methodRefStyle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people = Arrays.asList(
				new Person("Max", "Test",38),
				new Person("Turi", "Ruch",38),
				new Person("Joel","Henz",33),
				new Person("Anita","Henz",63)
				);
		
		//step1: sort list by lastname
		//method reference auf static method
		Comparator <Person> comparator = Unit1Exercise_methodRefStyle::comparePersonObjects; //static comparePersonObjects überschreibt compare methode von Comparator
		
		//folgendes geht nicht:
		//Comparator <Person> comparator = Comparator::compare; --> man kann also nicht die compare methode direkt vom interface Comparator referenzieren, da dies
		//ja ein interface ist. es muss immer class::method dieser class sein
		//sobald ich Comparator <Person> comparator schreibe, wird nach dem = Zeichen das override von der compare methode von Comparator gemacht
		//und beim overriding muss die gleiche signatur vorhanden, sprich Object o1, Object o2
		
		
		//method reference auf instance method
		/*
		 * Instance method are methods which require an object of its class to be created before it can be called. 
		 * To invoke a instance method, we have to create an Object of the class in within which it defined.
		 * 
		 * */
		Unit1Exercise_methodRefStyle obj1 = new Unit1Exercise_methodRefStyle();
		Comparator <Person> comparator2 = obj1::compare2; //compare2 überschreibt compare method von Comparator
		
		
		//dritte möglichkeit: Comparator interface hat auch die static methode comparing. Comparing verlangt eine Function als parameter
		//Function ist ein functional interface, welches ein input typ und ein output typ definiert:
		/*Interface Function<T,R>
		 * 
		 * 
			Type Parameters:
    		T - the type of the input to the function
    		R - the type of the result of the function 
    		
    		public interface Function<T,R> {

    			public <R> apply(T parameter);
			}
		 * 
		 * */
		Function <Person,String> myFunction = (Person p1) -> p1.getLastName(); //overrides apply method of Function interface -> input = Person, output = lastName
		Comparator <Person> comparator3 = Comparator.comparing(myFunction); //comparing gibt einen Comparator zurück
		
		//folglich
		Person p10 = new Person("Joel","Henz",33);
		//Function <Person,String> myFunction2 = p10::getLastName; --> geht nicht. man muss bei method reference
		//...aber korrekt ist
		Function <Person,String> myFunction3 = Person::getLastName; //hier ist static für getLastName nicht nötig, weil die aufrufende klasse Person = rückgabewert ist
		//oder: getLastName muss von einem Person obj aufgerufen werden, also z.b. Person p1 ---> p1.getLastName. Das Input ist sozusagen ein Person obj, 
		//rückgabe ist ein String
		
		Function <Unit1Exercise_methodRefStyle,String> myFunction4= Unit1Exercise_methodRefStyle::getLastname;
		
		Function <Person,String> myFunction5= Unit1Exercise_methodRefStyle::testPerson; //hier ist wiederum static nötig, weil rückgabewert = Person ungleich
		//aufrufende klasse = Unit1Exercise_methodRefStyle
		
		System.out.println(myFunction3.apply(p10));
		
		
		//oder
		Comparator <Person> comparator4= Comparator.comparing((Person p1) -> p1.getLastName()); //inline overriding apply method
		
		//folglich
		Comparator <Person> comparator5= Comparator.comparing(Person::getLastName);
		
		
		Collections.sort(people,comparator);
				
				
		//step2: create method that prints all elements in list
		printAll(people);
		
		//step3: print all list elements with lastname beginning with H
		//mit lambda style
		//method signatur muss gleich sein wie die abstract method im interface, also (Person p)
		AddCondition condition1= (Person p) -> {
			return p.getLastName().startsWith("H");
		};
		
		printAllWithCondition(people,condition1);
		
		//mit method reference

	}
	
	/*
	 * diese methode überschreibt die compare methode vom interface Comparator
	 * 
	 * Interface Comparator<T>

    	Type Parameters:
        T - the type of objects that may be compared by this comparator 
	 * 
	 *  	compare(T o1, T o2)
			Compares its two arguments for order.
	 * 
	 * --> compare von Comparator gibt int zurück
	 * 
	 * das overriding funktioniert, weil comparePersonObjects genau gleiche methoden signatur hat wie compare von Comparator
	 * 
	 * */
	
	private static int comparePersonObjects(Person a, Person b) {
		return a.getLastName().compareTo(b.getLastName());
	}
	
	private int compare2(Person a, Person b) {
		return a.getLastName().compareTo(b.getLastName());
	}
	
	private String getLastname() {
		return "test";
	}
	
	private static String testPerson(Person p) {
		return "test";
	}

}
