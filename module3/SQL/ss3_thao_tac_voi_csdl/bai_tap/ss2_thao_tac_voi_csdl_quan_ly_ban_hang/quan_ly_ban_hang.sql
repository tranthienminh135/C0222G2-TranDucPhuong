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

insert into customer
value(1,'Minh Quan',10),(2,'Ngoc Oanh',20),(3,'Hong Ha',50);
insert into oder
value(1,1,'2006-3-21',null),(2,2,'2006-3-23',null),(3,1,'2006-3-16',null);
insert into product
value(1,'May Giat',3),(2,'Tu Lanh',5),(3,'Dieu Hoa',7),(4,'Quat',1),(5,'Bep Dien',2);
insert into oder_detail
value(1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);

select oder.o_id, oder.o_date, product.p_price from oder
join oder_detail on oder.o_id = oder_detail.o_id
join product on product.p_id = oder_detail.p_id;

select customer.c_name, product.p_name from customer 
join oder on customer.c_id = oder.c_id
join oder_detail on oder.o_id = oder_detail.o_id
join product on product.p_id = oder_detail.p_id;

select c_name from customer
where c_name not in (
	select customer.c_name from customer 
	join oder on customer.c_id = oder.c_id
	join oder_detail on oder.o_id = oder_detail.o_id
	join product on product.p_id = oder_detail.p_id
	group by customer.c_name
);

select oder.o_id, oder.o_date, sum(oder_detail.od_quantity*product.p_price) as total_price from oder
join oder_detail on oder.o_id = oder_detail.o_id
join product on product.p_id = oder_detail.p_id
group by oder.o_id

