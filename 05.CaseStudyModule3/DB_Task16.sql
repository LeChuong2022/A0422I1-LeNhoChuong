-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
-- tắt Safe mode
set sql_safe_updates = 0;

delete from nhan_vien nv
where nv.ma_nhan_vien not in (
	select * from(
	select distinct nv_a.ma_nhan_vien 
    from nhan_vien nv_a left join hop_dong hd on nv_a.ma_nhan_vien = hd.ma_nhan_vien
    where year (hd.ngay_lam_hop_dong) between 2019 and 2021) as t
    );

    
    


-- truy vấn  nhân viên
select * from nhan_vien;


-- thêm
insert into trinh_do (ten_trinh_do)
values ('congcongcong');

select * from trinh_do;
-- xóa 
delete  from trinh_do td
where td.ma_trinh_do = 8;

