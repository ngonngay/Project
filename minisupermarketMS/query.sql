select * from (select X.product_id,unit ,product_name,product_Description,price,left_quantity,discount_Value from (select Products.product_id,unit,product_name,product_Description,price,left_quantity,discount_id,stopSelling,supplier_id from Products inner join Product_Discount on Products.product_id=Product_Discount.product_id) X inner join Discounts on X.discount_id=Discounts.discount_id)P where p.product_id=?;
select Products.product_id,unit,product_name,product_Description,price,left_quantity,discount_id,stopSelling,supplier_id from Products inner join Product_Discount on Products.product_id=Product_Discount.product_id where Products.product_id=1001;
select X.product_id,unit ,product_name,product_Description,price,left_quantity,discount_Value from (select Products.product_id,unit,product_name,product_Description,price,left_quantity,discount_id,stopSelling,supplier_id from Products inner join Product_Discount on Products.product_id=Product_Discount.product_id) X inner join Discounts on X.discount_id=Discounts.discount_id where X.product_id=1001;
select Invoices.invoice_id,invoice_date,store_name,address,OrderDetail.product_id,product_name,OrderDetail.price,OrderDetail.quantity,OrderDetail.discounted,OrderDetail.refunded  from (Stores inner join Invoices on Invoices.store_id=Stores.store_id inner join OrderDetail on Invoices.invoice_id=OrderDetail.invoice_id inner join Products on OrderDetail.product_id=Products.product_id)   where Invoices.invoice_id=?;
select * from (select X.product_id,unit ,product_name,product_Description,price,left_quantity,discount_Value from (select Products.product_id,unit,product_name,product_Description,price,left_quantity,discount_id,stopSelling,supplier_id from Products inner join Product_Discount on Products.product_id=Product_Discount.product_id) X inner join Discounts on X.discount_id=Discounts.discount_id)P where p.product_name like '%%%%%%%%%%%%my%%%%%%%%%%%%%%%%goi%%%%%%';
select * from Products where product_name like '%my%goi%';
select Invoices.invoice_id,invoice_date,store_name,address,OrderDetail.product_id,product_name,OrderDetail.price,OrderDetail.quantity,OrderDetail.discounted,OrderDetail.refunded  from (Stores inner join Invoices on Invoices.store_id=Stores.store_id inner join OrderDetail on Invoices.invoice_id=OrderDetail.invoice_id inner join Products on OrderDetail.product_id=Products.product_id)   where invoice_date between '2020-9-10 00:00:00' and '2020-9-11 00:00:00';
select * from (select invoice_id,invoice_date,store_id,invoices.staff_id,staff_name from Invoices inner join Accounts on invoices.staff_id=Accounts.staff_id) X where X.invoice_date between '2020-9-10 00:00:00' and '2020-9-11 00:00:00';
select * from invoices where invoice_date between '2020-01-1 00:00:00' and '2020-09-14 23:59:59';
select * from (select invoice_id,invoice_date,store_id,invoices.staff_id,staff_name from Invoices inner join Accounts on invoices.staff_id=Accounts.staff_id) X where X.invoice_date between '2020-01-1 00:00:00' and '2020-09-13 00:00:00'
;
select * from Accounts;
insert into Accounts(username,pass,staff_name,isAdmin)values
('Nguyenquyetthang2','16c0ce36e334e22fda8caca1b10c2f9c','thang2',1);
select invoice_id,invoice_date,store_id,invoices.staff_id,staff_name from Invoices inner join Accounts on invoices.staff_id=Accounts.staff_id;
delete from Accounts where username='Nguyenquyetthang2';
select isAdmin from Accounts where username='Nguyenquyetthang2';
update Accounts set pass='abcbhajsbhdjbhjasdbhjsdabhjasbhja' where username='Nguyenquyetthang2';
insert into Accounts(username,pass,staff_name,isAdmin)values
('Nguyenquyetthang3','16c0ce36e334e22fda8caca1b10c2f9c','thang2',0);
update Accounts set staff_name='nguyen quyet thang',isAdmin=0 where username='Nguyenquyetthang2';
