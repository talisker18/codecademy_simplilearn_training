package AAD_java8.lambda_functionalInterfaces_methoReference.PersonExample;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Unit1Excersice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Person> people = Arrays.asList(
				new Person("Max", "Test",38),
				new Person("Turi", "Ruch",38),
				new Person("Joel","Henz",33),
				new Person("Anita","Henz",63)
				);
		
		//step1: sort list by lastname
		//inline implementation java 7
		Collections.sort(people,new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		
				
		//step2: create method that prints all elements in list
		printAll(people);
		
		//step3: print all list elements with lastname beginning with H
		//inline implementation of interface
		printAllBeginningWith(people, new Condition() {
			
			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("H");
			}
		});

	}
	
	//Condition ist hier ein selbst gebautes interface
	private static void printAllBeginningWith(List<Person> people, Condition condition) {
		for(Person person:people) {
			if(condition.test(person)) {
				System.out.println("Vorname: "+person.getName()+"; Nachname: "+person.getLastName()+"; Alter: "+person.getAge()+"\n");
			}
		}
		
	}

	//muss static sein weil aufruf in der main methode (obwohl wir in der selben klasse sind)
	//private macht sinn, weil innerhalb der gleichen klasse
	private static void printAll(List<Person> list) {
		for(Person person:list) {
			System.out.println("Vorname: "+person.getName()+"; Nachname: "+person.getLastName()+"; Alter: "+person.getAge()+"\n");
		}
		
	}
	
	interface Condition{
		boolean test(Person p);
	}

}
