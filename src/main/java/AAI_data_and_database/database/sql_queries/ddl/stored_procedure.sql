delimiter @@
create procedure projectteam (p_projectname text) ---param p_projectname as text datatype
begin
	select .... from project pr
	where pr.label = p_projectname ---param
end ;
@@
delimiter;

---exec procedure
call projectteam('facebook'); ---arg

---delete proc
drop projectteam;