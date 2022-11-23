create database CaseStudy_Furama_E;

create table CaseStudy_Furama_E.`position`(
position_id int primary key auto_increment,
position_name varchar(45)
);

create table CaseStudy_Furama_E.education_degree(
education_degree_id int primary key auto_increment,
education_degree_name varchar(45)
);

create table CaseStudy_Furama_E.division(
division_id int primary key auto_increment,
division_name varchar(45)
);

create table CaseStudy_Furama_E.`user`(
username varchar(255) primary key,
`password` varchar(255)
);

create table CaseStudy_Furama_E.`role`(
role_id int primary key auto_increment,
role_name varchar(255)
);

create table CaseStudy_Furama_E.user_role(
role_id int not null auto_increment,
username varchar(255) not null,
foreign key (role_id) references CaseStudy_Furama_E.`role`(role_id),
foreign key (username) references CaseStudy_Furama_E.`user`(username)
);

create table CaseStudy_Furama_E.employee(
employee_id int primary key auto_increment,
employee_name varchar(45) not null,
employee_birthday date not null,
employee_id_card varchar(45) not null,
employee_salary double not null,
employee_phone varchar(45) not null,
employee_email varchar(45),
employee_address varchar(45),
position_id int not null,
education_degree_id int not null,
division_id int not null,
username varchar(255),
foreign key (position_id) references casestudy_furama_e.`position`(position_id),
foreign key (education_degree_id) references casestudy_furama_e.education_degree(education_degree_id),
foreign key (division_id) references casestudy_furama_e.division(division_id),
foreign key (username) references casestudy_furama_e.`user`(username)
);

create table CaseStudy_Furama_E.customer_type(
customer_type_id int primary key auto_increment,
customer_type_name varchar(45)
);

create table CaseStudy_Furama_E.customer(
customer_id int primary key auto_increment,
customer_type_id int not null,
customer_name varchar(45) not null,
customer_birthday date not null,
customer_gender bit(10) not null,
customer_id_card varchar(45) not null,
customer_phone varchar(45) not null,
customer_email varchar(45),
customer_address varchar(45),
foreign key (customer_type_id) references casestudy_furama_e.customer_type (customer_type_id)
);

create table casestudy_furama_e.service_type(
service_type_id int primary key auto_increment,
service_type_name varchar(45)
);

create table casestudy_furama_e.rent_type(
rent_type_id int primary key auto_increment,
rent_type_name varchar(45),
rent_type_cost double
);

create table casestudy_furama_e.service(
service_id int primary key auto_increment,
service_name varchar(45) not null,
service_area int,
service_cost double not null,
service_max_people int,
rent_type_id int not null,
service_type_id int not null,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int,
foreign key (rent_type_id) references casestudy_furama_e.rent_type (rent_type_id),
foreign key (service_type_id) references casestudy_furama_e.service_type (service_type_id)
);

create table casestudy_furama_e.attach_service(
attach_service_id int primary key auto_increment,
attach_service_name varchar(45) not null,
attach_service_cost double not null,
attach_service_unit int not null,
attach_service_status varchar(45)
);


create table casestudy_furama_e.contract(
contract_id int primary key auto_increment, 
contract_start_date datetime not null,
contract_end_date datetime not null,
contract_deposit double not null,
contract_total_money double not null,
employee_id int  not null,
customer_id int not null,
service_id int not null,
foreign key (employee_id) references casestudy_furama_e.employee (employee_id),
foreign key (customer_id) references casestudy_furama_e.customer (customer_id),
foreign key (service_id) references casestudy_furama_e.service (service_id)
);


create table casestudy_furama_e.contract_detail(
contract_detail_id int primary key auto_increment,
contract_id int not null,
attach_service_id int not null,
quantity int not null,
foreign key (contract_id) references casestudy_furama_e.contract(contract_id),
foreign key (attach_service_id) references casestudy_furama_e.attach_service(attach_service_id)
);



-- -------------------------



	

