-- Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được 
-- khách hàng đặt phòng trong năm 2021.

select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv inner join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
inner join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
where year(hd.ngay_lam_hop_dong) =2020 and 
dv.ma_dich_vu not in (select dv_a.ma_dich_vu from dich_vu dv_a inner join hop_dong hd_a on dv_a.ma_dich_vu = hd_a.ma_dich_vu
where year (hd_a.ngay_lam_hop_dong) = 2021)
group by dv.ma_dich_vu; 