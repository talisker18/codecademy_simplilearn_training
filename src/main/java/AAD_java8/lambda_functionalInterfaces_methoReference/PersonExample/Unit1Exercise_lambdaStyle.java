package AAD_java8.lambda_functionalInterfaces_methoReference.PersonExample;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1Exercise_lambdaStyle{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people = Arrays.asList(
				new Person("Max", "Test",38),
				new Person("Turi", "Ruch",38),
				new Person("Joel","Henz",33),
				new Person("Anita","Henz",63)
				);
		
		//step1: sort list by lastname
		//java8 lambda style
		//
		Comparator <Person> comparator = (Person o1, Person o2) -> o1.getLastName().compareTo(o2.getLastName());
		
		
		
		//////////////////////alternativ auch mit klammern {} , wenn man z.b. ein IF einbauen muss/////////////////////
		/*Comparator <Person> comparator = (Person o1, Person o2) -> {
			if(true) {
				return o1.getLastName().compareTo(o2.getLastName());
			}else {
				return 0;
			}
		};*/
		
		
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
	
	private static void printAll(List<Person> list) {
		for(Person person:list) {
			System.out.println("Vorname: "+person.getName()+"; Nachname: "+person.getLastName()+"; Alter: "+person.getAge()+"\n");
		}
		
	}
	
	private static void printAllWithCondition(List<Person> list, AddCondition condition) {
		for(Person person:list) {
			if(condition.checkCondition(person)) {
				System.out.println("Vorname: "+person.getName()+"; Nachname: "+person.getLastName()+"; Alter: "+person.getAge()+"\n");
			}
			
		}
		
	}
	
	interface AddCondition{
		boolean checkCondition(Person p);
	}

}
