---syntax depends on DBMS
start transaction;

updat person set dob = '1967-08-09' where id=6;

---either rollback or commit

rollback;
commit;

---if commit is not done, another instance of the DBMS will not show the updated record. one can test this by closing the mysql CL client

---but the instance that has started the transaction will see the update without commit

start transaction;

update routes set destination = 'Basel' where route_id = 12;

commit;