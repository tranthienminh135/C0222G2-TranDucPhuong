-- task 1. Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thoả mãn các yêu cầu bên dưới.

drop database if exists furuma_management;
create database if not exists furuma_management;
use furuma_management;

create table if not exists vi_tri(
ma_vi_tri int,
ten_vi_tri varchar(45),
`status` bit(1) default 0,
primary key(ma_vi_tri)
);

create table if not exists trinh_do(
ma_trinh_do int,
ten_trinh_do varchar(45),
`status` bit(1) default 0,
primary key (ma_trinh_do)
);

create table if not exists bo_phan(
ma_bo_phan int,
ten_bo_phan varchar(45),
`status` bit(1) default 0,
primary key (ma_bo_phan)
);

create table if not exists kieu_thue(
ma_kieu_thue int,
ten_kieu_thue varchar(45),
`status` bit(1) default 0,
primary key (ma_kieu_thue)
);

create table if not exists loai_dich_vu(
ma_loai_dich_vu int,
ten_loai_dich_vu varchar(45),
`status` bit(1) default 0,
primary key (ma_loai_dich_vu)
);

create table if not exists dich_vu(
ma_dich_vu int auto_increment,
ten_dich_vu varchar(45),
dien_tich int,
chi_phi_thue double,
so_nguoi_toi_da int,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int,
ma_kieu_thue int,
ma_loai_dich_vu int,
`status` bit(1) default 0,
primary key (ma_dich_vu),
foreign key (ma_kieu_thue) references kieu_thue(ma_kieu_thue),
foreign key (ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
);

create table if not exists nhan_vien(
ma_nhan_vien int,
ho_ten varchar(45),
ngay_sinh date,
so_cmnd varchar(45),
luong double,
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int,
ma_trinh_do int,
ma_bo_phan int,
`status` bit(1) default 0,
primary key (ma_nhan_vien),
foreign key (ma_vi_tri) references vi_tri(ma_vi_tri),
foreign key (ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key (ma_bo_phan) references bo_phan(ma_bo_phan)
);

create table if not exists loai_khach(
ma_loai_khach int,
ten_loai_khach varchar(45),
`status` bit(1) default 0,
primary key (ma_loai_khach)
);

create table if not exists khach_hang(
ma_khach_hang int,
ho_ten varchar(45),
ngay_sinh date,
gioi_tinh bit(1),
so_cmnd varchar(45),
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_loai_khach int,
`status` bit(1) default 0,
primary key (ma_khach_hang),
foreign key (ma_loai_khach) references loai_khach(ma_loai_khach)
);

create table if not exists hop_dong(
ma_hop_dong int auto_increment,
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime,
tien_dat_coc double,
ma_nhan_vien int,
ma_khach_hang int,
ma_dich_vu int,
`status` bit(1) default 0,
primary key (ma_hop_dong),
foreign key (ma_nhan_vien) references nhan_vien(ma_nhan_vien),
foreign key (ma_khach_hang) references khach_hang(ma_khach_hang),
foreign key (ma_dich_vu) references dich_vu(ma_dich_vu)
);

create table if not exists dich_vu_di_kem(
ma_dich_vu_di_kem int,
ten_dich_vu_di_kem varchar(45),
gia double,
don_vi varchar(10),
trang_thai varchar(45),
`status` bit(1) default 0,
primary key (ma_dich_vu_di_kem)
);


create table if not exists hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int,
so_luong int,
ma_hop_dong int,
ma_dich_vu_di_kem int,
`status` bit(1) default 0,
primary key (ma_hop_dong_chi_tiet),
foreign key (ma_hop_dong) references hop_dong(ma_hop_dong),
foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
);

-- thêm dữ liệu cho bảng --------------------------------------------------------------------------------------------------

insert into vi_tri (ma_vi_tri,ten_vi_tri)
values(1,"Quản Lý"),
(2,"Nhân Viên");

insert into trinh_do (ma_trinh_do, ten_trinh_do)
values (1,"Trung Cấp"),
(2,"Cao Đẳng"),
(3,"Đại Học"),
(4,"Sau Đại Học");

insert into bo_phan (ma_bo_phan, ten_bo_phan)
values (1,"Sale-Marketing"),
(2,"Hành chính"),
(3,"Phục vụ"),
(4,"Quản lý");

insert into nhan_vien (ma_nhan_vien, ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
values (1,'Nguyễn Văn An','1970-11-07',456231786,10000000,0901234121,'annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1),
(2,'Lê Văn Bình','1997-04-09',654231234,7000000,0934212314,'binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),
(3,'Hồ Thị Yến','1995-12-12',999231723,14000000,0412352315,'thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
(4,'Võ Công Toản','1980-04-04',123231365,17000000,0374443232,'toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4),
(5,'Nguyễn Bỉnh Phát','1999-12-09',454363232,6000000,0902341231,'phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1),
(6,'Khúc Nguyễn An Nghi','2000-11-08',964542311,7000000,0978653213,'annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),
(7,'Nguyễn Hữu Hà','1993-01-01',534323231,8000000,0941234553,'nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2),
(8,'Nguyễn Hà Đông','1989-09-03',234414123,9000000,0642123111,'donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
(9,'Tòng Hoang','1982-09-03',256781231,6000000,0245144444,'hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4),
(10,'Nguyễn Công Đạo','1994-01-08',755434343,8000000,0988767111,'nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);

insert into loai_khach (ma_loai_khach, ten_loai_khach)
values (1,"Diamond"),
(2,"Platinium"),
(3,"Gold"),
(4,"Silver"),
(5,"Member");

insert into khach_hang (ma_khach_hang, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi, ma_loai_khach)
values (1,'Nguyễn Thị Hào','1970-11-07',0,643431213,0945423362,'thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
(2,'Phạm Xuân Diệu','1992-08-08',1,865342123,0954333333,'xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',3),
(3,'Trương Đình Nghệ','1990-02-27',1,488645199,0373213122,'nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1),
(4,'Dương Văn Quan','1981-07-08',1,543432111,0490039241,'duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',1),
(5,'Hoàng Trần Nhi Nhi','1995-12-09',0,795453345,0312345678,'nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4),
(6,'Tôn Nữ Mộc Châu','2005-12-06',0,732434215,0988888844,'tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4),
(7,'Nguyễn Mỹ Kim','1984-04-08',0,856453123,0912345698,'kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),
(8,'Nguyễn Thị Hào','1999-04-08',0,965656433,0763212345,'haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3),
(9,'Trần Đại Danh','1994-07-01',1,432341235,0643343433,'danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1),
(10,'Nguyễn Tâm Đắc','1989-07-01',1,344343432,0987654321,'dactam@gmail.com','22 Ngô Quyền, Đà Nẵng',2);

insert into kieu_thue (ma_kieu_thue, ten_kieu_thue)
values (1,"year"),
(2,"month"),
(3,"day"),
(4,"hour");

insert into loai_dich_vu (ma_loai_dich_vu, ten_loai_dich_vu)
values (1,"Villa"),
(2,"House"),
(3,"Room");

insert into dich_vu (ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang, ma_kieu_thue, ma_loai_dich_vu)
values (1,'Villa Beach Front',25000,10000000,10,'vip','Có hồ bơi',500,4,3,1),
(2,'House Princess 01',14000,5000000,7,'vip','Có thêm bếp nướng',NULL,3,2,2),
(3,'Room Twin 01',5000,1000000,2,'normal','Có tivi',NULL,NULL,4,3),
(4,'Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,3,1),
(5,'House Princess 02',10000,4000000,5,'normal','Có thêm bếp nướng',NULL,2,3,2),
(6,'Room Twin 02',3000,900000,2,'normal','Có tivi',NULL,NULL,4,3);

insert into dich_vu_di_kem (ma_dich_vu_di_kem, ten_dich_vu_di_kem, gia, don_vi, trang_thai)
values (1,"Karaoke",10000,"giờ","tiện nghi, hiện đại"),
(2,"Thuê xe máy",10000,"chiếc","hỏng 1 xe"),
(3,"Thuê xe đạp",20000,"chiếc","tốt"),
(4,"Buffet buổi sáng",15000,"suất","đầy đủ đồ ăn, tráng miệng"),
(5,"Buffet buổi trưa",90000,"suất","đầy đủ đồ ăn, tráng miệng"),
(6,"Buffet buổi tối",16000,"suất","đầy đủ đồ ăn, tráng miệng");

insert into hop_dong (ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu)
values (1,'2020-12-08','2020-12-08',0,3,1,3),
(2,'2020-07-14','2020-07-21',200000,7,3,1),
(3,'2021-03-15','2021-03-17',50000,3,4,2),
(4,'2021-01-14','2021-01-18',100000,7,5,5),
(5,'2021-07-14','2021-07-15',0,7,2,6),
(6,'2021-06-01','2021-06-03',0,7,7,6),
(7,'2021-09-02','2021-09-05',100000,7,4,4),
(8,'2021-06-17','2021-06-18',150000,3,4,1),
(9,'2020-11-19','2020-11-19',0,3,4,3),
(10,'2021-04-12','2021-04-14',0,10,3,5),
(11,'2021-04-25','2021-04-25',0,2,2,1),
(12,'2021-05-25','2021-05-27',0,7,10,1);

insert into hop_dong_chi_tiet (ma_hop_dong_chi_tiet, so_luong, ma_hop_dong, ma_dich_vu_di_kem)
values (1,5,2,4),
(2,8,2,5),
(3,15,2,6),
(4,1,3,1),
(5,11,3,2),
(6,1,1,3),
(7,2,1,2),
(8,2,12,2);

-- task 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.

select * from nhan_vien
where (ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%' and length(ho_ten) < 15) and (`status` = 0);

-- task 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select * from khach_hang kh
where ((TIMESTAMPDIFF(year, kh.ngay_sinh, curdate())) >= 18 and (TIMESTAMPDIFF(year, kh.ngay_sinh, curdate())) <= 50 and dia_chi Like '%Đà Nẵng%' or dia_chi like '%Quảng Trị%') and (`status` = 0);

-- task 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select khach_hang.ma_khach_hang, khach_hang.ho_ten, count(hop_dong.ma_khach_hang) as so_lan_dat_phong from khach_hang
join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where (ma_loai_khach =  (select ma_loai_khach from loai_khach where ten_loai_khach = 'Diamond'))  and (khach_hang.`status` = 0)
group by hop_dong.ma_khach_hang
order by count(hop_dong.ma_khach_hang);

-- task 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, 
-- tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, hop_dong.ma_hop_dong, dich_vu.ten_dich_vu,
 hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, ifnull(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia, 0) + dich_vu.chi_phi_thue as tong_tien from khach_hang
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where (khach_hang.`status` = 0)
group by ma_hop_dong, ma_khach_hang
order by ma_khach_hang;

-- task 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).

select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu from dich_vu
join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
where dich_vu.ma_dich_vu
not in (select dich_vu.ma_dich_vu from dich_vu
		join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
		join hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
		where (hop_dong.ngay_lam_hop_dong between '2021-01-01' and '2021-03-31') and (dich_vu.`status` = 0)
		group by ten_dich_vu) and (dich_vu.`status` = 0)
group by ten_dich_vu;

-- taks 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu
-- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.

select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu, hop_dong.ma_khach_hang, hop_dong.ngay_lam_hop_dong from dich_vu
join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where year(hop_dong.ngay_lam_hop_dong) = 2020 and hop_dong.ma_khach_hang 
not in (select hop_dong.ma_khach_hang from dich_vu
		join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
		join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
		where (year(hop_dong.ngay_lam_hop_dong) = 2021) and (dich_vu.`status` = 0)
		group by ma_khach_hang
		order by ma_khach_hang) and (dich_vu.`status` = 0);
        
-- task 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau. Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.

-- cach 1:
select distinct ho_ten from khach_hang kh1
where exists (select kh1.ho_ten from khach_hang kh2 where kh1.ho_ten = kh2.ho_ten limit 1,1);

-- cach 2: 
select ho_ten from khach_hang
where (`status` = 0)
group by ho_ten
having count(*) > 1;

-- cach 3:
select kh1.ho_ten from khach_hang kh1
join khach_hang kh2 on kh1.ma_khach_hang = kh2.ma_khach_hang
where kh1.ho_ten = kh2.ho_ten
group by ho_ten
having count(*) > 1;

-- task 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select month(hop_dong.ngay_lam_hop_dong) as `thang`, count(hop_dong.ma_khach_hang) as so_luong_khach_hang from hop_dong
where (year(hop_dong.ngay_lam_hop_dong) = 2021) and (`status` = 0)
group by `thang`
order by `thang`;

-- task 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc,
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).

select hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc, sum(ifnull(hop_dong_chi_tiet.so_luong,0)) as so_luong_dich_vu_di_kem from hop_dong
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
where (hop_dong.`status` = 0)
group by hop_dong.ma_hop_dong;

-- task 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.

select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem from dich_vu_di_kem
join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
where (loai_khach.ten_loai_khach = 'Diamond') and (khach_hang.dia_chi like '%Vinh%' or khach_hang.dia_chi like '%Quảng Ngãi%') and (dich_vu_di_kem.`status` = 0);

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), 
-- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

select hop_dong.ma_hop_dong, nhan_vien.ho_ten, khach_hang.ho_ten, khach_hang.so_dien_thoai, dich_vu.ten_dich_vu, sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem, hop_dong.tien_dat_coc from hop_dong
join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
where (hop_dong.ngay_lam_hop_dong between '2020-10-01' and '2020-12-31') and hop_dong.ma_hop_dong
 not in (select hop_dong.ma_hop_dong from hop_dong
		join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
		join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
		join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
		join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
		join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
		where (hop_dong.ngay_lam_hop_dong between '2021-01-01' and '2021-06-30') and (hop_dong.`status` = 0)) and (hop_dong.`status` = 0);

-- task 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

with so_luong as (
	select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem from dich_vu_di_kem
	join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
	where (dich_vu_di_kem.`status` = 0)
	group by hop_dong_chi_tiet.ma_dich_vu_di_kem 
)
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by hop_dong_chi_tiet.ma_dich_vu_di_kem 
having so_luong_dich_vu_di_kem = (select max(so_luong_dich_vu_di_kem) from so_luong);

-- task 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).

select hop_dong.ma_hop_dong, loai_dich_vu.ten_loai_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem, count(hop_dong_chi_tiet.ma_dich_vu_di_kem) as so_lan_su_dung from hop_dong
join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
where (hop_dong.`status` = 0)
group by dich_vu_di_kem.ten_dich_vu_di_kem
having so_lan_su_dung = 1
order by hop_dong.ma_hop_dong;

-- task 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.

select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi from nhan_vien
join trinh_do on trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
join bo_phan on bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
join hop_dong on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
where (hop_dong.ngay_lam_hop_dong between '2020-01-01' and '2021-12-31') and (nhan_vien.`status` = 0)
group by nhan_vien.ma_nhan_vien
having count(hop_dong.ma_nhan_vien) <= 3;

-- task 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.

SET SQL_SAFE_UPDATES = 0;
with ma_nhan_vien_can_xoa as (
select ma_nhan_vien from nhan_vien
where ma_nhan_vien
not in (select nhan_vien.ma_nhan_vien from nhan_vien
		join trinh_do on trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
		join bo_phan on bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
		join hop_dong on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
		where hop_dong.ngay_lam_hop_dong between '2019-01-01' and '2021-12-31'
		group by nhan_vien.ma_nhan_vien
	)
)
update nhan_vien
set `status` = 1
where ma_nhan_vien in (select ma_nhan_vien from ma_nhan_vien_can_xoa);
SET SQL_SAFE_UPDATES = 1;

-- task 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.

with khach_hang_thang_hang as (
	select khach_hang.ma_khach_hang, khach_hang.ho_ten, loai_khach.ma_loai_khach, sum(dich_vu.chi_phi_thue) as tong_tien from khach_hang
	join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
	join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
	join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
	where (year(hop_dong.ngay_lam_hop_dong) = 2021 and loai_khach.ten_loai_khach = 'Platinium') and (khach_hang.`status` = 0)
	having tong_tien >= 10000000
)
update khach_hang
set khach_hang.ma_loai_khach = (select ma_loai_khach from loai_khach where ten_loai_khach = "Diamond")
where khach_hang.ma_khach_hang in (select ma_khach_hang from khach_hang_thang_hang);

-- task 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).

with xoa_khach_hang as (
	select distinct khach_hang.ma_khach_hang as ma_khach_hang from khach_hang
	join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
	where year(hop_dong.ngay_lam_hop_dong) < 2021
)
update khach_hang
set khach_hang.`status` = 1
where khach_hang.ma_khach_hang
in (select ma_khach_hang from xoa_khach_hang);

-- update khach_hang
-- set khach_hang.`status` = 1
-- where khach_hang.ma_khach_hang
-- in (select distinct khach_hang.ma_khach_hang as ma_khach_hang from khach_hang
-- 	join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
-- 	where year(hop_dong.ngay_lam_hop_dong) < 2021);

-- task 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.

with so_luong_su_dung_dich_vu_di_kem as (
	select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem from dich_vu_di_kem
	join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
	join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
	where (dich_vu_di_kem.`status` = 0) and (year(hop_dong.ngay_lam_hop_dong) = 2020)
	group by hop_dong_chi_tiet.ma_dich_vu_di_kem 
	having so_luong_dich_vu_di_kem > 10
)
update dich_vu_di_kem
set gia = gia * 2
where dich_vu_di_kem.ma_dich_vu_di_kem = (select ma_dich_vu_di_kem from so_luong_su_dung_dich_vu_di_kem);

-- task 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.

select ma_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi, "Khách Hàng" as `khach_hang` from khach_hang
union
select ma_nhan_vien, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi, "Nhân Viên" as `nhan_vien` from nhan_vien;

-- task 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.

create view v_nhan_vien as
select nv.ma_nhan_vien, nv.ho_ten, nv.ngay_sinh, nv.so_cmnd, nv.luong, nv.so_dien_thoai, nv.email, nv.dia_chi from nhan_vien nv
join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien
where (hd.ngay_lam_hop_dong = '2019-12-12') and (nv.dia_chi like '%Lê Lợi%');

-- task 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.

SET SQL_SAFE_UPDATES = 0;
update v_nhan_vien
set dia_chi = 'Liên Chiểu';
SET SQL_SAFE_UPDATES = 1;

-- task 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.

drop procedure if exists sp_xoa_khach_hang;
delimiter //
create procedure sp_xoa_khach_hang ( ma_kh INT)
  begin
    update khach_hang
    set `status` = 1
    where ma_khach_hang = ma_kh;
  end //
delimiter ;

call xoa_khach_hang(6);

-- task 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung,
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

drop procedure if exists sp_them_moi_hop_dong;
delimiter //
create procedure sp_them_moi_hop_dong ( ngay_lam_hd date, ngay_kt date, tien_coc double, ma_nv int, ma_kh int, ma_dv int)
  begin
	case
    when
		ma_nv in (select ma_nhan_vien from nhan_vien) 
		and
        ma_kh in (select ma_khach_hang from khach_hang)
        and
        ma_dv in (select ma_dich_vu from dich_vu)
	then
		insert into hop_dong (ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu)
		values (ngay_lam_hd, ngay_kt, tien_coc, ma_nv, ma_kh, ma_dv);
	else
    select "mã không tồn tại" as thong_bao;
    end case;
  end //
delimiter ;

call sp_them_moi_hop_dong ('2020-12-08','2020-12-08',100000,3,1,3);

-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.

drop table if exists thong_tin;
create table if not exists thong_tin(
ma_hop_dong_bi_xoa int,
so_luong_ban_ghi_con_lai int,
ngay_update datetime
);

drop trigger if exists tr_xoa_hop_dong;
delimiter //
create trigger tr_xoa_hop_dong
after update on hop_dong 
for each row
begin
declare so_luong int;
set @so_luong = (select count(*) from hop_dong where `status` = 0) ;
insert into thong_tin()
values (old.ma_hop_dong ,@so_luong, now());
end //
delimiter ;

update hop_dong
set `status` = 1
where ma_hop_dong = 6;

-- 26.	Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không, 
-- với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật,
-- nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thú  c hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.


