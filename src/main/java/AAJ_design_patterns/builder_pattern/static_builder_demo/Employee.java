package AAJ_design_patterns.builder_pattern.static_builder_demo;

/**
 * see https://dzone.com/articles/design-patterns-the-builder-pattern for motivation of this pattern
 * 
 * 
 *  there is Builder pattern to ensure the thread-safety and atomicity of object creation.
 *  
 *  Typically the builder pattern is implemented by an class which has several methods to configure the product. 
 *  
 *  These methods typically return the builder object. This allows to use the builder via a fluent API, e.g, 
 *  by calling methods directly after each other. -> see also /codecademy_simplilearn_training/src/main/java/AAA_core/methods_and_constructors/chaining/ChainedMethodCallDemo.java
 *  
 *  Once the product is completely configured a build() method is called to construct the object.
 * 
 * */

public class Employee {

	//here, vars are not initialised with values, so we can put final...but we have to init them in constructor, see also: /codecademy_simplilearn_training/src/main/java/AAA_core/keywords/FinalKeyWordDemo.java
    private final String firstName;
    private final String lastName;
    private final int startTime;
    private final int endTime;
    private final String department;

    private Employee(String firstName, String lastName, int startTime, int endTime, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.department = department;
    }
    
    @Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", startTime=" + startTime + ", endTime="
				+ endTime + ", department=" + department + "]";
	}

	public static class Builder {

        private String firstName;
        private String lastName;
        private int startTime;
        private int endTime;
        private String department;
        
        //constructor of Builder. Here we can also give a param
        
        public Builder(String firstName) {
        	this.firstName = firstName;
        }

        /*
         * not needed because we initialise firstName with constructor
         * 
         * public Builder withName(String firstName) {
            this.firstName = firstName;
            return this;
        }*/

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withStartTime(int startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder withEndTime(int endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder withDepartment(String department) {
            this.department = department;
            return this;
        }

        public Employee build() {
            return new Employee(this.firstName, this.lastName, this.startTime, this.endTime, this.department); // we are using the initialised instance vars of Builder instance to create new Employee
        }
    }
    
    public static void main(String[] args) {
    	//we can chain method calls because we return Builder instance everytime...see also: /codecademy_simplilearn_training/src/main/java/AAA_core/methods_and_constructors/chaining/ChainedMethodCallDemo.java
		Employee e1 = new Employee.Builder("Joel")
				.withLastName("Henz")
				.withDepartment("testing")
				.withStartTime(0)
				.withEndTime(10)
				.build();
		
		System.out.println(e1.toString());
				
	}
}
