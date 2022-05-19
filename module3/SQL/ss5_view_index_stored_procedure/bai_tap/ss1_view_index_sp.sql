drop database if exists demo;
create database if not exists demo;
use demo;

create table product(
id int auto_increment,
product_code int not null,
product_name varchar(255),
product_price double,
product_amount int,
product_description text,
product_status bit(1) default 0,
primary key(id)
);
INSERT INTO `demo`.`product` (`product_code`, `product_name`, `product_price`, `product_amount`, `product_description`) 
VALUES ( '4', 'Hau', '100', '2', 'abcdef'),
( '444', 'Hoa', '200', '3', 'dfgerfg'),
( '23', 'Luan', '234', '4', 'rgerg'),
( '56', 'Tai', '2345', '5', 'qweqwe'),
( '52', 'Tri', '645', '7', 'abcdeqweqwef'),
( '123', 'Phuc', '678', '2', 'asdasd'),
( '34', 'Binh', '562547', '5', 'sfgfrg');

explain select * from product
where product_code = 23;

CREATE UNIQUE INDEX uniue_index
ON `demo`.`product` (`product_code`);

CREATE INDEX composite_index
ON `demo`.`product` (`product_name`, `product_price`);

explain select * from product
where product_code = 23;

create view v_product as
select product_name, product_code, product_price, product_status from product;

SET SQL_SAFE_UPDATES = 0;
update v_product
set product_name = 'Hoan'
where product_code = 56;
SET SQL_SAFE_UPDATES = 1;

drop view if exists v_product;

delimiter //
create procedure get_all_product()
  begin
    select * from product
    where product_status = 0;
  end //
delimiter ;

call get_all_product();

delimiter //
create procedure add_new_product(`p_code` int, `p_name` varchar(255), `p_price` double, `p_amount` int, `p_description` text)
  begin
    INSERT INTO `demo`.`product` (`product_code`, `product_name`, `product_price`, `product_amount`, `product_description`)
    VALUES (`p_code`, `p_name`, `p_price`, `p_amount`, `p_description`);
  end //
delimiter ;

call add_new_product( '54', 'Hung', '345', '2', 'dfgrtjherfg');

delimiter //
create procedure edit_product_by_id(p_id int, p_name varchar(255))
  begin
    update product
    set product_name = p_name
    where id = p_id;
  end //
delimiter ;

call edit_product_by_id(2,"yasuo");

delimiter //
create procedure delete_product_by_id(p_id int)
  begin
    update product
    set product_status = 1
    where id = p_id;
  end //
delimiter ;

call delete_product_by_id(5);