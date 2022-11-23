-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select  kh.ma_khach_hang, kh.ho_ten , count(hd.ma_khach_hang) as so_lan_dat_phong 
from khach_hang kh 
inner join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
inner join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where lk.ten_loai_khach = 'Diamond'
group by hd.ma_khach_hang
order by so_lan_dat_phong asc;


-- test
-- select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach from khach_hang kh inner join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach;