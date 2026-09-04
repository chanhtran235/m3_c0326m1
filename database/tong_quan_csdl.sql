create database if not exists c0326m1;
use c0326m1;
create table students(
id int primary key auto_increment ,
name varchar(50)
);

alter table students add primary key(id);


insert into students(id,name)values (1,"chanh");
insert into students(id,name) values (2,"chanh"),(3,"chanh"),(4,"chanh"),(5,"chanh");
insert into students(name)values ("chanh");
select * from students;
drop table students;

update students set name ='chanh2' where id =2;
delete from students where id =1;
drop database c0326m1;
