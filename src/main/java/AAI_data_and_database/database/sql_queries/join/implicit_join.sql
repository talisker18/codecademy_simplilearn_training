---pid is the fk for the person table

select p.firstname, p.lastname, c.value
from person p, contact c

where p.id = c.pid