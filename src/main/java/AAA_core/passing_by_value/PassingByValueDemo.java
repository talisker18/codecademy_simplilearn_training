package AAA_core.passing_by_value;

//Java is always pass-by-value!!!!!!!!!!!!! it means: when passing a [reference variable of an object] to a method, inside that method only the values
//of the corresponding object can be changed, not the object itself

/*
 * In pass by value, the value of a function parameter is copied to another location of the memory. 
 * When accessing or modifying the variable within the function, it accesses only the copy. Thus, there is no effect on the original value.
 * */


/*
 * In pass by value, the changes made inside the function are not reflected in the original value. 
 * On the other hand, in pass by reference, the changes made inside the function are reflected in the original value. 
 * Hence, this is another difference between pass by value and pass by reference.
 * 
 * */

public class PassingByValueDemo {
	
	public static void main(String[] args) {
		Dog dogA = new Dog();
		dogA.setName("Max");
		
		//now pass the dogA reference variable as argument to the changeDog() method.
		changeDogByValue(dogA);
		
		//this will print Fifi, because we changed the VALUE "name" of the Dog instance, not the Dog reference itself
		System.out.println(dogA.getName());
		
		changeDogByReference(dogA);
		System.out.println(dogA.getName()); //this will still print Fifi value, because java is passing by value only!!!
	}
	
	public static void changeDogByValue(Dog dog) { //dog is a copy of dogA. Therefore, both reference variables are pointing to the same object with getName = "Max"
		dog.setName("Fifi value"); //change the value of the object referenced by reference variable "dogA". this will work, since "dog" is pointing to the same object
	}
	
	public static void changeDogByReference(Dog dog) { //dog is a copy of dogA. Therefore, both reference variables are pointing to the same object with getName = "Fifi value"
		dog = new Dog(); //since dog is pointing to same object as dogA, this new assignment should work. However this new assignment wont affect the dogA reference since java IS NOT PASSING BY REFERENCE
		//it will affect only the copy "dog"
		dog.setName("Fifi Reference"); //this will affect only the copy "dog", not the original dogA
	}
}

class Dog{
	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String str) {
		this.name = str;
	}
}


