---we have following table

---emp_id,name,manager_id
---1,joel,1
---2,timo,5
---3,bruno,1
---4,flo,1
---5,schumi,5


---we want only to print the first letter of joel

select left(name,1) from employee where id=1;

---will print j

---we can also use this in where clause

select * from employee where left(name,1) = j;