package AAD_java8.streams.training.demo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import AAD_java8.streams.training.demo1.Person.Gender;

/*this shows declarative approach. old style with for loops would be 'imperative'*/

public class DemoFilterSortMatchMaxMinGroup {

	public static void main(String[] args) {
		
		final List<Person> listPerson = Arrays.asList(
				new Person("joel",34, Gender.MALE),
				new Person("joel2",34, Gender.MALE),
				new Person("anita",64, Gender.FEMALE),
				new Person("manfred",63, Gender.MALE),
				new Person("turi",40, Gender.MALE));
		
		//filter and sort
		System.out.println("|||||||||||||filter and sort|||||||||||||");
		final List<Person> filteredAndSorted = listPerson.stream()
			.filter(person -> person.getGender().equals(Gender.MALE)) //filter, takes a Predicate (see below for other way to define Predicate)
			
			/*other way to define predicate, instead of using lambda
			 * 
			 * then we would: .filter(predicate)
			 * 
			 * 
			 * */
			/*Predicate<Person> predicate = new Predicate<Person>() {

				@Override
				public boolean test(Person t) {
					// TODO Auto-generated method stub
					return t.equals(Gender.MALE);
				}
				
			};*/
			
			.sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName).reversed()) //takes a Comparator. comparing() method takes a Java Function. Here we use method reference, sorting persons first by age, then by name. At the end we reverse the order
			
			.collect(Collectors.toList());
		
		filteredAndSorted.forEach(System.out::println);
		
		System.out.println("---------------");
		
		//check if all people are younger than 70 years, using allMatch()
		System.out.println("|||||||||||||all match|||||||||||||");
		
		final boolean allPeopleAreYoungerThanSeventy = listPerson.stream()
				.allMatch(person -> person.getAge() < 70);
		
		System.out.println(allPeopleAreYoungerThanSeventy);
		
		System.out.println("---------------");
		
		//check if at least one person is older than 60
		System.out.println("|||||||||||||any match|||||||||||||");
		final boolean anyPeopleIsOlderThanSixty = listPerson.stream()
				.anyMatch(person -> person.getAge() > 60);
		
		System.out.println(anyPeopleIsOlderThanSixty);
		
		System.out.println("---------------");
		
		//check if no one is older than 70
		System.out.println("|||||||||||||no match|||||||||||||");
		final boolean noneIsOlderThanSeventy = listPerson.stream()
				.noneMatch(person -> person.getAge() > 70);
		
		System.out.println(noneIsOlderThanSeventy);
		
		System.out.println("---------------");
		
		//get person with max age. max() returns Optional because it is possible that there is no person with max age (all have same age)
		System.out.println("|||||||||||||print max age Person|||||||||||||");
		listPerson.stream()
				.max(Comparator.comparing(Person::getAge)) //lambda would be: 
				.ifPresent(person -> System.out.println(person)); //ifPresent takes Consumer...we could also use method reference here
		
		System.out.println("---------------");
		
		//group information based on a field
		System.out.println("|||||||||||||grouping information: create a Map by Gender|||||||||||||");
		final Map<Gender, List<Person>> mapByGender = listPerson.stream()
			.collect(Collectors.groupingBy(Person::getGender)); //returns a Map<Gender, List<Person>...for each Gender we have a key in the map. For each key we have a value in form of a Person list
		
		//lambda style of preceeding would be...
		final Map<Gender, List<Person>> mapByGender2 = listPerson.stream()
				.collect(Collectors.groupingBy(person -> person.getGender())); //the returning result R of Function is 'Person.Gender' in this case, the input T is 'Person'
		
		 
		mapByGender.forEach(new BiConsumer<Gender, List<Person>>() {

			@Override
			public void accept(Gender gender, List<Person> listOfPerson) {
				System.out.println(gender);
				
				listOfPerson.forEach(System.out::println);
			}
		});
		
		System.out.println("---------------");
		
		//lambda style for BiConsumer
		mapByGender.forEach((gender, listOfPerson) -> {
			System.out.println(gender);
			
			listOfPerson.forEach(System.out::println);
		});
		
		System.out.println("---------------");
		System.out.println("|||||||||||||get the name of the oldest person who is male|||||||||||||");
		//get the name of the oldest person who is male
		Optional<String> name = listPerson.stream()
				.filter(person -> person.getGender().equals(Gender.MALE))
				.max(Comparator.comparing(new Function<Person, Integer>() {

					@Override
					public Integer apply(Person t) {
						// TODO Auto-generated method stub
						return t.getAge();
					}
				}))
				.map(person -> person.getName());
		
		//lambda style
		Optional<String> name2 = listPerson.stream()
				.filter(person -> person.getGender().equals(Gender.MALE))
				.max(Comparator.comparing(p -> p.getAge()))
				.map(person -> person.getName());
		
		System.out.println(name.get());
	}

}
