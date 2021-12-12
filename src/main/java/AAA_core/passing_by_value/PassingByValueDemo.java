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
		dogA.setName("Max"); //dogA reference is pointing to Dog obj with name = Max

		changeDogByValue(dogA); //pass the Dog obj with name Max to the method
		
		System.out.println("print dog name inside main: "+dogA.getName());
		
		changeDogByReference(dogA); //pass the Dog obj with name 'Fifi value' to the method
		System.out.println("print dog name inside main: "+dogA.getName()); //this will still print Fifi value, because java is passing by value only!!!
	}
	
	public static void changeDogByValue(Dog dog) { //here, a new reference called 'dog' is made and is pointing now to Dog obj Max. Reference 'dog' is an alias to reference 'dogA'. But, 'dog' ref only lives inside this method
		dog.setName("Fifi value"); //change the name of Dog obj from Max to Fifi value.
		System.out.println("print dog name inside method after changing value: "+dog.getName());
	}
	
	public static void changeDogByReference(Dog dog) { //here, a new reference called 'dog' is made and is pointing now to Dog obj 'Fifi value'. Reference 'dog' is an alias to reference 'dogA'. But, 'dog' ref only lives inside this method
		dog = new Dog(); //let 'dog' point to another Dog obj. 'dog' and 'dogA' are no longer aliases
		dog.setName("Fifi Reference"); //this does not affect Dog obj 'Fifi value' because 'dog' is no longer pointing to the Dog obj 'Fifi value'
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


