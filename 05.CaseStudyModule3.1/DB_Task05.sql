-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, 
-- ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá,
-- với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. 
-- (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu , hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, (temp.temp_chi_phi_thue + sum( if(hdct.so_luong is null, 0, hdct.so_luong * dvdk.gia))) as tong_tien -- , dv.chi_phi_thue, hdct.so_luong
from khach_hang kh left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu -- tới đây rồi
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong     
left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
left join (
	select 	kh_temp.ma_khach_hang a, 
			sum(dv_temp.chi_phi_thue) as temp_chi_phi_thue
	from 	khach_hang kh_temp 	inner join hop_dong hd_temp on kh_temp.ma_khach_hang = hd_temp.ma_khach_hang
								inner join dich_vu dv_temp on hd_temp.ma_dich_vu = dv_temp.ma_dich_vu
	group by kh_temp.ma_khach_hang
    ) temp on kh.ma_khach_hang = temp.a
group by kh.ma_khach_hang
order by kh.ma_khach_hang asc;


-- *Cập nhật lại dịch vụ
-- update dich_vu 
-- set ten_dich_vu = 'Villa No Beach Front'
-- where ma_dich_vu = 4;
-- Cập nhật lại giá thuê dịch vụ
update dich_vu 
set chi_phi_thue = 1000000
where ma_dich_vu = 1;

update dich_vu 
set chi_phi_thue = 500000
where ma_dich_vu = 2;

update dich_vu 
set chi_phi_thue = 100000
where ma_dich_vu = 3;

update dich_vu 
set chi_phi_thue = 900000
where ma_dich_vu = 4;

update dich_vu 
set chi_phi_thue = 400000
where ma_dich_vu = 5;

update dich_vu 
set chi_phi_thue = 90000
where ma_dich_vu = 6;



