create database ChuyenDoiERDSangMoHinhQuanHe;
use ChuyenDoiERDSangMoHinhQuanHe;
create table phieuXuat(
soPX varchar(10) primary key,
ngayXuat datetime
);

create table vatTu(
maVTu varchar(10) primary key,
tenVTu varchar(10)
);

create table chiTietPhieXuat(
DGxuat varchar(20),
SLxuat int,
soPX varchar(10),
maVT varchar(10),
foreign key (soPX) references phieuXuat(soPX),
foreign key (maVT) references vatTu(maVtu)
);

create table phieuNhap(
soPN int primary key,
ngayNhap datetime
);

create table chiTietPhieuNhap(
DGnhap varchar(20),
SLnhap int,
maVT varchar(10),
soPN int,
foreign key (maVT) references vattu(maVtu),
foreign key (soPN) references phieuNhap(soPN)
);

create table donDH(
soDH int primary key,
ngayDH datetime
);

create table chiTietDonDatHang(
maVtu varchar(10),
soDH int,
foreign key (maVtu) references vattu(maVtu),
foreign key (soDH) references donDH(soDH)
);

create table nhaCC(
maNCC varchar(10) primary key,
tenNCC varchar(20),
diaChi varchar(20)
);

create table cungCap(
soDH int,
maNCC varchar(10),
foreign key (soDH) references donDH(soDH),
foreign key (maNCC) references nhaCC(maNCC)
);

create table sdt(
sdt varchar(10),
maNCC varchar(10),
foreign key (maNCC) references nhaCC(maNCC)
);

