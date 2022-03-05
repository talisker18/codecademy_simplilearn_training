---we have following table

---emp_id,name,manager_id,dob
---1,joel,1,1987-09-16
---2,timo,5
---3,bruno,1
---4,flo,1
---5,schumi,5


select year(dob) from employee where id=1;

select month(dob) from employee where id=1;

select round(datediff(now(),dob)/365) from employee where id=1; ---get age (depending on DBMS)


