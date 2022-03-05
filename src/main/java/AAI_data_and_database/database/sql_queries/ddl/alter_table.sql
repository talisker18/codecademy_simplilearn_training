---often used to add constraints- be careful with this ddl operation

---adds new columns in mycontact table, called fk_person_id and fk_contacttype_id
alter table mycontact
add constraint 'name_of_constraint' foreign key ('fk_person_id') references 'person' ('id'),
add constraint 'name_of_constraint' foreign key ('fk_contacttype_id') references 'contacttype' ('id'),