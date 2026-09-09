create database if  not exists m3_c0316m1;
use m3_c0316m1;
create table james (
username varchar(50) primary key,
password varchar(50)
);
create table classes(
 id int primary key auto_increment,
 name varchar(20)
);
create table students (
 id int primary key auto_increment,
 `name` varchar(50),
 gender boolean,
 birthday date,
 score float,
 class_id int,
 `username` varchar(20),
 foreign key(`username`) references james(username),
 foreign key(class_id) references classes(id)
);
create table phones (
 phone_number varchar(20) primary key,
 student_id int,
 foreign key(student_id) references students(id)
);
create table instructors (
 id int primary key auto_increment,
 `name` varchar(50),
 birthday date,
 salary double
 );
 
 create table instructors_classes (
   class_id int,
   instructor_id int,
   primary key (class_id,instructor_id),
   start_time date,
   end_time date,
   foreign key(class_id) references classes(id),
    foreign key(instructor_id) references instructors(id)
 );

insert into classes (name) values ('c1121g1'), ('c1221g1'),('a0821i1'),('a0921i1');


insert into james(`username`,`password`)
 values('cunn','12345'),('chunglh','12345'),('hoanhh','12345'),('dungd','12345'),('huynhtd','12345'),
 ('hainm','12345'),('namtv','12345'),('hieuvm','12345'),('kynx','12345'),('vulm','12345');

insert into james(`username`,`password`)
 values('chau','12345');
 
insert into instructors(`name`,birthday, salary)
 values('tran van chanh','1985-02-03',100),('tran minh chien','1985-02-03',200),('vu thanh tien','1985-02-03',300);
insert into instructors(`name`,birthday, salary)
 values('tran van nam','1989-12-12',100);


 
 insert into students(`name`,birthday, gender,`score`, class_id,`username`) 
 values ('nguyen ngoc cu','1981-12-12',1,8,1,'cunn'),('le hai chung','1981-12-12',1,5,1,'chunglh'),
 ('hoang huu hoan','1990-12-12',1,6,2,'hoanhh'),('dau dung','1987-12-12',1,8,1,'dungd'),
 ('ta dinh huynh','1981-12-12',1,7,2,'huynhtd'),('nguyen minh hai','1987-12-12',1,9,1,'hainm'),
 ('tran van nam','1989-12-12',1,4,2,'namtv'),('vo minh hieu','1981-12-12',1,3,1,'hieuvm'),
 ('le xuan ky','1981-12-12',1,7,2,'kynx'),('le minh vu','1981-12-12',1,7,1,'vulm');

  insert into students(`name`,birthday, gender,`score`, class_id) 
 values ('nguyen van a','1981-12-12',1,8,null),('tran van b','1981-12-12',1,5,null);
 
--   insert into student(`name`,birthday, gender,`point`, class_id,`username`) 
--  values ('nguyen minh hai chau','1981-12-12',1,8,null,'chau');
 insert into phones(phone_number,student_id) values ('0938305879',1),('0938305878',1),('0938305877',2),('0938305876',3),('0938305875',3),('0938305874',3);

 insert into instructors_classes(class_id,instructor_id) values (1,1),(1,2),(2,1),(2,2),(3,1),(3,2);

select * from phones;
select* from classes;
select* from students;
select* from james;
select* from instructors;
select * from instructors_classes;

-- ss3 thao tác với csdl


-- 1. Lấy ra thông tin các học viên đã có lớp học, và cho biết các học viên đang theo học lớp nào.
select s.*,c.name as class_name from students s join classes c on s.class_id = c.id;
-- 2. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào 
-- và cả các bạn đã đăng ký nhưng chưa có lớp học.
select s.*,ifnull(c.name, "chưa có lớp") as class_name from students s left join classes c on s.class_id = c.id;
-- 3. Lấy ra học viên có họ là “nguyen”

select * from students where name like 'nguyen %';

-- 4. Lấy thông tin của các học viên tên 'nguyen minh hai'.
select * from students where name ='nguyen minh hai';

-- 5. Lấy thông tin của các học viên tên 'hai' hoặc 'huynh’.
select * from students where name like '% hai' or name like '% huynh';

-- RegexP : tìm hiểu thêm( lấy ra học vien có Tên bắt đầu Bằng chữ H

-- 6. Lấy ra các học viên có điểm lớn hơn 5 .
select * from students s where s.score>5;

-- đếm số lương học viên của trung tâm
-- select count(id) as so_luong from students;
-- lấy ra các loại điểm duy nhất

 select distinct s.score from students s;

-- 8. Thông kế số lượng học sinh theo từng loại điểm.
 select s.score, count(s.id) from students s group by s.score;

-- 9 . Thông kế số lượng học sinh theo điểm và điểm phải lớn hơn 5
 select s.score, count(s.id) from students s where s.score>5 group by s.score;
-- 10. Thông kế số lượng học sinh theo điểm lớn hơn 5 và chỉ hiện thị với số lượng>=2

select s.score, count(s.id) as sl from students s where s.score>5  group by s.score having count(s.id)>2;

-- 11. Lấy ra danh sách học viên của lớp c1121g1 và sắp xếp  học viên theo score giảm dần,
-- nếu score bằng nhau thì sắp xếp theo tên tăng dần.

select s.*,c.name as class_name from students s  join classes c on s.class_id = c.id where c.name ="c1121g1"
order by s.score desc, s.name asc
;

