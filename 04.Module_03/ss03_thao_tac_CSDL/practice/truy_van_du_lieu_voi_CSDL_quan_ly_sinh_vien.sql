-- 1.Su dung cau lenh Use QuanLySinhVien de su dung CSDL
use QuanLySinhVien;

-- 2.Su dung cau lenh select* va lay du lieu hoc vien tu bang student 
select * from student;

-- 3.Hien thi danh sach hoc vien dang theo hoc
select * from student where status = true;

-- 4.Hien thi danh sach cac mon hoc co thoi gian nho hon 10
select * from `subject` where credit < 10;

-- 5.Su dung cau lenh join va where de hien thi danh sach hoc vien lop A1
select s.studentID, s.studentName, c.className
from student s join class c on s.classID = c.classID
where c.className = 'A1';

-- 6.Hien thi diem mon CF cua cac hoc vien
select s.studentID, s.studentName, sub.subName, m.mark
from student s join mark m on s.studentID = m.studentID
join `subject` sub on m.subID = sub.subID
where sub.subName = 'CF';



