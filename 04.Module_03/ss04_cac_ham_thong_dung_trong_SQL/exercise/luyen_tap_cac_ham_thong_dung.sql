-- 1.Su dung use
use QuanLySinhVien;

-- 2.Hien thi tat ac cac thong tn mon hoc co credit lon nhat
select s.SubID, s.SubName, s.Credit
from `subject` s 
where s.credit = (select max(s.credit) from `subject` s);

-- 3.Hienn thi tat ca cac mon hoc co diem thi lon nhat
select s.SubID, s.SubName, m.Mark
from `subject` s inner join mark m on s.subID = m.subID
where m.mark >= (select max(mark) from mark);

-- 4.Hien thi cac thong tin sinh vien va diem trung binh cua moi sinh vien,
-- xep hanng theo thu tu diem giam dan
select s.StudentID, s.studentName, avg(mark) as `avg mark`
from student s inner join mark m on s.studentID = m.studentID
group by s.studentID
order by avg(mark) desc;

-- sua lai diem 
update mark
set mark = 4 
where markID = 1;
