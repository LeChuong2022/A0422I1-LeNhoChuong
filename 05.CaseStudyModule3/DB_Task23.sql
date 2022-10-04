-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó
-- với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.

delimiter //
create procedure sp_xoa_khach_hang (in ma_khach_hang_temp int)
begin
	delete from khach_hang
    where ma_khach_hang = ma_khach_hang_temp;
end//
delimiter ;

-- xóa khách hàng
call sp_xoa_khach_hang (11);


-- thêm khách hàng
insert into khach_hang
values (11, 1 ,'Hoàng Phi Hồng', '1988-09-05', 1, '201555444', '0987789012', 'honghp@gmail.com', '38 Nguyễn Huệ, Quận 1, TP Hồ Chí Mình');

-- truy vấn khách hànng
select * from khach_hang;