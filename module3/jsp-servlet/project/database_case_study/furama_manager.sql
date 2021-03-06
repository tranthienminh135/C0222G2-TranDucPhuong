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
`attach_service_id` int auto_increment,
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
`contract_id` int auto_increment,
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
`contract_detail_id` int auto_increment,
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
VALUES ( 1, 'Le Th??? Ho??n', '2000-06-09', null, '123456', '01234565', 'hoan@gmail.com', 'GL'),
( 2, 'L?? Th??? T??i', '2001-01-01', 0, '4568786', '0135756456', 'taingu@gmail.com', 'TH'),
( 3, 'L?? Th??? Tr??', '2001-02-02', 1, '786486', '0351254568', 'tri@gmail.com', 'QT'),
( 4, 'L?? Th??? H???u', '2003-03-03', 2, '486486', '035452475', 'hau@gmail.com', 'TH'),
( 2, 'L?? Th??? Lu???n', '2004-04-04', 0, '78789', '03542481', 'luan@gmail.com', 'DN'),
( 6, 'L?? Th??? B??nh', '2005-05-05', 2, '6868', '065874654', 'binh@gmail.com', 'DN'),
( 7, 'L?? Th??? Ph??c', '2006-06-06', 1, '578537', '0654357', 'phuc@gmail.com', 'QB'),
( 3, 'L?? V??n Di???p', '2007-07-07', 2, '578537', '0654357', 'diep@gmail.com', 'Trung Qu???c'),
( 4, 'L?? Th??? H??ng', '2008-08-08', 1, '578537', '0654357', 'hung@gmail.com', 'L??o'),
( 7, 'L?? Th??? Tuy???n', '2009-09-09', 0, '578537', '0654357', 'tuyen@gmail.com', '???n ?????'),
( 1, 'L?? Th??? B???o', '2010-10-10', 2, '578537', '0654357', 'bao@gmail.com', 'Nga'),
( 6, 'L?? Th??? H??a', '2011-11-11', 1, '578537', '0654357', 'hoa@gmail.com', 'Wakanda'),
( 4, 'L?? Th??? ?????m', '2012-02-12', 0, '578537', '0654357', 'dam@gmail.com', 'New York'),
( 2, 'L?? Th??? Chi???n', '2013-12-22', 2, '578537', '0654357', 'chientran@gmail.com', 'N??i V?? ??ang'),
( 3, 'L???nh H??? Xung', '1998-10-12', 1, '54537', '06512357', 'lenhhoxung@gmail.com', 'Hoa S??n Ph??i'),
( 3, '??u D????ng Phong', '2013-12-22', 2, '578537', '0654357', 'auduongphong@gmail.com', 'T??y V???c'),
( 5, 'Tr??ng D????ng ch??n Nh??n', '2013-12-22', 2, '578537', '0654357', 'trungduong@gmail.com', 'Tr??ng D????ng Cung'),
( 6, 'Qu??ch T??nh', '2013-12-22', 2, '578537', '0654357', 'phuc@gmail.com', 'Th??nh T????ng D????ng'),
( 2, 'Ho???c ????', '2013-12-22', 2, '578537', '0654357', 'phuc@gmail.com', 'M??ng C???'),
( 3, 'L?? Th??? H???iTT', '2014-11-14', 1, '578537', '0654357', 'phuc@gmail.com', '????o Hoa ?????o');

INSERT INTO `rent_type` (`rent_type_name`, `rent_type_cost`) 
VALUES ('Thu?? theo n??m', '100000'),
('Thu?? theo th??ng', '10000'),
('Thu?? theo ng??y', '1000'),
('Thu?? theo gi???', '100');

INSERT INTO `furama_manager`.`service_type` (`service_type_name`)
VALUES ('House'),
('Room'),
('Villa');

INSERT INTO `service` ( `service_name`, `service_area`, `service_cost`, `service_max_people`, `rent_type_id`, `service_type_id`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`) 
VALUES ('Nh?? c???p 4', '100', 200000, 5, 1, 1, 'Ph??ng vip', 'C?? ??i???u h??a', 3, 5),
('Bi???t th???', '200', 500000, 5, 2, 2, 'Ph??ng si??u c???p vip pro', 'C?? h??? b??i ngo??i tr???i', 30, 5),
('Chu???ng Heo', '50', 30000, 10, 1, 3, 'Chu???ng heo x???n', 'C?? m??ng ??n', 30, 5);

INSERT INTO `position` (`position_name`)
 VALUES ('Gi??m ?????c'),
 ('Tr?????ng Ph??ng'),
 ('K??? To??n'),
 ('B???o V???');

INSERT INTO `education_degree` (`education_degree_name`) 
VALUES ('?????i H???c'),
('Cao ?????ng'),
('THPT'),
('THCS');

INSERT INTO `division` (`division_name`)
VALUES ('Qu???n l??'),
('Sale'),
('H??nh Ch??nh'),
('Ph???c V???');

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
VALUES ('L?? Th??? T??i', '1969-06-09', '123456', '100000', '0123456', 'taingu@gmail.com', 'Trung Qu???c', '4', '4', '4', 'nhanvien'),
('L?? Th??? H???u', '2003-03-03', '456456', '456456', '789456', 'hau@gmail.com', 'L??o', '1', '1', '1', 'quanly');

INSERT INTO `contract` (`contract_start_date`, `contract_end_date`, `contract_deposit`, `contract_total_money`, `employee_id`, `customer_id`, `service_id`) 
VALUES ('2022-05-06', '2022-06-07', '100', '1000', '1', '1', '1'),
('2019-03-02', '2019-04-03', '200', '2000', '2', '3', '1'),
('2015-02-08', '2015-03-08', '300', '3000', '1', '2', '3');

INSERT INTO `attach_service` (`attach_service_name`, `attach_service_cost`, `attach_service_unit`, `attach_service_status`) 
VALUES ('Em hot girl b??n c??m b???ng m???m', '100000', '10', 'C??n h??ng'),
('Bia ??m', '200000', '2', 'C??n h??ng'),
('L??m bia cho b???i ?????i t???p b???n', '100000', '5', 'C??n h??ng'),
('Th??? thu???c tr??? s??u', '50000', '6', 'H???t h??ng');

INSERT INTO `contract_detail` (`contract_id`, `attach_service_id`, `quantity`) 
VALUES ('1', '2', '5'),
('2', '3', '7'),
('3', '1', '8'),
('1', '3', '15'),
('3', '1', '6');




use `furama_manager`;








