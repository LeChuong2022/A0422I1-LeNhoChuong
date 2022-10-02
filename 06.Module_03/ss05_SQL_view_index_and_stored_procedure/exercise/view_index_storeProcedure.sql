-- B1.TẠO CƠ SỞ DỮ LIỆU
create database demo_view_index_store_procedure;
use demo_view_index_store_procedure;
-- B2.TẠO BẢNG PRODUCTS VÀ CHÈN DỮ LIỆU
	-- B2.1. Tạo bảng
create table products(
id int auto_increment primary key,
productCode varchar(50),
productName varchar(50),
productPrice double,
productAmount int,
productDescription varchar(100),
productStatus bit
);

	-- B2.2. Chèn dữ liệu
insert into products
values 	(1, 'apple_13', 'apple', 1000, 10, 'Điện thoại iphone 13', 1),
		(2, 'apple_14', 'apple', 1200, 5, 'Điện thoại iphone 14', 1),
        (3, 'samsung_s21', 'samsung', 800, 20, 'Điện thoại samsung S21', 1),
        (4, 'samsung_s22', 'samsung', 1100, 5, 'Điện thoại samsung S22', 1),
        (5, 'samsung_s20', 'samsung', 700, 4, 'Điện thoại samsung S20', 1),
        (6, 'samsung_A7', 'samsung', 600, 8, 'Điện thoại samsung A7', 1),
        (7, 'samsung_A8', 'samsung', 650, 5, 'Điện thoại samsung A8', 1),
        (8, 'samsung_A10', 'samsung', 680, 9, 'Điện thoại samsung A10', 1),
        (9, 'samsung_J7', 'samsung', 300, 11, 'Điện thoại samsung J7', 1),
        (10, 'samsung_J8', 'samsung', 350, 5, 'Điện thoại samsung J8', 0),
        (11, 'samsung_J9', 'samsung', 400, 15, 'Điện thoại samsung J9', 1),
        (12, 'samsung_J10', 'samsung', 500, 25, 'Điện thoại samsung J10', 0),
        (13, 'xiaomi_N10', 'xiaomi', 720, 13, 'Điện thoại xiaomi Note 10', 1),
        (14, 'xiaomi_N9', 'xiaomi', 7.0, 11, 'Điện thoại xiaomi Note 9', 1);

-- B3.
		-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
		explain select * from products where productCode = 'apple_13';
		-- 1	SIMPLE	products		ALL					rows=14	10.00	Using where
		explain select * from products where productName = 'samsung';
		-- 1	SIMPLE	products		ALL					rows=14	10.00	Using where
		explain select * from products where productPrice = 300;
		-- 1	SIMPLE	products		ALL					rows=14	10.00	Using where

	-- B3.1. TẠO UNIQUE INDEX
	-- C1: alter table products add index idx_productCode (productCode);
create unique index idx_productCode on products (productCode);
explain select * from products where productCode = 'apple_13';
-- 1	SIMPLE	products		ref	idx_productCode	idx_productCode	203	const	rows = 1	100.00	
explain select * from products where productName = 'samsung';
-- 1	SIMPLE	products		ALL					rows=14	10.00	Using where
explain select * from products where productPrice = 300;
-- 1	SIMPLE	products		ALL					rows=14	10.00	Using where

	-- XÓA CHỈ MỤC
alter table products drop index idx_productCode;

	-- B3.2 TẠO COMPOSITE INDEX TRÊN BẢNG PRODUCTS (SỬ DỤNG 2 CỘT PRODUCTNAME VÀ PRODUCTPRICE)
create index idx_productNameAndPrice on products (productName, productPrice);
explain select * from products where productName = 'samsung';
-- 1	SIMPLE	products		ref	idx_productNameAnndPrice	idx_productNameAnndPrice	203	const	rows = 10	100.00	
explain select * from products where productPrice = 300;
-- 1	SIMPLE	products		ALL					14	10.00	Using where
explain select * from products where productName = 'samsung' and productPrice = 300;
alter table products drop index idx_productNameAndPrice;

-- B4. 
	-- B4.1, TẠO VIEW
create view w_products as
select productCode, productName, productPrice, productStatus
from products;

		-- xem view
		select * from w_products;
	-- B4.2. SỬA VIEW
update w_products wP
set wP.productPrice = 900 
where wP.productCode = 'apple_13';
		-- xem bảng products
		select * from products;
    
	-- B4.3. XÓA VIEW
drop view w_products;

-- B5
	-- B5.1 Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure getInformationOfProducts()
begin
	select * from products;
end //
delimiter ;
		-- gọi store prcedure
        call getInformationOfProducts();
        
	-- B5.2 Tạo sotre procedure thêm một sản phẩm mới
delimiter //
create procedure addMoreProduct(in productCode_temp varchar(50),
productName_temp varchar(50),
productPrice_temp double,
productAmount_temp int,
productDescription_temp varchar(100),
productStatus_temp bit)
begin
	insert into products (productCode,  productName, productPrice, productAmount, productDescription, productStatus)
    values (productCode_temp,  productName_temp, productPrice_temp, productAmount_temp, productDescription_temp, productStatus_temp); 
end //
delimiter ;
		-- gọi store prcedure
        call addMoreProduct('sony_10', 'sony', 810, 3, 'Điện thoại sony 10', 1);
		-- xóa procedure
        drop procedure addMoreProduct;
        
	-- B5.3 Tạo sotre procedure sửa thông tin sản phẩm theo ID
delimiter //
create procedure modifyProduct(in idInput int, 
productCode_temp varchar(50),
productName_temp varchar(50),
productPrice_temp double,
productAmount_temp int,
productDescription_temp varchar(100),
productStatus_temp bit)
begin
	update products
    set	productCode = productCode_temp,
		productName = productName_temp,
		productPrice = productPrice_temp,
        productAmount = productAmount_temp,
        productDescription = productDescription_temp,
        productStatus = productStatus_temp
	where id = idInput;
end//
delimiter ;

		-- gọi store prcedure
        call modifyProduct(4, 'sony_8', 'sony', 710, 3, 'Điện thoại sony 10', 1);

	-- B5.4 Tạo sotre procedure xóa sản phẩm theo id
delimiter //
create procedure deleteProduct(in idDelete int)
begin
	delete from products
    where id = idDelete;
end//
delimiter ;
	-- gọi store procedure
    call deleteProduct(15);



        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        