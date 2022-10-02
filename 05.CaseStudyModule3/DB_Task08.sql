-- Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
-- cách 1:
 select kh.ho_ten 
 from khach_hang kh
 group by kh.ho_ten
 having count(*)=1;
 
 -- cách 2:
 select kh1.ho_ten
 from khach_hang kh1
 where kh1.ho_ten not in (select kh2.ho_ten from khach_hang kh2
	where( kh1.ho_ten = kh2.ho_ten) and kh1.ma_khach_hang != kh2.ma_khach_hang);
 
 -- cách 3:
 select kh1.ho_ten
 from khach_hang kh1
 where not exists (select kh2.ho_ten from khach_hang kh2
	where( kh1.ho_ten = kh2.ho_ten) and kh1.ma_khach_hang != kh2.ma_khach_hang);
 
 
