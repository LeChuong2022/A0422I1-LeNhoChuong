create database `student-management`;
create table `student-management`.`student`(
`id` int,
`name` varchar(255),
`age` int,
`address` varchar(255),
primary key (`id`)
);
select * from `student-management`.`student`;
