-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên 
-- có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì
-- với ngày lập hợp đồng là “12/12/2019”.

use casestudy_furama;

create view v_nhan_vien as
select nv.ma_nhan_vien, nv.ho_ten, nv.ngay_sinh, nv.so_dien_thoai, nv.email, nv.dia_chi from nhan_vien nv
inner join hop_dong hd using (ma_nhan_vien)
where nv.dia_chi like '%Hải Châu%' and date(hd.ngay_lam_hop_dong) > '2020-12-12';

-- truy vấn v_nhan_vien 
select * from v_nhan_vien;

-- xóa view v_nhan_vien
drop view v_nhan_vien;
-- Cập nhật quận
update nhan_vien
set dia_chi = '295 Nguyễn Tất Thành, Q.Hải Châu, Đà Nẵng'
where ma_nhan_vien = 1;

update nhan_vien
set dia_chi = '22 Yên Bái, Q.Hải Châu, Đà Nẵng'
where ma_nhan_vien = 2;

update nhan_vien
set dia_chi = '43 Yên Bái, Q.Hải Châu, Đà Nẵng'
where ma_nhan_vien = 5;

update nhan_vien
set dia_chi = '294 Nguyễn Tất Thành, Q.Hải Châu, Đà Nẵng'
where ma_nhan_vien = 6;

update nhan_vien
set dia_chi = '213 Hàm Nghi, Q.Thanh Khê, Đà Nẵng'
where ma_nhan_vien = 9;
