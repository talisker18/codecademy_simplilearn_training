---table looks like:
---CustomerID;CustomerName;ContactName;Address;City;PostalCode;Country
---1;Alfreds Futterkiste;Maria Anders;Obere Str. 57;Berlin;12209;Germany
---2;Ana Trujillo Emparedados y helados;Ana Trujillo;Avda. de la Constitución 2222 	México D.F.;05021;Mexico
---3;Antonio Moreno Taquería;Antonio Moreno;Mataderos 2312;México D.F.;05023;Mexico
--- etc

---now we want to count the customers per country and show all countries that have more than 1 customer
---mexico does have 2 customers, germany only 1
---
SELECT COUNT(CustomerID), Country
FROM Customers
GROUP BY Country
HAVING COUNT(CustomerID) > 1;


---it will give back:
---2  	Mexico 