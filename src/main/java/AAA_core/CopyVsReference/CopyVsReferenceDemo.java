package AAA_core.CopyVsReference;

/*
 * if we pass a primitive data type to a method, the method creates a copy of this value
 * 
 * but if we pass a non primitive data type, the method will not create a copy. It uses the same reference variable to work with
 * 
 * */

public class CopyVsReferenceDemo {
	
	public static void main(String[] args) {
		int a = 5;
		
		int b = passPrimitiveDataType(a); //passPrimitiveDataType() returns a copy of "a" modified and assigns that copy to int b
		
		System.out.println(b);
		
		A aObject = new A(5);
		
		A bObject = passObjectA(aObject); //passObjectA() returns the same (but changed) reference variable like we have passed when calling the method
		//we assign that returned reference variable to another A object. now both, aObject and bObject are pointing to the same object containing age = 15
		
		System.out.println(aObject == bObject); //true, since both reference variables are pointing to same object
		
		//...you can see this as well when printing both reference variables. it will be printed their objects memory address, which is equal
		System.out.println(aObject);
		System.out.println(bObject);
		
		
	}
	
	
	public static int passPrimitiveDataType(int aCopy) { //method will make a copy of ["a" = 5 in the main method]
		aCopy = aCopy+10; //assign a new value to that copy
		return aCopy; //return the copy
	}
	
	public static A passObjectA(A a) { //the method does not create a copy but it uses the reference variable "aObject"
		a.age = a.age+10; //change value of aObject
		return a;
	}
	
	

}

class A{
	int age;
	
	public A(int age) {
		this.age=age;
	}
}
