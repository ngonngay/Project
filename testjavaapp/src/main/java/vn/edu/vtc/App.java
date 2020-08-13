package vn.edu.vtc;


import vn.edu.vtc.dal.AccountDAL;
import vn.edu.vtc.dal.OrderDAL;
import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persistance.Account;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        AccountDAL accountDAL=new AccountDAL();
        Account account= accountDAL.getAccount("staff1","123456");
        System.out.println(account.toString());
        ProductDAL productDAL=new ProductDAL();
        Product product= productDAL.getProductById(1001);
        System.out.println(product.toString());
        Product p=new Product(1005,"my goi 5",10000.,"update from java app",10,1,"my goi");
        System.out.println("insert "+productDAL.insertProduct(p));
        Product product11=productDAL.getProductById(1005);
        System.out.println(product11);
        Product product15 = new Product(1002,"banh my",15000.,"update from java app",50,1,"my goi");
        System.out.println("update : " +productDAL.updateProduct(product15));
        Product product1 = new Product(1001,"my goi",10000.,0.,1);
        Product product2 = new Product(1002,"my goi 2",10000.,0.,1);
        List<Product> list= new ArrayList<Product>();
        list.add(product1);
        list.add(product2);
        OrderDAL orderDAL=new OrderDAL();
        Order order = new Order(list,account.getStaff_id());
        Order newOrder=orderDAL.createOrder(order);
        System.out.println(newOrder.toString());

    }
}
