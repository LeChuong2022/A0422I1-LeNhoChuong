use QuanLySinhVien;

-- 1.Hien thi tat ca cac sinh vien bat dau bang ky tu 'h'
select * from student where studentName like 'h%';

-- 2.Hien thi cac thong tin lop hoc co thoi gian bat dau vao thanng 12
select * from class where startDate like '%-12-%';

-- 3.Hien thi cac thong tin mon hoc co credit trong khoang 3-5
select * from `subject` where credit between 3 and 5;

-- 4.Thay doi ma lop (classID) cua sinh vien ten 'Hung' la 2
update student s
set classID = 2 
where s.studentName = 'hung';
-- Tat safe update mode
set sql_safe_updates = 0;

-- 5.Hien thi cac thong tin: studentName, subName, Mark. Sap xep mark giam dan, neu trung sap theo ten tang dan
select s.studentName, sub.subName, m.mark
from student s left join mark m on s.studentID = m.studentID
left join  `subject` sub on sub.subID = m.subID
order by m.mark desc, s.studentName asc;





