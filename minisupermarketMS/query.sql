select * from (select X.product_id,unit ,product_name,product_Description,price,left_quantity,discount_Value from (select Products.product_id,unit,product_name,product_Description,price,left_quantity,discount_id,stopSelling,supplier_id from Products inner join Product_Discount on Products.product_id=Product_Discount.product_id) X inner join Discounts on X.discount_id=Discounts.discount_id)P where p.product_id=?;
select Products.product_id,unit,product_name,product_Description,price,left_quantity,discount_id,stopSelling,supplier_id from Products inner join Product_Discount on Products.product_id=Product_Discount.product_id where Products.product_id=1001;
select X.product_id,unit ,product_name,product_Description,price,left_quantity,discount_Value from (select Products.product_id,unit,product_name,product_Description,price,left_quantity,discount_id,stopSelling,supplier_id from Products inner join Product_Discount on Products.product_id=Product_Discount.product_id) X inner join Discounts on X.discount_id=Discounts.discount_id where X.product_id=1001;

select * from (select X.product_id,unit ,product_name,product_Description,price,left_quantity,discount_Value from (select Products.product_id,unit,product_name,product_Description,price,left_quantity,discount_id,stopSelling,supplier_id from Products inner join Product_Discount on Products.product_id=Product_Discount.product_id) X inner join Discounts on X.discount_id=Discounts.discount_id)P where p.product_name like '%my%goi%';