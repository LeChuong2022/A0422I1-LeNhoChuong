-- Tạo MySQL stored procedure đầu tiên
-- delimiter dùng để phân cách bộ nhớ lữu trữ thủ tục cache và mở rộng một ô lưu trữ mới
delimiter //

create procedure findAllCustomers()
Begin
	select * from customers;
end //
delimiter ; -- đóng lại ô lưu trữ

-- Cách gọi procedure
call findAllCustomers();

-- Sửa procedure
-- Trong MySQL ko cung cấp lệnh sửa stored nên thông thường chúng ta sẽ chạy lệnh tạo mới
-- Lệnh drop để xóa đi procedure đó và tạo lại:
delimiter //
drop procedure if exists `findAllCustomers`;
create procedure findAllCustomers()
begin
	select * from customers where customerNumber = 175;
end //
Delimiter ;

call findAllCustomers();