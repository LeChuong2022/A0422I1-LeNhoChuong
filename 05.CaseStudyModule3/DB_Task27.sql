-- 27.	Tạo Function thực hiện yêu cầu sau:
-- a.	Tạo Function func_dem_dich_vu: Đếm các dịch vụ đã được sử dụng với tổng tiền là > 2.000.000 VNĐ.

delimiter //
create function func_dem_dich_vu()
returns int
deterministic 
begin
	declare id int default 0;
	select count(*) into id from ( select sum(dv.chi_phi_thue) as tong_tien
	from dich_vu dv inner join hop_dong using (ma_dich_vu) group by dv.ma_dich_vu having tong_tien > 2000000) t;
    return id;
end //
delimiter ;

select func_dem_dich_vu() as so_dich_vu_su_dung_tong_tien_nhieu_hon_2tr;

-- xóa functinon
drop function func_dem_dich_vu;

-- b.	Tạo Function func_tinh_thoi_gian_hop_dong: Tính khoảng thời gian dài nhất
-- tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà khách hàng đã thực hiện thuê dịch vụ
-- (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ,
-- không xét trên toàn bộ các lần làm hợp đồng). Mã của khách hàng được truyền vào như là 1 tham số của function này.

delimiter //
create function func_tinh_thoi_gian_hop_dong(p_ma_khach_hang int)
returns int
deterministic
begin
	declare so_ngay int;
	select max(tong_ngay) into so_ngay from ( select date(hd.ngay_ket_thuc) - date(hd.ngay_lam_hop_dong) as tong_ngay
	from hop_dong hd
	where hd.ma_khach_hang = p_ma_khach_hang) g ;
    return so_ngay;
end //
delimiter ;

select func_tinh_thoi_gian_hop_dong(3) as thoi_gian_dai_nhat;

-- xóa functinon
drop function func_tinh_thoi_gian_hop_dong;

-- truy vấn max(tong_ngay)
select max(tong_ngay) from ( select date(hd.ngay_ket_thuc) - date(hd.ngay_lam_hop_dong) as tong_ngay
from hop_dong hd
where hd.ma_khach_hang = 10) as tmp;

-- 
select * from hop_dong;