package vn.edu.vtc.dal;

import org.junit.Assert;
import org.junit.Test;
import vn.edu.vtc.persistance.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderDALTest {
    OrderDAL orderDAL=new OrderDAL();
    ProductDAL productDAL=new ProductDAL();
    @Test
    public void getByIdTest(){
        //wrong orderId

        Assert.assertNull(orderDAL.getById(1001));
    }
    @Test
    public void  getByIdTest2(){
        //correct id
       Assert.assertNotNull(orderDAL.getById(13));
    }
    @Test
    public void refundProductTest(){
        Product product=productDAL.getById(1001);
        product.setRefundedInOrder(0);
        product.setAmount(0);
        List<Product> list=new ArrayList<>();
        list.add(product);
        Assert.assertNull(orderDAL.refundProduct(list,13));
    }
}
