drop database sem1_pj_g4;
create database if not exists SEM1_PJ_G4;
use SEM1_PJ_G4;
create table if not exists Accounts(
staff_id int auto_increment primary key,
username varchar(100) unique not null,
pass varchar(100) not null,
staff_name varchar(100),
isAdmin int not null
);
insert into Accounts(username,pass,staff_name,isAdmin)values
('Nguyenquyetthang','16c0ce36e334e22fda8caca1b10c2f9c','thang',0),('TranVanHuan','16c0ce36e334e22fda8caca1b10c2f9c','huan',1),('NguyenVuHuan','16c0ce36e334e22fda8caca1b10c2f9c','huan',1);
select * from Accounts;

create table if not exists Stores(
store_id int auto_increment primary key,
store_name varchar(100) not null,
address varchar(100) not null,
phone char(15) unique
);
insert into Stores(store_name,address)values
('VTC academy HN','Ha Noi');

select *from Stores;
create table if not exists Discounts(
discount_id int auto_increment primary key,
discount_Value double check(discount_value>0),
percent tinyint not null ,
isActive tinyint default(0),
expiry date not null
);
insert into Discounts(discount_Value,percent,expiry)values
(1000,1,'2020-09-30');
select *from Discounts;
create table if not exists Products(
product_id varchar(100) primary key,
product_name varchar(200) unique not null,
product_Description varchar(800),
price decimal check(price>0),
left_quantity int check(left_quantity>=0),
stopSelling tinyint default (1),
supplier_id int ,
constraint fk_Products_Stores foreign key(supplier_id) references Stores(store_id)
);
insert into Products(product_id,product_name,price,left_quantity,supplier_id)values
('1001','my goi',3000,200,1),('10001','water can',5000,200,1),('10002','Snack Oshi',5000,200,1),('10003','Snack Oishi 150g ',10500,200,1),('10004','Aquafina',4000,200,1);
insert into Products(product_id,product_name,price,left_quantity,supplier_id)values
('1002','my goi 2',3000,200,1);
select *from Products;

create table if not exists Product_Discount(
product_id varchar(100) ,
discount_id int,
expiry date,
isEnable tinyint not null default(0),
primary key(product_id,discount_id)
);
insert into Product_Discount(product_id,discount_id)values
('1001',1);
select *from Product_Discount;
create table if not exists Invoices(
invoice_id int auto_increment primary key,
invoice_date datetime default current_timestamp,
store_id int,
staff_id int,
refund_order tinyint default(1),
constraint fk_Invoices_Accounts foreign key(staff_id) references Accounts(staff_id),
constraint fk_Invoices_Stores foreign key(store_id) references Stores(store_id)
);
insert into Invoices(staff_id,store_id)values
(1,1);
insert into Invoices(staff_id,store_id)values
(2,1);
select *from Invoices;
create table if not exists OrderDetail(
invoice_id int not null,
product_id varchar(100) not null,
quantity int default(0),
price double check(price>0),
discounted double,
refunded tinyint not null default(1),
primary key(invoice_id,product_id),
constraint fk_Detail_Product foreign key (product_id) references Products(product_id)
);
insert into OrderDetail(invoice_id,product_id,quantity,price,discounted)values
(1,'1001',1,100000,1000),(1,'1002',1,15000,0);
insert into OrderDetail(invoice_id,product_id,quantity,price,discounted)values
(2,'1001',1,100000,1000);
select * from OrderDetail;
create user if not exists'group4'@'localhost' identified by 'test' ;
grant all  on SEM1_PJ_G4.* to 'group4'@'localhost';
