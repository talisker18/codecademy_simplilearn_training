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
		System.out.println("print dog name inside main: "+dogA.getName());
		
		changeDogByReference(dogA);
		System.out.println("print dog name inside main: "+dogA.getName()); //this will still print Fifi value, because java is passing by value only!!!
	}
	
	public static void changeDogByValue(Dog dog) { //dog is NOT a copy of dogA...the method still uses dogA ref var, now called "dog" in this method
		//Therefore, dogA, or in this method dog, is still pointing to the object "Max"
		dog.setName("Fifi value"); //change the value of the object referenced by reference variable "dogA" (or "dog"). this will work, since "dog" is the same ref var as "dogA", just with other name
		System.out.println("print dog name inside method after changing value: "+dog.getName());
	}
	
	public static void changeDogByReference(Dog dog) { //dog is NOT a copy of dogA...the method still uses dogA ref var, now called "dog" in this method
		//Therefore, dogA, or in this method dog, is pointing to the object "Fifi value"
		dog = new Dog(); //still when we use dog ref var, we use dogA ref var as well. So actually, the dogA / dog ref var is pointing now to another Dog object
		dog.setName("Fifi Reference"); //...but since java is not passing by reference, the change on this line wont affect the object on application scope, only on method scope
		System.out.println("print dog name inside method after changing reference: "+dog.getName());
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


