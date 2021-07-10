package AAJ_design_patterns.dao;

import AAJ_design_patterns.dao.models.Developer;
import AAJ_design_patterns.dao.models.Tester;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Developer dev1 = new Developer();
		dev1.setProgrammingLanguage("java");
		Tester tester1= new Tester();
		
		EmployeeDao empDao = new EmployeeDao();
		
		empDao.save(dev1);
		empDao.save(tester1);
		
		
		/**but be careful: with EmployeeDao we can e.g. save an Employee
		 * 
		 * in this example we also use specific instance variables for developer and
		 * tester which are not used in Employee class
		 * 
		 * so when saving Employee object to database, we can not access these specific variables
		 * 
		 * solution: check with emp instaceof Developer or Tester -> see EmployeeDao
		 * 
		 * */

	}

}
