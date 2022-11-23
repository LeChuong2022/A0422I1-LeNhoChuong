insert into position (position_name)
values ( 'Quản lý'),
		( 'Nhân viên');

insert into education_degree (education_degree_name)
values ('Trung Cấp'),
		('Cao Đẳng'),
        ('Đại Học'),
        ('Sau đại học');

insert into division (division_name)
values ('Sale-Marketing'),
		('Hành chính'),
        ('Phục vụ'),
        ('Quản lý');
        
insert into user
values ("An.nv", "1234"),
		("Binh.lv", "1234"),
		("Yen.ht", "1234"),
		("Toan.vc", "1234"),
		("Phat.nb", "1234"),
		("Nghi.nka", "1234"),
		("Ha.nh", "1234"),
		("Dong.nh", "1234"),
		("Hoang.t", "1234"),
		("Dao.nc", "1234");

insert into user
values ("Cln.nv", "1234");

insert into employee (
employee_name ,
employee_birthday ,
employee_id_card ,
employee_salary ,
employee_phone ,
employee_email ,
employee_address ,
position_id ,
education_degree_id ,
division_id ,
username )
values ('Nguyễn Văn An', '1970-11-07', '456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1, "An.nv"),
		('Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2, "Binh.lv"),
        ('Hồ Thị Yến', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2, "Yen.ht"),
        ('Võ Công Toản', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4, "Toan.vc"),
        ('Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1, "Phat.nb"),
        ('Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3, "Nghi.nka"),
        ('Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2, "Ha.nh"),
        ('Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4, "Dong.nh"),
        ('Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4, "Hoang.t"),
        ('Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2, "Dao.nc");
        
-- Update ( sửa thông tin)

update employee set employee_name = 'Nguyễn Văn An', employee_birthday = '1985-10-10', employee_id_card = '123131',
            employee_salary = 1, employee_phone = '0901234121', employee_email = 'thiyen@gmail.com', employee_address = '77 Hoàng Diệu, Quảng Trị', position_id = 1, education_degree_id = 1, division_id = 1, username = '54535345345' 
            where employee_id = 17;
        
 
update employee set employee_name = 'Nguyễn Công Đạo', employee_birthday = '1985-10-10', employee_id_card = '123131',
            employee_salary = 1, employee_phone = '0901234121', employee_email = 'thiyen@gmail.com', employee_address = '77 Hoàng Diệu, Quảng Trị', position_id = 1, education_degree_id = 1, division_id = 1
            where employee_id = 17;
 
 set sql_safe_updates = 1;