---The UNION command combines the result set of two or more SELECT statements (only distinct values)

---The following SQL statement returns the cities (only distinct values) from both the "Customers" and the "Suppliers" table:

---conditions: each select must return the same columns

SELECT City FROM Customers
UNION
SELECT City FROM Suppliers
ORDER BY City;

---The UNION operator selects only distinct values by default. To allow duplicate values, use UNION ALL:

SELECT City FROM Customers
UNION ALL
SELECT City FROM Suppliers
ORDER BY City;

---example result

---City
--Aachen 
--Albuquerque 
--Anchorage 
--Ann Arbor 
--Annecy 
--Århus 
--Barcelona 
--Barquisimeto 
--Bend 
--Bergamo 
--Berlin 
--Berlin 