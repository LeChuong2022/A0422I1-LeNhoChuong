-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.

update dich_vu_di_kem dvdk 
	left join hop_dong_chi_tiet hdct using (ma_dich_vu_di_kem)
    left join hop_dong hd using (ma_hop_dong)
set dvdk.gia = dvdk.gia * 2
where dvdk.ma_dich_vu_di_kem in ( 
	select hdct_a.ma_dich_vu_di_kem -- hdct.ma_dich_vu_di_kem 
    from hop_dong hd_a right join hop_dong_chi_tiet hdct_a on hd_a.ma_hop_dong = hdct_a.ma_hop_dong
    where year (hd_a.ngay_lam_hop_dong) = 2020 and hdct_a.so_luong > 10);
    
select * from dich_vu_di_kem;

			