drop database if exists `furama_manager`;
create database if not exists `furama_manager`;
use `furama_manager`;

create table if not exists `position` (
`position_id` int,
`position_name` varchar(45),
primary key (`position_id`)
);

create table if not exists `education_degree` (
`education_degree_id` int,
`education_degree_name` varchar(45),
primary key (`education_degree_id`)
);

create table if not exists `division` (
`division_id` int,
`division_name` varchar(45),
primary key (`division_id`)
);

create table if not exists `role` (
`role_id` int,
`role_name` varchar(255),
primary key (`role_id`)
);

create table if not exists `user` (
`username` varchar(255),
`password` varchar(255),
primary key (`username`)
);

create table if not exists `user_role` (
`role_id` int,
`username` varchar(255),
foreign key (`role_id`) references `role`(`role_id`),
foreign key (`username`) references `user`(`username`)
);

create table if not exists `attach_service` (
`attach_service_id` int,
`attach_service_name` varchar(45),
`attach_service_cost` double,
`attach_service_unit` int,
`attach_service_status` varchar(45),
primary key	(`attach_service_id`)
);

create table if not exists `rent_type` (
`rent_type_id` int,
`rent_type_name` varchar(45),
`rent_type_cost` double,
primary key (`rent_type_id`)
);

create table if not exists `service_type` (
`service_type_id` int,
`service_type_name` varchar(45),
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
primary key (`service_id`),
foreign key (`rent_type_id`) references `rent_type`(`rent_type_id`),
foreign key (`service_type_id`) references `service_type`(`service_type_id`)
);

create table if not exists `customer_type` (
`customer_type_id` int,
`customer_type_name` varchar(45),
primary key (`customer_type_id`)
);

create table if not exists `customer` (
`customer_id` int auto_increment,
`customer_type_id` int,
`customer_name` varchar(45),
`customer_birthday` varchar(45),
`customer_gender` bit(1),
`customer_id_card` varchar(45),
`customer_phone` varchar(45),
`customer_email` varchar(45),
`customer_address` varchar(45),
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
primary key (`contract_detail_id`),
foreign key (`contract_id`) references `contract`(`contract_id`),
foreign key (`attach_service_id`) references `attach_service`(`attach_service_id`)
);



