package AAB_inheritance_and_polymorphism.multiple_inheritance;

public class Dog implements Pet, Animal {

	@Override
	//here it doesnt matter if both parent classes have the exact same abstract method (return type, name and params)
	//because child class does implement just 1 method called void doSomething()
	public void doSomething() {
		// TODO Auto-generated method stub
		
	}
	
	

}
