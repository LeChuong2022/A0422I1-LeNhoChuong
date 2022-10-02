create database `student-management`;
create table `student-management`.`student`(
`id` int,
`name` varchar(255),
`age` int,
`address` varchar(255),
primary key (`id`)
);
select * from `student-management`.`student`;

create table `student-management`.`class`(
`id` int,
`name` varchar(255)
);

create table `student-management`.`teacher`(
`id` int,
`name` varchar(255),
`age` int,
`address` varchar(255)
);