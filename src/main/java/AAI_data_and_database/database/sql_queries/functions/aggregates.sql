select avg(budget) from project;

---count all rows that contain a value for notes. if there is null, the record is not counted
select count(notes) from person;

---or simply count all. in this way, rows with notes = null are also counted
select count(*) from person;


select sum(budget) from project;

select min(budget) from project;

select max(budget) from project;

---combine with condition
select min(budget) from project where id < 3;