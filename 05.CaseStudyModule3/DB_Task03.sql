-- Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select ma_khach_hang, ho_ten from CaseStudy_Furama.khach_hang
where (round(datediff(curdate(), ngay_sinh)/365,0) between 18 and 50) and (dia_chi like '%Đà Nẵng' or dia_chi like '%Quảng Trị');


-- *truy vấn tuổi
-- select ma_khach_hang, ho_ten, round(datediff(curdate(), ngay_sinh)/365,0) as year from CaseStudy_Furama.khach_hang;