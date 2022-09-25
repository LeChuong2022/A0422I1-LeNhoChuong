use QuanLyBanHang;

-- 1.Them du lieu vao bang customer
insert into customer
value (1, 'Minh Quan', 10);
insert into customer
value (2, 'Ngoc Oanh', 20);
insert into customer
value (3, 'Hong Ha', 50);

-- 2.Them du lieu vao bang order
insert into `order`(oID, cID, oDate)
values 	(1, 1, '2006-3-21'),
		(2, 2, '2006-3-23'),
        (3, 1, '2006-3-16');
        
-- 3.Them du lieu vao  banng product
insert into product
values	(1, 'May Giat', 3),
		(2, 'Tu Lanh', 5),
        (3, 'Dieu Hoa', 7),
        (4, 'Quat', 1),
        (5, 'Bep Dien', 2);
        
-- 4.Them bang orderDetail
insert into orderDetail
values	(1, 1, 3),
		(1, 3, 7),
		(1, 4, 2),
        (2, 1, 1),
        (3, 1, 8),
        (2, 5, 4),
        (2, 3, 3);
        
-- 5.Hien thi cac thong tin gom oID, oDate, oPrice cua tat ca hoa don trong bang Order
select oID, oDate, oTotalPrice from `order`;

-- pre6.Hien thi cac bang
select * from customer;
select * from `order`;
select * from product;
select * from orderDetail;

-- 6.Hien thi danh sach cac khach hang da mua hang va danh sach san pham duoc boi cac khach
select c.cName, p.pName from
customer c inner join `order` o on c.cID = o.cID
inner join orderDetail oD on o.oID = oD.oID
inner join product p on p.pID = oD.pID;

-- 7.Hien thi nhung khach hang khong mua bat ky 1 san pham nao
select c.cName from
customer c left join `order` o on c.cID = o.cID
where o.oID is null;

-- 8.Hien thi ma hoa don, ngay ban, gia tien cua tung hoa don
select o.oID, o.oDate, (oD.odQTY * p.pPrice) as oTotalPrice
from `order` o inner join orderDetail oD on o.oID = oD.oid
inner join product p on od.PiD = p.pID;

