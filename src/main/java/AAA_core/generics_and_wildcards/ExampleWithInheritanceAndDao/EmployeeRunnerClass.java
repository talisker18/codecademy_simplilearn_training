package AAA_core.generics_and_wildcards.ExampleWithInheritanceAndDao;

public class EmployeeRunnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tester e1 = new Tester();
		e1.setId(1);
		e1.setName("Joel");
		e1.doSpecialStuff("regression testing");
		
		Developer e2 = new Developer();
		e2.setId(2);
		e2.setName("Bruno");
		e2.doSpecialStuff("Java");
		
		EmployeeDAO<Employee> empDao = new EmployeeDAO<Employee>();
		empDao.printEmployee(e1); //prints specific toString() of Tester
		empDao.printEmployee(e2); //prints specific toString() of Developer
		
		

	}

}
