
delimiter //
create procedure get_employee_by_id (in id int)
begin
	select * from employee
    where employee_id = id;
end//
delimiter ;

call get_employee_by_id(2);

drop procedure select_employee;


-- cập nhật employee chưa làm được
delimiter //
create procedure get_employee_by_id (in id int)
begin
	select * from employee
    where employee_id = id;
end//
delimiter ;

call get_employee_by_id(2);

drop procedure select_employee;

-- gọi sản phẩm
delimiter //
create procedure get_product_by_id (in id int)
begin
	select * from product
    where product_id = id;
end//
delimiter ;

call get_product_by_id(1);
