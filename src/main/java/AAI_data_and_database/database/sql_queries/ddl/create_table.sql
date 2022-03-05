create table if not exists myperson(

id int(11) not null auto_increment,
dob date default null,
created_at timestamp not null default current_timestamp,
primary key(id)

);