---we have following table

---emp_id,name,manager_id
---1,joel,1
---2,timo,5
---3,bruno,1
---4,flo,1
---5,schumi,5

select substr(name,1,2) from employee where id=1;

---will print jo