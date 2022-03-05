-- (01) Duplikate feststellen, eher lang laufend:
select passage_id
		from "transaction"
	group by passage_id
		having count(*) > 1