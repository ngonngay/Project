package vn.edu.vtc;

import vn.edu.vtc.bl.AccountBL;
import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.dal.AccountDAL;
import vn.edu.vtc.dal.OrderDAL;
import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persistance.Account;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;
import vn.edu.vtc.service.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws SQLException {
        MenuService menuService=new MenuService();
        ProductBL productBL=new ProductBL();
        AccountBL accountBL=new AccountBL();
        Account account = new Account();
        do {
            System.out.println("Login");
            account = StaticFuncitionService.loginToSystem();
            account = accountBL.login(account.getUserName(), account.getPassword());
            if (account != null) {
                if (account.getIsAmin() == 1) {
                    do {


                    Integer choice1 = StaticFuncitionService.printMenu(menuService.cashierMenu, 2);

                    switch (choice1) {
                        case 1://create Order
                            Order order=OrderService.createOrder(account);
                            if(order!=null){
                                System.out.println(order);
                            }
                            break;
                        case 2:
                            Integer choice2=StaticFuncitionService.printMenu(menuService.updateOrder,2);
                            switch (choice2){
                                case 1://refund order
                                    if (OrderService.refund()){
                                        System.out.println("Refund success!");
                                    }else {
                                         System.out.println("Fails! Try again!");
                                    }
                                    break;
                                case 2://update quantity
                                    break;
                            }
                            break;
                        case 0:
                            break;
                        default:
                            break;
                    }
                    }while (true);
                } else if (account.getIsAmin() == 0) {
                    Integer choice3=-1;
                    do {
                        choice3= StaticFuncitionService.printMenu(menuService.managerMenu, 2);
                        Product product= new Product();
                        switch (choice3) {
                            case 1://insert Product
                                product.setProductId(StaticFuncitionService.inputId());
                                product=InsertProduct.inputInformation();
                                if (product==null){
                                    break;
                                }
                                if (productBL.insertProduct(product)){
                                    System.out.println("Insert success!");
                                }else {
                                    System.out.println("Insert fails");
                                }
                                break;
                            case 2://update Product
                                Integer choice4;
                                    choice4= StaticFuncitionService.printMenu(menuService.updateMenu, 2);
                                switch (choice4) {
                                    case 1:
                                        UpdateProduct updateProduct=new UpdateProduct();
                                        if(updateProduct.updatePrice()){
                                            System.out.println("Update success!");
                                        }else {
                                            System.out.println("Fails");
                                        }
                                        break;
                                    case 2:
                                        UpdateProduct updateProduct1=new UpdateProduct();
                                        if(updateProduct1.updateProduct()){
                                            System.out.println("Update success!");
                                        }else {
                                            System.out.println("Fails");
                                        }
                                        break;
                                    case 0:
                                        break;
                                }
                            case 0:
                                break;
                            default:
                                break;
                        }
                    }while (choice3!=0);

                }
            } else {
                System.out.println("Wrong Username/password");
            }
        } while (true);

    }



}
