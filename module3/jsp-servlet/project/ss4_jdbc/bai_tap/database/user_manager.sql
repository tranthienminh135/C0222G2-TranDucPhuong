drop database if exists user_manager;
create database if not exists user_manager;
use user_manager;
drop table if exists users;
create table if not exists users (
id int auto_increment,
name varchar(255),
country varchar(255),
primary key (id)
);

insert into users (name, country)
values ("Lê Thị Luận", "Lào"),
("Lê Thị Hậu", "Trung Quốc"),
("Lê Thị Tài", "Thái Lan"),
("Lê Thị Diệp", "Mỹ Tho"),
("Lê Thị Tâm", "Nga"),
("Lê Thị Trí", "Nhật Bản"),
("Lê Thị Hùng", "Hàn Xẻng"),
("Lê Thị Bình", "Liên Xô"),
("Lê Thị Phúc", "Núi Võ Đang"),
("Lê Thị Đảm", "Đào Hoa Đảo"),
("Lê Thị Hòa", "Tương Dương"),
("Lê Thị Bảo", "Thành Đô"),
("Lê Thị Tuyến", "Campuchia");