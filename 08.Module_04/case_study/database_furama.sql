create database furama_module4;

insert into furama_module4.`account`
values	('admin',  '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu'),
		('user', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu');
        

insert into furama_module4.`role`
values 	(1, 'ROLE_ADMIN'),
		(2, 'ROLE_USER');
        
insert into furama_module4.account_role
values 	(1,'admin',1),
		(2,'admin',2),
        (3,'user',2);
        
insert into furama_module4.education_degree
values 	(1, 'Trung cấp'),
		(2, 'Cao đẳng'),
		(3, 'Đại học'),
        (4, 'Sau đại học');
        
insert into furama_module4.position
values	(1, 'Lễ tân'),
		(2, 'Phục vụ'),
        (3, 'Chuyên viên'),
        (4, 'Giám sát'),
        (5, 'Quản lý'),
        (6, 'Giám đốc');
        
insert into furama_module4.division
values 	(1, 'Sale - Marketing'),
		(2, 'Hành chính'),
        (3, 'Phục vụ'),
        (4, 'Quản lý');
        
insert into furama_module4.customer_type
values	(1, 'Diamond'),
		(2, 'Plantinum'),
        (3, 'Gold'),
        (4, 'Silver');
        
--

insert into furama_module4.rent_type
values 	(1, 'year', 12000),
		(2, 'month', 1100),
        (3, 'day', 100),
        (4, 'hour', 10);
        
insert into furama_module4.service_type
values 	(1, 'Villa'),
		(2, 'House'),
        (3, 'Room');

insert into furama_module4.attach_service
values 	(1, 50, 'còn', 10, 'Massage'),
		(2, 30, 'còn', 5, 'Karaoke'),
        (3, 10, 'còn', 10, 'Food'),
        (4, 5, 'còn', 10, 'Water'),
        (5, 10, 'còn', 10, 'Thuê xe');
        
insert into furama_module4.customer
values (2,'Quảng Nam', '1970-11-30', 'tuantt@gmail.com', 1, '205333222', 'Tuấn', '0971486153', 1);

insert into furama_module4.customer (customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id)
values	('Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', 4),
		('Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị', 3),
        ('Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh', 1),
        ('Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng', 1),
        ('Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai', 4),
        ('Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng', 4),
        ('Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh', 1),
        ('Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum', 3),
        ('Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi', 1),
        ('Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng', 2);
        
        -- lấy giá trị cuối cùng
        select customer_id from customer ORDER BY customer_id DESC LIMIT 1;
        
        select e.id from Employee as e order by e.id desc limit 1
        
        
        
        
        
        
        
        
        
        
        
        
        