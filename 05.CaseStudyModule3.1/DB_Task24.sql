-- 24. Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới
-- vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện
-- kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được
-- trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

delimiter //
create procedure sp_them_moi_hop_dong (
in p_ma_hop_dong int, 
in p_ngay_lam_hop_dong datetime,
in p_ngay_ket_thuc datetime,
in p_tien_dat_coc double,
in p_ma_nhan_vien int,
in p_ma_khach_hang int, 
in p_ma_dich_vu int)
begin
	if p_ma_hop_dong in (select ma_hop_dong from hop_dong) then
   	signal sqlstate '45000' set message_text = 'Vui lòng nhập mã hợp đồng không trùng với mã hiện có';
    elseif (p_ngay_lam_hop_dong is null or p_ngay_ket_thuc is null or date(p_ngay_ket_thuc) < date(p_ngay_lam_hop_dong)) then
    signal sqlstate '45000' set message_text = 'Vui lòng nhập ngày làm hợp đồng và ngày kết thúc hợp lệ';
    elseif p_ma_nhan_vien not in (select ma_nhan_vien from nhan_vien) then
    signal sqlstate '45000' set message_text = 'Vui lòng nhập mã nhân viên đã có';
	elseif p_ma_khach_hang not in (select ma_khach_hang from khach_hang) then
	signal sqlstate '45000' set message_text = 'Vui lòng nhập mã khách hàng đã có';
    elseif p_ma_dich_vu not in (select ma_dich_vu from dich_vu) then
   	signal sqlstate '45000' set message_text = 'Vui lòng nhập mã dịch vụ đã có';
    else
	insert into hop_dong
    values (
    p_ma_hop_dong, -- if(p_ma_hop_dong not in (select ma_hop_dong from hop_dong), 0, p_ma_hop_dong),
    p_ngay_lam_hop_dong,
    p_ngay_ket_thuc,
    p_tien_dat_coc,
    p_ma_nhan_vien, -- if(p_ma_nhan_vien in (select ma_nhan_vien from nhan_vien), 0, p_ma_nhan_vien),
    p_ma_khach_hang, -- if(p_ma_khach_hang in (select ma_khach_hang from khach_hang), 0, p_ma_khach_hang),
    p_ma_dich_vu -- if(p_ma_dich_vu in (select ma_dich_vu from dich_vu), 0, p_ma_dich_vu)----
    );
    select 'Đã cập nhật thành công' as Ket_qua;
    end if;
end //
delimiter ;

call sp_them_moi_hop_dong (12, '2022-09-10', '2022-09-13', 0, 8, 9, 6);

-- truy vấn hợp đồng
select * from hop_dong;

-- xóa sp - hợp đồng
drop procedure sp_them_moi_hop_dong;

-- xóa hợp đồng số 13
delete from hop_dong
where ma_hop_dong = 13;





