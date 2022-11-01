create database ss12_practice;
use ss12_practice;

drop table users;

create table users(
id int(3) not null auto_increment,
name varchar(120) not null,
email varchar(220) not null,
country varchar(120),
primary key (id)
);

insert into users(name, email, country) values ('Minh', 'minh@codegym.vn', 'Viet Nam');
insert into users(name, email, country) values ('Kante', 'kante@che.uk', 'Kenia');

select * from users where country = 'Viet Nam';

select * from users order by id desc;
select * from users order by name asc;

ALTER USER "root"@"localhost" IDENTIFIED BY "CodegymMySQL";
