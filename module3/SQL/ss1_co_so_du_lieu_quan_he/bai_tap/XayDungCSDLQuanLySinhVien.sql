drop database if exists student_management;
create database if not exists student_management;

use student_management;

create table class (
id int,
`name` varchar(255)
);

create table teacher (
id int,
`name` varchar(255),
age int,
country varchar(255)
);

