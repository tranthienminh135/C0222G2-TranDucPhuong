drop database if exists QuanLyBanHang;
create database if not exists QuanLyBanHang;
use QuanLyBanHang;

create table Customer (
c_id int auto_increment,
c_name varchar(255),
c_age int,
primary key (c_id)
);

create table oder (
o_id int auto_increment,
c_id int,
o_date date,
o_total_price double,
primary key (o_id),
foreign key (c_id) references Customer(c_id)
);

create table product (
p_id int auto_increment,
p_name varchar(255),
p_price double,
primary key (p_id)
);

create table oder_detail (
o_id int,
p_id int,
od_quantity int,
foreign key (o_id) references oder(o_id),
foreign key (p_id) references product(p_id)
);