--In SQL, a view is a virtual table based on the result-set of an SQL statement.

--A view contains rows and columns, just like a real table. The fields in a view are fields from one or more real tables in the database.


CREATE VIEW [Brazil Customers] AS
SELECT CustomerName, ContactName
FROM Customers
WHERE Country = 'Brazil';


--We can query the view above as follows:

SELECT * FROM [Brazil Customers]; 


--A view can be updated with the CREATE OR REPLACE VIEW statement.

--The following SQL adds the "City" column to the "Brazil Customers" view:

CREATE OR REPLACE VIEW [Brazil Customers] AS
SELECT CustomerName, ContactName, City
FROM Customers
WHERE Country = 'Brazil';

---or delete the view with drop

drop Brazil Customers;