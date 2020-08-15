package vn.edu.vtc.dal;

import org.junit.Assert;
import org.junit.Test;
import vn.edu.vtc.persistance.Account;
import vn.edu.vtc.service.PasswordService;
import vn.edu.vtc.service.StaticFuncitionService;
/*
Account{userName='staff1', password='123456', staff_id=1, name='thang', isAmin=1}
Product{product_id=1001, name='phobo', price=20000.0, discounted=null, amount=null, description='da update', leftQuantity=20, isSelling=1, supplier_id=1, category='null'}
insert 0
Product{product_id=1005, name='my goi 5', price=10000.0, discounted=null, amount=null, description='update from java app', leftQuantity=10, isSelling=1, supplier_id=1, category='null'}
update : 1
Order{productList=[Product{product_id=1001, name='phobo', price=10000.0, discounted=0.0, amount=null, description='null', leftQuantity=null, isSelling=0, supplier_id=null, category='null'}, Product{product_id=1002, name='banh my', price=10000.0, discounted=0.0, amount=null, description='null', leftQuantity=null, isSelling=0, supplier_id=null, category='null'}], id=22, date=2020-08-13 14:28:07.0, staff_id=null, store_id=1, store_name='a', address='HN'}

*/
public class AccountDALTest {

    @Test
    public void validateUsername(){
        Account account=new Account();
        //correct username form
        Assert.assertTrue(PasswordService.validateUsername("Nguyenquyetthang"));
    }
    @Test
    public void validateUsername2(){
        Account account=new Account();
        //have special character
        Assert.assertFalse(PasswordService.validateUsername("Nguyenquyetthang123%"));
    }
    @Test
    public void validateUsername3(){
        Account account=new Account();
        //less than 8 character
        Assert.assertFalse(PasswordService.validateUsername("Nguy"));
    }
    @Test
    public void validateUsername4(){
        Account account=new Account();
        //more than 20 character
        Assert.assertFalse(PasswordService.validateUsername("Nguyenquyetthang123asdvghasdvghasvghasvdhvas"));
    }
    @Test
    public void validatePassword(){
        Account account=new Account();
        //correct password
        Assert.assertTrue(PasswordService.validatePassword("Thangnguyenquyet123"));
    }
    @Test
    public void validatePassword2(){
        Account account=new Account();
        //It wasn't contains at least one digit.
        Assert.assertFalse(PasswordService.validatePassword("Thangnguyenquyet"));
    }
    @Test
    public void validatePassword3(){
        Account account=new Account();
        //It wasn't contains at least upper case alphabet.
        Assert.assertFalse(PasswordService.validatePassword("thangnguyenquyet123"));
    }
    @Test
    public void validatePassword4(){
        Account account=new Account();
        //It wasn't contains at least lower case alphabet.
        Assert.assertFalse(PasswordService.validatePassword("THANGNGUYENQUYET"));
    }
    @Test
    public void testMD5(){
        String result=StaticFuncitionService.getMd5("Thangnguyenquyet123");
        String expected="16c0ce36e334e22fda8caca1b10c2f9c";
        Assert.assertTrue(result.equals(expected));
    }
    @Test
    public void getAccountTest1(){
        AccountDAL accountDAL=new AccountDAL();
        Account account=accountDAL.getAccount("Nguyenquyetthang","16c0ce36e334e22fda8caca1b10c2f9c");
        System.out.println(account);
        Account expected=new Account("Nguyenquyetthang",null,1,"thang",0);
        System.out.println(expected);
        Assert.assertTrue(expected.equals(account));
    }
    @Test
    public void getAccountTest2(){
        AccountDAL accountDAL=new AccountDAL();
        Account account=accountDAL.getAccount("staff","123456");

        Assert.assertTrue(account==null);
    }
    @Test
    public void getAccountTest3(){
        AccountDAL accountDAL=new AccountDAL();
        Account account=accountDAL.getAccount("staff1","1234");
        Assert.assertTrue(account==null);
    }
    @Test
    public void getAccountTest4(){
        AccountDAL accountDAL=new AccountDAL();
        Account account=accountDAL.getAccount("staff","1234");
        Assert.assertTrue(account==null);
    }
}
