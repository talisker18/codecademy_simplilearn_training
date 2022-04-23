package AAA_core.classes;

/**
 * 
 * see also: src/main/java/AAI_data_and_database/collection_framework/java_util_map_and_subclasses/HashMapCreateDirectly.java
 * 
 * Anonymous classes enable you to make your code more concise. They enable you to declare and instantiate a class 
 * at the same time. They are like local classes except that they do not have a name. Use them if you need to use a 
 * local class only once
 * 
 * */

public class AnonymousClassDemo {

	public static void main(String[] args) {
		
		Person p = new Person() {
			
			{
				add(1); //here we can call the existing methods
				add(2); //another call
			}
			
			//but we can also define complete new class body with new methods...
			public void anotherMethod() {
				System.out.println("anotherMethod() called");
			}
			//...but we cant use this method outside the anonymous class
			
			
			//but we could override existing methods of Person, see AnotherPerson.class
			
		} ;
		
		
		System.out.println(p);
		System.out.println("------------------");
		
		System.out.println("using AnotherPerson.class");
		System.out.println();
		
		AnotherPerson p2 = new AnotherPerson();
		p2.createPerson(3);
		
		//SecondPerson p3 = new SecondPerson(){  --> does not work, we still need an existing type
			
		//};
		
		Person p4 = new Person(){};
		
		//following will not work because String class is final and immutable
		String str = new String() {
			
		};
	}
}

class Person{
	
	private int i;
	
	public Person() {
		
	}
	
	public void add(int i) {
		this.i= i;	
	}
	
	public void doSomething() {
		System.out.println("print from Person");
	}
	
	public int getI() {
		return this.i;
	}

	@Override
	public String toString() {
		return "Person [i=" + i + "]";
	}
}

class AnotherPerson{
	
	public void createPerson(int i){
		
		Person p = new Person() { //anonymous class. this class overrides the existing methods of class Person. its like anonymous class extends Person.class
			
			int i;
			int b; //we could define further fields here
			
			@Override
			public void add(int i) {
				this.i = i+10;
			}
			
			@Override
			public void doSomething() {
				System.out.println("print from another Person");
			}
			
			@Override
			public String toString() {
				return "Person [i=" + i + "]";
			}
			
			//new method. but we cant use this method outside the anonymous class
			public void doSomethingElse() {
				
			}
			
		};
		
		p.doSomething(); //call overridden method
		p.add(i); //call overridden method
		System.out.println(p); //call overridden toString method
		// p.doSomethingElse();  --> but we cannot use this method because its not defined in super class
	}
}
