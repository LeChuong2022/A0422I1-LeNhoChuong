-- Tham số loại in
delimiter //
 -- drop procedure if exists `getCusByID`;
create procedure getCusByID
(in cusNum int(11))
begin
	select * from customers where customerNumber = cusNum;
end //
delimiter ;

-- Gọi store procedure
call getCusByID(175);

-- Tham số loại out
delimiter //
create procedure getCustomersCountByCity(
	in in_city varchar(50),
    out total int
)
begin
	select count(customerNumber)
    into total
    from customers
    where city = in_city;
end //
delimiter ;

-- Gọi store procedure
call getCustomersCountByCity('Lyon',@total);
select @total;

-- Tham số loại inout
delimiter //
create procedure setCounter(
	inout counter int,
    in inc int
)
begin
	set counter = counter + inc;
end//
delimiter ;

-- gọi store procedure
set @counter = 1;
call setcounter(@counter, 1); -- 2
call setcounter(@counter, 1); -- 3
call setcounter(@counter, 5); -- 8
select @counter; -- 8


