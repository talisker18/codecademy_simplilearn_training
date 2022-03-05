--------sql join table with same table.


--here, search all employees which are not managers (<> means is not equal to any...see sql operators)

--use distinct to eliminate duplicated


SELECT DISTINCT E1.employee_id, E1.first_name, E1.last_name FROM employees E1, employees E2 WHERE E1.employee_ID <> E2.manager_id;