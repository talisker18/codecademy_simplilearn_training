---get employee with highest salary
SELECT employee_name, salary FROM employee WHERE salary = (SELECT MAX(salary) FROM employee);