---gets result if the lastname starts with Hen
select * from person where lastname like 'Hen%';

---gets result if lastname starts with any letter, then en...e.g. Henz, Benz ...
select * from person where lastname like '_en%';