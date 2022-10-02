-- 1.Su dung use 
use QuanLySinhVien;

-- 2.Hien thi so luong sinh vien o tung noi
select s.address, count(s.studentID) as SoLuongHocVien from student s
group by address;

-- 3.Tinh diem trung binh cac mon hoc cua hoc vien
select s.studentID, s.studentName, avg(m.mark) 
from student s inner join mark m on s.studentID = m.studentID
group by s.studentID, s.studentName;

-- 4.Hien thi nhung ban hoc vien co diem trung binh mon hoc lon hon 15
select s.studentID, s.studentName, avg(m.mark)
from student s inner join mark m on s.studentID = m.studentID
group by s.studentID
having avg(m.mark) >15;

select s.studentID, s.studentName, avg(mark) as `avg`
from student s inner join mark m on s.studentID = m.studentID
group by s.studentID
having avg(mark) >= all (select avg(mark) from mark m group by m.studentID);