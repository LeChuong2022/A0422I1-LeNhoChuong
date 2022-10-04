-- 28.	Tạo Stored Procedure sp_xoa_dich_vu_va_hd_room để tìm các dịch vụ được thuê bởi khách hàng
-- với loại dịch vụ là “Room” từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó
-- (tức là xóa các bảng ghi trong bảng dich_vu) và xóa những hop_dong sử dụng dịch vụ liên quan
-- (tức là phải xóa những bản ghi trong bảng hop_dong) và những bản liên quan khác.

delimiter //
create procedure sp_xoa_dich_vu_va_hd_room()
begin
	-- tạo bảng tạm temp
    drop table if exists `tempDraft`;
	create table tempDraft(
    ma_dich_vu int,
    ma_hop_dong int);
    -- gán giá trị vào bảng tạm
    insert into tempDraft (
			select distinct dv.ma_dich_vu, hd.ma_hop_dong from dich_vu dv
			inner join hop_dong hd using (ma_dich_vu)
			where dv.ma_dich_vu in (select dv_a.ma_dich_vu from dich_vu dv_a inner join loai_dich_vu ldv_a using(ma_loai_dich_vu) where ldv_a.ten_loai_dich_vu = 'room')
			and year(hd.ngay_lam_hop_dong) between 2015 and 2020);
    -- xóa dịch vụ
    set foreign_key_checks = 0;
    delete from dich_vu dv
    where dv.ma_dich_vu in (select t.ma_dich_vu from tempDraft t);
    -- xóa hợp đồng
    delete from hop_dong hd
    where hd.ma_dich_vu in (select t.ma_dich_vu from tempDraft t);
    -- xóa hợp đồng chi tiết
    delete from hop_dong_chi_tiet hdct
    where hdct.ma_hop_dong in (select t.ma_hop_dong from tempDraft t);
    set foreign_key_checks = 1;
    -- xóa bảng tạm
    drop table tempDraft;
end //
delimiter ;

call sp_xoa_dich_vu_va_hd_room();

-- xóa procedure
drop procedure sp_xoa_dich_vu_va_hd_room;

-- truy vấn dich_vu
select * from dich_vu;
select * from hop_dong;
select * from hop_dong_chi_tiet;

-- drop database
-- drop database casestudy_furama;

-- truy vấn
select dv.ma_dich_vu from dich_vu dv where dv.ten_dich_vu like 'room%';

select distinct dv.ma_dich_vu, hd.ma_hop_dong from dich_vu dv
inner join hop_dong hd using (ma_dich_vu)
where dv.ma_dich_vu in (select dv_a.ma_dich_vu from dich_vu dv_a inner join loai_dich_vu ldv_a using(ma_loai_dich_vu) where ldv_a.ten_loai_dich_vu = 'room')
and year(hd.ngay_lam_hop_dong) between 2015 and 2020;