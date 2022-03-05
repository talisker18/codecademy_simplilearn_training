--Recursive queries are used to query hierarchical data. The SQL standard defines a special syntax for common table expressions to enable recursive processing.

--Assume the following hierarchical definition of product categories:

create table category
(
   id               integer      not null primary key,
   name             varchar(100) not null,
   parent_category  integer references category
);

---With the following data:

---id | name              | parent_category
---+-------------------+----------------
--- 1 | Root Node         |          (null)
--- 2 | Software          |               1
--- 3 | Hardware          |               1
--- 4 | Notebooks         |               3
--- 5 | Phones            |               3
--- 6 | Applications      |               2
--- 7 | Database Software |               2
--- 8 | Relational DBMS   |               7
--- 9 | Tools             |               7
---10 | Commandline tools |               9
---11 | GUI Tools         |               9
---12 | Android Phones    |               5
---13 | iPhone            |               5
---14 | Windows Phones    |               5

---To (recursively) query all sub-categories for one parent, the following query can be used:

with recursive cat_tree as (
   select id,
          name,
          parent_category
   from category
   where name = 'Database Software'  -- this defines the start of the recursion
   union all
   select child.id,
          child.name,
          child.parent_category
   from category as child
     join cat_tree as parent on parent.id = child.parent_category -- the self join to the CTE builds up the recursion
)
select *
from cat_tree;


---The above query will return the following result: 

---id | name              | parent_category
---+-------------------+----------------
--- 7 | Database Software |               2
--- 8 | Relational DBMS   |               7
--- 9 | Tools             |               7
---10 | Commandline tools |               9
---11 | GUI Tools         |               9
