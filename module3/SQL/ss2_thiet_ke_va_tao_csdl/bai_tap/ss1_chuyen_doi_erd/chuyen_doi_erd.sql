drop database if exists chuyen_doi_erd;
create database if not exists chuyen_doi_erd;
use chuyen_doi_erd;

create table phieu_xuat (
so_px int auto_increment,
ngay_xuat date,
primary key (so_px)
);

create table phieu_nhap (
so_pn int auto_increment,
ngay_nhap date,
primary key (so_pn)
);

create table nha_cc (
ma_ncc int auto_increment,
ten_ncc varchar(255),
dia_chi varchar(255),
so_dien_thoai bigint,
primary key (ma_ncc)
);

create table so_dien_thoai (
so_dien_thoai bigint,
ma_ncc int,
primary key (so_dien_thoai),
foreign key (ma_ncc) references nha_cc(ma_ncc)
);

create table don_dh (
so_dh int auto_increment,
ngay_dh date,
ma_ncc int,
primary key (so_dh),
foreign key (ma_ncc) references nha_cc(ma_ncc)
);

create table vat_tu (
ma_vt int auto_increment,
ten_vtu varchar(255),
primary key (ma_vt)
);

create table phieu_nhap_nhap_vat_tu (
so_pn int,
ma_vt int,
foreign key (so_pn) references phieu_nhap(so_pn),
foreign key (ma_vt) references vat_tu(ma_vt)
);

create table phieu_xuat_xuat_vat_tu (
so_px int,
ma_vt int,
foreign key (so_px) references phieu_xuat(so_px),
foreign key (ma_vt) references vat_tu(ma_vt)
);

create table don_dh_dat_vat_tu (
ma_vt int,
so_dh int,
foreign key (ma_vt) references vat_tu(ma_vt),
foreign key (so_dh) references don_dh(so_dh)
);