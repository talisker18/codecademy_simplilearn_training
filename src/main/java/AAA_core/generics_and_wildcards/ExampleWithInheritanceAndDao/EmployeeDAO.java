package AAA_core.generics_and_wildcards.ExampleWithInheritanceAndDao;

public class EmployeeDAO<T extends Employee> { //only instances of types are allowed that extend Employee. Additionally,
	//all instances of classes are allowed that are super of Employee, namely Object
	
	void printEmployee(T t) {
		System.out.println(t.toString()); //for this, we need to override the toString() method in Tester and Developer class
	}
	
	void saveInDataBase(T t) {
		//save in database
	}
	
	
	/**
	 * alternatively we could simply use Employee as parameters instead of T
	 * 
	 * void printEmployee(Employee t) {
		System.out.println(t.toString());
	}
	
	void saveInDataBase(Employee t) {
		//save in database
	}
	 * 
	 * */
	
	
	/**
	 * i think that generic types are rather used in single methods
	 * 
	 * */
	
}
