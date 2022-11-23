-- trigger thêm liên quan

delimiter //
create trigger update_user  -- tên trigger
before insert 				-- trước insert
on employee for each row	-- tên bảng tăng
begin
	insert into user (userName)
    values (new.username);		-- neww là mới
end //
delimiter ;

-- trigger xóa liên quan

delimiter //
create trigger delete_user  -- tên trigger
after delete 				-- sau delete
on employee for each row	-- tên bảng xóa
begin
	delete from user where username = old.username;
end //
delimiter ;

-- trigger sửa lam ko duoc

delimiter //
create trigger edit_user -- tên trigger
before update
on employee for each row -- tên bảng thay đổi
begin
	SET FOREIGN_KEY_CHECKS=0;
	update user set username = new.username
    where username = old.username;
	SET FOREIGN_KEY_CHECKS=1;
    end //
delimiter ;

drop trigger edit_user;
drop trigger before_edit_user;
drop trigger after_edit_user;
