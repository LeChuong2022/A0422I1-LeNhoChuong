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

-- định nghĩa stored procedures get_user_by_id
DELIMITER $$
create procedure get_user_by_id(IN user_id INT)
begin
select users.name, users.email, users.country
from users
where users.id = user_id;
end $$
DELIMITER ;

call get_user_by_id(6);

-- định nghĩa stored procedures insert_user
DELIMITER $$
create procedure insert_user(
in user_name varchar(50),
in user_email varchar(50),
in user_country varchar(50)
)
begin
insert into users(name, email, country) values (user_name, user_email, user_country);
end$$
DELIMITER ;

call insert_user('thao', 'thao@gmail.com', 'China');


select * from users where country = 'Viet Nam';

select * from users order by id desc;
select * from users order by name asc;

ALTER USER "root"@"localhost" IDENTIFIED BY "CodegymMySQL";
