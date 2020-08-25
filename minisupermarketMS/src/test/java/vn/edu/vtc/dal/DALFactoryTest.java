package vn.edu.vtc.dal;

import org.junit.Assert;
import org.junit.Test;
import vn.edu.vtc.persistance.Account;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;

public class DALFactoryTest {
    @Test
    public void getDAL(){
        //must return AccountDAL
        DAL<Account> dal=DalFactory.getDAL(Account.class);
        Assert.assertTrue(dal instanceof AccountDAL);
    }
    @Test
    public void getDAL2(){
        //must return ProductDAL
        DAL<Product> dal=DalFactory.getDAL(Product.class);
        Assert.assertTrue(dal instanceof ProductDAL);
    }
    @Test
    public void getDAL3(){
        //must return OrderDAL
        DAL<Order> dal=DalFactory.getDAL(Order.class);
        Assert.assertTrue(dal instanceof OrderDAL);
    }

}
