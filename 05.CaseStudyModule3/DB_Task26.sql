-- 26.	Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng,
-- cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau: 
-- Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày.
-- Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra
-- thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.

delimiter //
create trigger tr_cap_nhat_hop_dong
before update 
on hop_dong for each row
begin
	declare errorMessage varchar(100);
	set errorMessage = concat('Giá trị ngày kết thúc nhập mới ', new.ngay_ket_thuc, ' không hơn ngày làm hợp đồng 2 ngày');
    if ((date(new.ngay_ket_thuc) - date(new.ngay_lam_hop_dong)) <2)then
		signal sqlstate '45000' set message_text = errorMessage;
	end if;
end //
delimiter ;

update hop_dong
set ngay_ket_thuc = '2022-09-12'
where ma_hop_dong = 15;

-- xóa trigger
drop trigger tr_cap_nhat_hop_dong;

-- truy vấn hợp đồng
select * from hop_dong;

select date(hd.ngay_ket_thuc) - date(hd.ngay_lam_hop_dong) from hop_dong hd where ma_hop_dong = 16;
