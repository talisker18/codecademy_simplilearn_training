UPDATE public.passage
SET invalidation_date_time='2020-10-22 12:29:28.311338'
WHERE passage.passage_id IN (

    SELECT public.passage.passage_id
    FROM public.passage
    WHERE  passage.invalid = 'true'
    LIMIT 2
    );
    
---
    
select * from person where lastname in ('Palmer','James');