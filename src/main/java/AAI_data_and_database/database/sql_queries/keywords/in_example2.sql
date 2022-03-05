---suppose we have a tables with routes and a table with flights. a route can be added to a flight via fk
---now we want to get all routes that are added at least once to any flight (there are routes that are not used)
select * from routes where route_id IN (select fk_route_id from flights);

---when using IN, we only can use one column, in this case fk_route_id
---this query will return e.g. 6 records. total records in route table are e.g. 10, meaning that 4 routes are not added yet to any flight