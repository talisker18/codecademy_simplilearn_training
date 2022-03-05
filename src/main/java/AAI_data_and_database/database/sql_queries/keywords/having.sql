-- (01) Duplikate feststellen, eher lang laufend:
select passage_id
		from "transaction"
	group by passage_id
		having count(*) > 1
		
---some other example
select managerid, count(*) as counter from person group by managerid 
having managerid is not null
AND counter > 1;