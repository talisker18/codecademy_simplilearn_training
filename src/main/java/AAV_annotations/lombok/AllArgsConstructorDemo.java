package AAV_annotations.lombok;

import lombok.AllArgsConstructor;

public class AllArgsConstructorDemo {

	public static void main(String[] args) {
		Person p = new Person("joel","henz");
		System.out.println(p);
	}
}

@AllArgsConstructor
class Person{
	String firstName;
	String lastName;
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
