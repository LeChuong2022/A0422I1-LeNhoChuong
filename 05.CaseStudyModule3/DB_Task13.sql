-- Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) so_luong_dich_vu_di_kem from
dich_vu_di_kem dvdk inner join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by hdct.ma_dich_vu_di_kem
having so_luong_dich_vu_di_kem >= all(select sum(hdct_a.so_luong) sum_so_luong from hop_dong_chi_tiet hdct_a group by hdct_a.ma_dich_vu_di_kem);

