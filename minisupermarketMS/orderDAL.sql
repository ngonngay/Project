select *from Invoices where invoice_id=4;
select invoice_id,OrderDetail.product_id, Products.product_name, OrderDetail.price,OrderDetail.quantity, discounted,refunded,product_Description,left_quantity,unit from OrderDetail inner join Products on Products.product_id=OrderDetail.product_id where invoice_id=3;
select * from Accounts where staff_id=1;
select * from Stores where store_id=1;