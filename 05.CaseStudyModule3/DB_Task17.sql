-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 
-- là lớn hơn 10.000.000 VNĐ.

 update khach_hang kh 
 set kh.ma_loai_khach = (select lk.ma_loai_khach from loai_khach lk where lk.ten_loai_khach= 'Diamond')
 where kh.ma_loai_khach = (select lk.ma_loai_khach from loai_khach lk where lk.ten_loai_khach= 'Plantinium')
 and kh.ma_loai_khach in (select t.ma_khach_hang from (
		select kh_a.ma_khach_hang, (sum(if (hdct_a.so_luong is null, 0, hdct_a.so_luong * dvdk_a.gia)) + temp.temp_chi_phi_thue) as tong_tien from khach_hang kh_a 
        left join hop_dong hd_a on kh_a.ma_khach_hang = hd_a.ma_khach_hang
        left join hop_dong_chi_tiet hdct_a on hd_a.ma_hop_dong = hdct_a.ma_hop_dong
        left join dich_vu_di_kem dvdk_a on hdct_a.ma_dich_vu_di_kem = dvdk_a.ma_dich_vu_di_kem
        left join 	(select 	kh_temp.ma_khach_hang as tempA,
							sum(dv_temp.chi_phi_thue) as temp_chi_phi_thue
					from khach_hang kh_temp left join hop_dong hd_temp on kh_temp.ma_khach_hang = hd_temp.ma_khach_hang
                    left join dich_vu dv_temp on hd_temp.ma_dich_vu = dv_temp.ma_dich_vu
                    group by kh_temp.ma_khach_hang) temp on kh_a.ma_khach_hang = temp.tempA
		where year(hd_a.ngay_lam_hop_dong) = 2021
        group by kh_a.ma_khach_hang
        having tong_tien > 1000000
        ) t );
        
-- truy vấn khách hàng
select * from khach_hang kh inner join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
order by kh.ma_khach_hang;




-- truy vấn * hết
-- select kh_a.ma_khach_hang, hd.ma_hop_dong, hdct.ma_hop_dong_chi_tiet, dv.chi_phi_thue, dvdk.gia, hdct.so_luong -- , sum(dv.chi_phi_thue  + if(hdct.so_luong is null, 0, hdct.so_luong * dvdk.gia)) as tong_tien
-- 		from khach_hang kh_a left join hop_dong hd on  kh_a.ma_khach_hang = hd.ma_khach_hang
--         left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
-- 		left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
--         left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
--         -- where year (hd.ngay_lam_hop_dong) = 2021 
--         -- group by kh_a.ma_khach_hang
--         -- having tong_tien > 1000000
--         order by kh_a.ma_khach_hang