drop database if exists `furama_manager`;
create database if not exists `furama_manager`;
use `furama_manager`;

create table if not exists `position` (
`position_id` int auto_increment,
`position_name` varchar(45),
`status` bit(1) default 0,
primary key (`position_id`)
);

create table if not exists `education_degree` (
`education_degree_id` int auto_increment,
`education_degree_name` varchar(45),
`status` bit(1) default 0,
primary key (`education_degree_id`)
);

create table if not exists `division` (
`division_id` int auto_increment,
`division_name` varchar(45),
`status` bit(1) default 0,
primary key (`division_id`)
);

create table if not exists `role` (
`role_id` int auto_increment,
`role_name` varchar(255),
`status` bit(1) default 0,
primary key (`role_id`)
);

create table if not exists `user` (
`username` varchar(255),
`password` varchar(255),
`status` bit(1) default 0,
primary key (`username`)
);

create table if not exists `user_role` (
`role_id` int,
`username` varchar(255),
`status` bit(1) default 0,
foreign key (`role_id`) references `role`(`role_id`),
foreign key (`username`) references `user`(`username`)
);

create table if not exists `attach_service` (
`attach_service_id` int,
`attach_service_name` varchar(45),
`attach_service_cost` double,
`attach_service_unit` int,
`attach_service_status` varchar(45),
`status` bit(1) default 0,
primary key	(`attach_service_id`)
);

create table if not exists `rent_type` (
`rent_type_id` int auto_increment,
`rent_type_name` varchar(45),
`rent_type_cost` double,
`status` bit(1) default 0,
primary key (`rent_type_id`)
);

create table if not exists `service_type` (
`service_type_id` int auto_increment,
`service_type_name` varchar(45),
`status` bit(1) default 0,
primary key (`service_type_id`)
);

create table if not exists `service` (
`service_id` int auto_increment,
`service_name` varchar(45),
`service_area` int,
`service_cost` double,
`service_max_people` int,
`rent_type_id` int,
`service_type_id` int,
`standard_room` varchar(45),
`description_other_convenience` varchar(45),
`pool_area` double,
`number_of_floors` int,
`status` bit(1) default 0,
primary key (`service_id`),
foreign key (`rent_type_id`) references `rent_type`(`rent_type_id`),
foreign key (`service_type_id`) references `service_type`(`service_type_id`)
);

create table if not exists `customer_type` (
`customer_type_id` int auto_increment,
`customer_type_name` varchar(45),
`status` bit(1) default 0,
primary key (`customer_type_id`)
);

create table if not exists `customer` (
`customer_id` int auto_increment,
`customer_type_id` int,
`customer_name` varchar(45),
`customer_birthday` varchar(45),
`customer_gender` bit(2),
`customer_id_card` varchar(45),
`customer_phone` varchar(45),
`customer_email` varchar(45),
`customer_address` varchar(45),
`status` bit(1) default 0,
primary key (`customer_id`),
foreign key (`customer_type_id`) references `customer_type`(`customer_type_id`)
);

create table if not exists `employee` (
`employee_id` int auto_increment,
`employee_name` varchar(45),
`employee_birthday` varchar(45),
`employee_id_card` varchar(45),
`employee_salary` double,
`employee_phone` varchar(45),
`employee_email` varchar(45),
`employee_address` varchar(45),
`position_id` int,
`education_degree_id` int,
`division_id` int,
`username` varchar(45),
`status` bit(1) default 0,
primary key (`employee_id`),
foreign key (`position_id`) references `position`(`position_id`),
foreign key (`education_degree_id`) references `education_degree`(`education_degree_id`),
foreign key (`division_id`) references `division`(`division_id`),
foreign key (`username`) references `user`(`username`)
);

create table if not exists `contract` (
`contract_id` int,
`contract_start_date` varchar(45),
`contract_end_date` varchar(45),
`contract_deposit` double,
`contract_total_money` double,
`employee_id` int,
`customer_id` int,
`service_id` int,
`status` bit(1) default 0,
primary key (`contract_id`),
foreign key (`employee_id`) references `employee`(`employee_id`),
foreign key (`customer_id`) references `customer`(`customer_id`),
foreign key (`service_id`) references `service`(`service_id`)
);

create table if not exists `contract_detail` (
`contract_detail_id` int,
`contract_id` int,
`attach_service_id` int,
`quantity` int,
`status` bit(1) default 0,
primary key (`contract_detail_id`),
foreign key (`contract_id`) references `contract`(`contract_id`),
foreign key (`attach_service_id`) references `attach_service`(`attach_service_id`)
);

INSERT INTO `customer_type` (`customer_type_name`) 
VALUES ('Iron'),
('Bronze'),
('Silver'),
('Platinum'),
('Diamond'),
('Master'),
('Grandmaster');

