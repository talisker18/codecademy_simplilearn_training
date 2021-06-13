package ZAA_misc;

import org.openjdk.jol.vm.VM;

public class ImmutableStringAndMemoryAllocationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//we need some dependency in pom to get an objects memory adress, see https://www.baeldung.com/java-object-memory-address

		String s = "Joel"; //this generates a new String object with value "Joel". the reference variable s points to that string object
		//the string object "Joel" allocates new memory adress
		
		//print memory address of string object "Joel".
		System.out.println("The memory address is " + VM.current().addressOf(s));
		
		//strings are immutable, so the following statement does not change the string
		s.concat(" Henz");
		System.out.println(s);
		//memory address did not change because we didnt change the string. and s is still pointing to the same string object, hence "Joel"
		System.out.println("The memory address is " + VM.current().addressOf(s));
		
		//with following line, we allocate new memory address for a new string object. the new string object is "Joel Henz". Now the reference variable
		//points to that new object with the new address.
		s = s.concat(" Henz"); //here,
		System.out.println(s);
		
		//again print the memory address. since we have changed the object to which s is pointing (first it was pointing to
		//"Joel", now it is pointing to "Joel Henz"), the memory address changed as well
		System.out.println("The memory address is " + VM.current().addressOf(s));
		
		
		//on contrary, all primitive data types, they are mutable
		

	}

}
