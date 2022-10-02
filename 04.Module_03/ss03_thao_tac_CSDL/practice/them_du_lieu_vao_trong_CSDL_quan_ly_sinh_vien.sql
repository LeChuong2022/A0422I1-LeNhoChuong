-- 1.Su dclassIDung cau lenh use de su dung CSDL
use QuanLySinhVien;

-- 2. them thong tin vao bang class
insert into class
value (1, 'A1', '2008-12-20', 1);
insert into class
value (2, 'A2', '2008-12-22', 1);
insert into class
value (3, 'A3', current_date, 0);

-- 3. them du lieu vao bang student
insert into student (studentName, address, phone, `status`, classID)
value ('Hung', 'Ha Noi', '0912113113', 1, 1);
insert into student (studentName, address, `status`, classID)
value ('Hoa', 'Hai Phong', 1, 1);
insert into student (studentName, address, phone, `status`, classID)
value ('Manh', 'HCM', '0123123123', 0, 2);

-- 4.Them du lieu nhanh vao bang Subject
insert into `subject` 
values 	(1, 'CF', 5, 1),
		(2, 'C', 6, 1),
        (3, 'HDJ', 5, 1),
        (4, 'RDBMS', 10, 1);
        
-- 5.Them du lieu nhanh vao trong bang Mark bang cau lenh insert into:
insert into mark(subID, studentID, mark, examTimes)
values	(1, 1, 8, 1),
		(1, 2, 10, 2),
        (2, 1, 12, 1);
