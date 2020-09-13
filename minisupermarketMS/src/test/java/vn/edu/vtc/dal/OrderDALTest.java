package vn.edu.vtc.dal;

import org.junit.Assert;
import org.junit.Test;
import vn.edu.vtc.persistance.Order;
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
       Assert.assertNotNull(orderDAL.getById(1));
    }
    @Test
    public void createOrder(){
        //correct
        Product product=new Product("1001","phobo",50000.,10000.,1);
        List<Product> list=new ArrayList<>();
        list.add(product);
        Order order=new Order();
        order.setStore_id(1);
        order.setStaff_id(1);
        order.setAddress("Ha Noi");
        order.setProductList(list);
        Assert.assertNotNull(orderDAL.createOrder(order));
    }
    @Test
    public void createOrder1(){
        //order null
        Assert.assertNull(orderDAL.createOrder(null));
    }
    @Test
    public void createOrder2(){
        //wrong product id
        Product product=new Product("10010","phobo",50000.,10000.,1);
        List<Product> list=new ArrayList<>();
        list.add(product);
        Order order=new Order();
        order.setStore_id(1);
        order.setStaff_id(1);
        order.setAddress("Ha Noi");
        order.setProductList(list);
        Assert.assertNull(orderDAL.createOrder(order));
    }
    @Test
    public  void createOrder3(){
        //list null
        List<Product> list=new ArrayList<>();
        Order order=new Order();
        order.setStore_id(1);
        order.setStaff_id(1);
        order.setAddress("Ha Noi");
        order.setProductList(list);
        Assert.assertNull(orderDAL.createOrder(order));
    }


}
