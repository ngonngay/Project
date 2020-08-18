package vn.edu.vtc.dal;

import org.junit.Assert;
import org.junit.Test;
import vn.edu.vtc.persistance.Product;

public class ProductDALTest {
    @Test
    public void getProductById(){
        //corrrect id
        ProductDAL productDAL=new ProductDAL();
        Product product=productDAL.getProductById(1001);
        Product expected=new Product(1001,"phobo",20000.0,null,null,"da update",20,1,1,null);
        Assert.assertTrue(product.equals(expected));
    }
    @Test
    public void getProductById2(){
        //wrong id
        ProductDAL productDAL=new ProductDAL();
        Product product=productDAL.getProductById(1);
        Product expected=new Product(1001,"phobo",20000.0,null,null,"da update",20,1,1,null);
        Assert.assertNull(product);
    }
    @Test
    public  void insertProduct(){
        Product p=new Product(1005,"my goi 5",10000.,"update from java app",10,1,"my goi");
        ProductDAL productDAL=new ProductDAL();
        Assert.assertTrue(productDAL.insertProduct(p)==1);
    }
    @Test
    public void updatePrice(){
        ProductDAL productDAL=new ProductDAL();
        Assert.assertTrue(productDAL.updatePrice(50000.,1001)>0);
    }
}
