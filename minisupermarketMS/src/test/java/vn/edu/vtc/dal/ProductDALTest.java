package vn.edu.vtc.dal;

import org.junit.Assert;
import org.junit.Test;
import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.persistance.Product;

public class ProductDALTest {
    ProductBL productBL=new ProductBL();
    @Test
    public void getProductById(){
        //corrrect id
        Product product=productBL.getById("1001");
        Product expected=new Product("1001","phobo",20000.0,null,null,"da update",20,1,1,null);
        Assert.assertTrue(product.equals(expected));
    }
    @Test
    public void getProductById2(){
        //wrong id
        Product product=productBL.getById("1");
        Assert.assertNull(product);
    }

    @Test
    public  void insertProduct(){
        //Already existed
        Product p=new Product("1001","my goi 5",10000.,"update from java app",10,1,"my goi");
        Assert.assertFalse(productBL.insertProduct(p));
    }

    @Test
    public void updatePrice(){
        //valid price
        Assert.assertTrue(productBL.updateProduct(50000.,"1001"));
    }
    @Test
    public void updatePrice2(){
        //wrong price  (price<0)
        Assert.assertFalse(productBL.updateProduct(-50000.,"1001"));
    }

    @Test
    public void updateProduct(){
        //update in desciption
        Product product15 = new Product("1002","banh my",15000.,"update from java app dbsjajdasjad",50,1,"my goi");
        Assert.assertTrue(productBL.updateProduct(product15));
    }
    @Test
    public void updateProduct1(){
        //update false: wrong id
        Product product15 = new Product("1111","banh my",15000.,"update from java app dbsjajdasjad",50,1,"my goi");
        Assert.assertFalse(productBL.updateProduct(product15));
    }
    @Test
    public void updateProduct2(){
        //update false: wrong price (<0)
        Product product15 = new Product("1002","banh my",-15000.,"update from java app dbsjajdasjad",50,1,"my goi");
        Assert.assertFalse(productBL.updateProduct(product15));
    }
    
    @Test
    public void updateProduct4(){
        //update false: null
        Product product=null;
        Assert.assertFalse(productBL.updateProduct(product));
    }
    @Test
    public void getByName(){
        //exist :True
        Assert.assertTrue(productBL.getByName("my goi"));
    }
    @Test
    public void getByName1(){
        //exist :False
        Assert.assertFalse(productBL.getByName("phobo2"));
    }

}
