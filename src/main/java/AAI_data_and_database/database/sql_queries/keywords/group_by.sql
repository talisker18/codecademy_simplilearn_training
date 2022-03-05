SELECT Shippers.ShipperName,COUNT(Orders.OrderID) AS NumberOfOrders FROM Orders
LEFT JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID
GROUP BY ShipperName;

---group by ist wie eine art zusammenfassing. query oben liefert dann z.b. folgendes

----ShipperName 			NumberOfOrders
----
----Federal Shipping		68
----Speedy Express			54
----United Package			74


---managerids

select fk_route_id from flights;
+-------------+
| fk_route_id |
+-------------+
|           1 |
|           1 |
|           1 |
|           1 |
|           2 |
|           2 |
|           2 |
|           2 |
|           2 |
|           2 |
|           2 |
|           3 |
|           4 |
|           6 |
+-------------+


---we have duplicates. group by can be used to eliminate duplicates. so in this case its the same like select distinct

---make summary without duplicates of all fk_route_ids
select fk_route_id from flights group by fk_route_id;
+-------------+
| fk_route_id |
+-------------+
|           1 |
|           2 |
|           3 |
|           4 |
|           6 |
+-------------+


---group by is often used to count things. in this case, count how many teams each fk_route_id occurs
select fk_route_id, count(*) from flights group by fk_route_id;
+-------------+----------+
| fk_route_id | count(*) |
+-------------+----------+
|           1 |        4 |
|           2 |        7 |
|           3 |        1 |
|           4 |        1 |
|           6 |        1 |
+-------------+----------+


---we can also group by multiple rows
select * from flights;
+-----------+-----------------+-----------------+---------------------+---------------------+-------------+
| flight_id | price_in_dollar | available_seats | departure_time      | arrival_time        | fk_route_id |
+-----------+-----------------+-----------------+---------------------+---------------------+-------------+
|         1 |            5000 |              98 | 2022-01-09 14:29:30 | 2022-01-09 16:29:30 |           1 |
|         3 |             500 |             100 | 2022-01-10 08:15:30 | 2022-01-10 10:15:30 |           4 |
|         4 |            1000 |             150 | 2022-01-10 08:15:30 | 2022-01-10 18:15:30 |           2 |
|         5 |            1000 |             149 | 2022-01-18 08:15:30 | 2022-01-18 18:15:30 |           3 |
|         6 |             300 |             150 | 2022-01-15 08:15:30 | 2022-01-15 10:15:30 |           1 |
|         9 |            1000 |             149 | 2022-01-15 18:15:30 | 2022-01-16 04:15:30 |           2 |
|        10 |            1000 |             150 | 2022-01-01 18:15:30 | 2022-01-02 04:15:30 |           2 |
|        11 |            1000 |             150 | 2022-01-01 13:15:30 | 2022-01-01 23:15:30 |           2 |
|        12 |            1000 |             150 | 2022-01-01 08:15:30 | 2022-01-01 18:15:30 |           2 |
|        13 |            1000 |             151 | 2022-01-15 04:15:30 | 2022-01-15 14:15:30 |           2 |
|        14 |            1000 |             150 | 2022-01-15 11:15:30 | 2022-01-15 21:15:30 |           2 |
|        15 |             300 |               0 | 2022-01-19 11:15:30 | 2022-01-19 13:15:30 |           6 |
|        19 |             300 |              50 | 2022-01-09 12:30:00 | 2022-01-09 14:30:00 |           1 |
|        20 |             300 |              80 | 2022-01-09 19:30:00 | 2022-01-09 21:30:00 |           1 |
+-----------+-----------------+-----------------+---------------------+---------------------+-------------+

---as you will see for example fk_route_id 1 has 4 rows because there is 1x with price = 5000 and 3x with price = 300 = total 2 rows = total 4 records when select * from flight without grouping

select price_in_dollar, fk_route_id, count(*) from flights group by price_in_dollar, fk_route_id;
+-----------------+-------------+----------+
| price_in_dollar | fk_route_id | count(*) |
+-----------------+-------------+----------+
|            5000 |           1 |        1 |
|             500 |           4 |        1 |
|            1000 |           2 |        7 |
|            1000 |           3 |        1 |
|             300 |           1 |        3 |
|             300 |           6 |        1 |
+-----------------+-------------+----------+

---we can also combine groupings with min or max. Here, count occurences of each fk_route_id + show what is the min and max price per fk_route_id

select fk_route_id, count(*), min(price_in_dollar), max(price_in_dollar) from flights group by fk_route_id;
+-------------+----------+----------------------+----------------------+
| fk_route_id | count(*) | min(price_in_dollar) | max(price_in_dollar) |
+-------------+----------+----------------------+----------------------+
|           1 |        4 |                  300 |                 5000 |
|           2 |        7 |                 1000 |                 1000 |
|           3 |        1 |                 1000 |                 1000 |
|           4 |        1 |                  500 |                  500 |
|           6 |        1 |                  300 |                  300 |
+-------------+----------+----------------------+----------------------+