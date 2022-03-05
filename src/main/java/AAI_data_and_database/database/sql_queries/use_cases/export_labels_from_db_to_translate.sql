---get labels from different tables because we have to translate them

select * from role
union
select * from conttacttype;

---1, Product Manager
---2, Project Manager
---1, Email
---2, Phone