select * from customers where customerName = 'Land of Toys Inc.';

-- dùng explain
explain select * from customers where customerName = 'Land of Toys Inc.';

-- Thêm chỉ mục cho bảng customers
alter table customers add index idx_customerName(customerName);

-- dùng laji explain
explain select * from customers where customerName = 'Land of Toys Inc.';

-- thêm index cho cặp contactFirstName và contactLastName
alter table customers add index idx_full_name(contactFirstName, contactLastName);
explain select * from customers where contactFirstName = 'Jean' or contactFirstName = 'King';

-- xóa chỉ mục trong bảng:
alter table customers drop index idx_full_name;
alter table customers drop index idx_customerName;