INSERT INTO `customer` (`customer_type_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`) 
VALUES ( 1, 'Le Thị Hoàn', '2000-06-09', null, '123456', '01234565', 'hoan@gmail.com', 'GL'),
( 2, 'Lê Thị Tài', '2001-01-01', 0, '4568786', '0135756456', 'taingu@gmail.com', 'TH'),
( 3, 'Lê Thị Trí', '2001-02-02', 1, '786486', '0351254568', 'tri@gmail.com', 'QT'),
( 4, 'Lê Thị Hậu', '2003-03-03', 2, '486486', '035452475', 'hau@gmail.com', 'TH'),
( 2, 'Lê Thị Luận', '2004-04-04', 0, '78789', '03542481', 'luan@gmail.com', 'DN'),
( 6, 'Lê Thị Bình', '2005-05-05', 2, '6868', '065874654', 'binh@gmail.com', 'DN'),
( 7, 'Lê Thị Phúc', '2006-06-06', 1, '578537', '0654357', 'phuc@gmail.com', 'QB'),
( 3, 'Lê Văn Diệp', '2007-07-07', 2, '578537', '0654357', 'diep@gmail.com', 'Trung Quốc'),
( 4, 'Lê Thị Hùng', '2008-08-08', 1, '578537', '0654357', 'hung@gmail.com', 'Lào'),
( 7, 'Lê Thị Tuyến', '2009-09-09', 0, '578537', '0654357', 'tuyen@gmail.com', 'Ấn Độ'),
( 1, 'Lê Thị Bảo', '2010-10-10', 2, '578537', '0654357', 'bao@gmail.com', 'Nga'),
( 6, 'Lê Thị Hòa', '2011-11-11', 1, '578537', '0654357', 'hoa@gmail.com', 'Wakanda'),
( 4, 'Lê Thị Đảm', '2012-02-12', 0, '578537', '0654357', 'dam@gmail.com', 'New York'),
( 2, 'Lê Thị Chiến', '2013-12-22', 2, '578537', '0654357', 'chientran@gmail.com', 'Núi Võ Đang'),
( 3, 'Lệnh Hồ Xung', '1998-10-12', 1, '54537', '06512357', 'lenhhoxung@gmail.com', 'Hoa Sơn Phái'),
( 3, 'Âu Dương Phong', '2013-12-22', 2, '578537', '0654357', 'auduongphong@gmail.com', 'Tây Vực'),
( 5, 'Trùng Dương chân Nhân', '2013-12-22', 2, '578537', '0654357', 'trungduong@gmail.com', 'Trùng Dương Cung'),
( 6, 'Quách Tĩnh', '2013-12-22', 2, '578537', '0654357', 'phuc@gmail.com', 'Thành Tương Dương'),
( 2, 'Hoắc Đô', '2013-12-22', 2, '578537', '0654357', 'phuc@gmail.com', 'Mông Cổ'),
( 3, 'Lê Thị HảiTT', '2014-11-14', 1, '578537', '0654357', 'phuc@gmail.com', 'Đào Hoa Đảo');

INSERT INTO `rent_type` (`rent_type_name`, `rent_type_cost`) 
VALUES ('Thuê theo năm', '100000'),
('Thuê theo tháng', '10000'),
('Thuê theo ngày', '1000'),
('Thuê theo giờ', '100');

INSERT INTO `furama_manager`.`service_type` (`service_type_name`)
VALUES ('House'),
('Room'),
('Villa');

INSERT INTO `service` ( `service_name`, `service_area`, `service_cost`, `service_max_people`, `rent_type_id`, `service_type_id`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`) 
VALUES ('Nhà cấp 4', '100', 200000, 5, 1, 1, 'Phòng vip', 'Có điều hòa', 3, 5),
('Biệt thự', '200', 500000, 5, 2, 2, 'Phòng siêu cấp vip pro', 'Có hồ bơi ngoài trời', 30, 5),
('Chuồng Heo', '50', 30000, 10, 1, 3, 'Chuồng heo xịn', 'Có máng ăn', 30, 5);

INSERT INTO `position` (`position_name`)
 VALUES ('Giám đốc'),
 ('Trưởng Phòng'),
 ('Kế Toán'),
 ('Bảo Vệ');

INSERT INTO `education_degree` (`education_degree_name`) 
VALUES ('Đại Học'),
('Cao Đẳng'),
('THPT'),
('THCS');

INSERT INTO `division` (`division_name`)
VALUES ('Quản lý'),
('Sale'),
('Hành Chính'),
('Phục Vụ');

INSERT INTO `user` (`username`, `password`) 
VALUES ('admin', 'admin123'),
('quanly', 'quanly123'),
('nhanvien', 'nhanvien123');

INSERT INTO `role` (`role_name`) 
VALUES ('Admin'),
('Manager'),
('Employee');

insert into user_role (role_id,username)
values (1,'admin'),
(2,'quanly'),
(3,'nhanvien');

INSERT INTO `employee` (`employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`, `employee_address`, `position_id`, `education_degree_id`, `division_id`, `username`) 
VALUES ('Lê Thị Tài', '1969-06-09', '123456', '100000', '0123456', 'taingu@gmail.com', 'Trung Quốc', '4', '4', '4', 'nhanvien'),
('Lê Thị Hậu', '2003-03-03', '456456', '456456', '789456', 'hau@gmail.com', 'Lào', '1', '1', '1', 'quanly');







use `furama_manager`;








