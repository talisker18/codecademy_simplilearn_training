--------sql join table with same table.

---we have following table

---emp_id,name,manager_id
---1,joel,1
---2,timo,5
---3,bruno,1
---4,flo,1
---5,schumi,5


--here, search all employees which are not managers (<> means is not equal to any...see sql operators)
--- so we have can find them by checking if their emp_id is not equal to their manager_id, because all managers emp_id equal to their manager_id
---joel and schumi are managers because emp_id = manager_id

--use distinct to eliminate duplicated


SELECT DISTINCT E1.employee_id, E1.first_name, E1.last_name FROM employees E1, employees E2 WHERE E1.employee_ID <> E2.manager_id;