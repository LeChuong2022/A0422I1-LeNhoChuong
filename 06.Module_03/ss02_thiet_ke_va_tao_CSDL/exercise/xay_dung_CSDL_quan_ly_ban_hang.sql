create database QuanLyBanHang;
use QuanLyBanHang;
-- tạo bảng customer
create table customer(
cID varchar(10) not null primary key,
cName varchar(30) not null,
cAge int
);
create table `order`(
oID varchar(10) not null primary key,
cID varchar(10) not null,
oDate datetime,
oTotalPrice long,
foreign key (cID) references customer(ciD)
);

create table product(
pID varchar(10) not null primary key,
pName varchar(30) not null,
pPrice int not null
);
create table orderDetail(
oID varchar(10) not null,
pID varchar(10) not null,
odQty long,
primary key(oID, pID),
foreign key (oID) references `order`(oID),
foreign key (pID) references product(pID)
);