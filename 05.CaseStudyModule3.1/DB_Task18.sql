-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
set foreign_key_checks = 0;
delete kh, hd from khach_hang kh left join hop_dong hd using(ma_khach_hang)
where kh.ma_khach_hang in ( select * from
(select kh_a.ma_khach_hang from khach_hang kh_a left join hop_dong hd_a using (ma_khach_hang)
where year(hd_a.ngay_lam_hop_dong) <2021) t);
set foreign_key_checks = 1;


-- truy vấn khách hàng
select * from khach_hang; 

-- truy vấn hợp đồng
select * from hop_dong; 

-- tắt safe mode
set sql_safe_updates = 0;


