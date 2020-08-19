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

        Product product=productBL.getById(1001);
        Product expected=new Product(1001,"phobo",20000.0,null,null,"da update",20,1,1,null);
        Assert.assertTrue(product.equals(expected));
    }
    @Test
    public void getProductById2(){
        //wrong id

        Product product=productBL.getById(1);
        Product expected=new Product(1001,"phobo",20000.0,null,null,"da update",20,1,1,null);
        Assert.assertNull(product);
    }
    @Test
    public  void insertProduct(){
        //Already existed
        Product p=new Product(1010,"my goi 5",10000.,"update from java app",10,1,"my goi");
        Assert.assertFalse(productBL.insertProduct(p));
    }
    @Test
    public void updatePrice(){

        Assert.assertTrue(productBL.updateProduct(50000.,1001));
    }
    @Test
    public void updateProduct(){

        Product product15 = new Product(1002,"banh my",15000.,"update from java app dbsjajdasjad",50,1,"my goi");
        Assert.assertTrue(productBL.updateProduct(product15));
    }
}
