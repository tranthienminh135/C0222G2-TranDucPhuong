drop database if exists my_database;
create database if not exists my_database;
use my_database;
create table if not exists customers (
id int,
`name` varchar(255),
primary key (id)
);
insert into customers (id, `name`)
values (1,'phuong'),(2,'hau'),(3,'luan'),(4,'tai');