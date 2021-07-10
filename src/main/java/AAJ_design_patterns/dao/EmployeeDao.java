package AAJ_design_patterns.dao;

import java.util.List;

import org.hamcrest.core.IsInstanceOf;

import AAJ_design_patterns.dao.models.Developer;
import AAJ_design_patterns.dao.models.Employee;
import AAJ_design_patterns.dao.models.Tester;

public class EmployeeDao implements IDao<Employee> {

	public Employee getById(int id) {
		//search in data base and return Employee
		Employee emp = new Employee(); //if we use a Dao, we cant make Employee as abstract class!!!
		return emp;
	}

	public List<Employee> getAll() { 
		//do database
		return null;
	}

	public void save(Employee t) {
		String fname = t.getFname();
		//but we can not access programmingLanguage because this is an instance var of developer
		//solution: make check with instanceof
		
		if(t instanceof Developer) {
			//
			Developer dev = (Developer) t;
			String progrLang = dev.getProgrammingLanguage();
		}
		
		if(t instanceof Tester) {
			Tester tester = (Tester) t;
			String testerRole = tester.getTesterRole();
		}
		
		//do database
		
	}

	public void update(Employee t, String[] params) {
		//do database
		
	}

	public void delete(Employee t) {
		//do database
		
	}

}
