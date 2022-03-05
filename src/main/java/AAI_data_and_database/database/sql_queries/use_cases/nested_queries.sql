-- (RESULT-01) Duplikate feststellen, eher lang laufend:
select passage_id
		from "transaction"
	group by passage_id
		having count(*) > 1
		

-- (RESULT-02) Id der zu löschenden Einträge feststellen:
select max(id) from "transaction" where passage_id in ([RESULT-01])
-- (RESULT-03) Eine der duplizierten einträge löschen nach passage_id
delete * from "transaction" where passage_id in ([RESULT-02])
-- (RESULT-04) Als check 01 wiederholen
-- (RESULT-05)  01-04 wiederholen Analog für Tabelle additional_data 



---replacing RESULT-0x

-- (RESULT-01) Duplikate feststellen, eher lang laufend:
select passage_id
		from "transaction"
	group by passage_id
		having count(*) > 1
		

-- (RESULT-02) Id der zu löschenden Einträge feststellen:
select max(id) from "transaction" where passage_id in (

			select passage_id
					from "transaction"
				group by passage_id
					having count(*) > 1

)


---etc
