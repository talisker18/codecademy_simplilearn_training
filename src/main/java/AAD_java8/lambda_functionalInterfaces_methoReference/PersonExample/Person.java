package AAD_java8.lambda_functionalInterfaces_methoReference.PersonExample;

class Person {
	
	private String name;
	private String lastName;
	private int age;
	
	Person(String name, String lastName, int age){
		this.name=name;
		this.lastName=lastName;
		this.age=age;
	}
	
	String getName() {
		return this.name;
		
	}
	
	void setName(String name) {
		this.name=name;
	}
	
	String getLastName() {
		return this.lastName;
	}
	
	void setLastname(String lastName) {
		this.lastName=lastName;
	}
	
	int getAge() {
		return this.age;
	}
	
	void setAge(int age) {
		this.age=age;
	}

}
