package vn.edu.vtc.dal;

import org.junit.Assert;
import org.junit.Test;
import vn.edu.vtc.persistance.Account;

/*
Account{userName='staff1', password='123456', staff_id=1, name='thang', isAmin=1}
Product{product_id=1001, name='phobo', price=20000.0, discounted=null, amount=null, description='da update', leftQuantity=20, isSelling=1, supplier_id=1, category='null'}
insert 0
Product{product_id=1005, name='my goi 5', price=10000.0, discounted=null, amount=null, description='update from java app', leftQuantity=10, isSelling=1, supplier_id=1, category='null'}
update : 1
Order{productList=[Product{product_id=1001, name='phobo', price=10000.0, discounted=0.0, amount=null, description='null', leftQuantity=null, isSelling=0, supplier_id=null, category='null'}, Product{product_id=1002, name='banh my', price=10000.0, discounted=0.0, amount=null, description='null', leftQuantity=null, isSelling=0, supplier_id=null, category='null'}], id=22, date=2020-08-13 14:28:07.0, staff_id=null, store_id=1, store_name='a', address='HN'}

*/
public class AccountDALTest {
    AccountDAL accountDAL=new AccountDAL();
    @Test
    public void getAccountTest1(){
        Account account=accountDAL.getAccount("Nguyenquyetthang","16c0ce36e334e22fda8caca1b10c2f9c");
        Account expected=new Account("Nguyenquyetthang",null,1,"thang",0);
        Assert.assertTrue(expected.equals(account));
    }
    @Test
    public void getAccountTest2(){
        Account account=accountDAL.getAccount("staff","123456");
        Assert.assertTrue(account==null);
    }
    @Test
    public void getAccountTest3(){
        Account account=accountDAL.getAccount("staff1","1234");
        Assert.assertTrue(account==null);
    }
    @Test
    public void getAccountTest4(){
        Account account=accountDAL.getAccount("staff","1234");
        Assert.assertTrue(account==null);
    }
}
