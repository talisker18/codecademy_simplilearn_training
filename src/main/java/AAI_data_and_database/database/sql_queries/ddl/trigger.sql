delimiter @@
create trigger setmodified before update on person --- setmodified = name of trigger; when choosing 'before': do the trigger change BEFORE the actual update
for each row begin
	set new.modified_date=now(); ---we can access new and old value. here we set the new value with new. keyword
end;
@@
delimiter;

---drop
drop setmodified;



---another example

---Given Student Report Database, in which student assessment points are recorded. each row is a Student. and there are 3 tests for each student.

---when all 3 tests are done by a student, a new record is inserted for that student

---In such schema, create a trigger so that the total of assessment points is automatically updated whenever a record is inserted.

---Here, as trigger will invoke before record is inserted so, BEFORE Tag can be used.

create trigger stud_marks 
before INSERT 
on 
Student 
for each row 
set Student.total = Student.test1 + Student.test2 + Student.test3, Student.average = Student.total / 3;

---example insert
insert into Student values(1, "Joel", 20, 20, 20, 0, 0); 

---then select this student
+-----+-------+-------+-------+-------+-------+----------+ 
| id  | name  | test1 | test2 | test3 | total | average  | 
+-----+-------+-------+-------+-------+-------+----------+ 
| 1   | Joel  |    20 |    20 |    20 |    60 |   20     | 
+-----+-------+-------+-------+-------+-------+----------+ 

---total and average are calculated with the help of the trigger BEFORE the actual insert is done
