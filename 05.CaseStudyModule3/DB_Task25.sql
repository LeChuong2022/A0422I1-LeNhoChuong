-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong
-- thì hiển thị tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.

create table `message`(
so_luong_hop_dong_con_lai int);

delimiter //
create trigger tr_xoa_hop_dong
after delete on hop_dong for each row
begin
	declare so_luong int;
	delete from `message`;
    set so_luong = (select count(*) from hop_dong);
    insert into message
    values (so_luong);     
end //
delimiter ;

-- xóa hợp đồng
delete from hop_dong
where ma_hop_dong = 10;
select * from `message`;

-- truy vấn hợp đồng
select * from hop_dong;

-- xóa trigger
drop trigger tr_xoa_hop_dong;

delete from `message`;
set sql_safe_updates = 0;

