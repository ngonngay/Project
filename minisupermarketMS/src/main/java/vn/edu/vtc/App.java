package vn.edu.vtc;

import java.sql.SQLException;
import vn.edu.vtc.bl.AccountBL;
import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.persistance.Account;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;
import vn.edu.vtc.pl.*;
import vn.edu.vtc.pl.OrderService;
import vn.edu.vtc.pl.StaticFunctionService;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        ProductBL productBL = new ProductBL();
        AccountBL accountBL = new AccountBL();
        Account account = new Account();
        do {
            System.out.println("------------------------------------------------------------");
            System.out.println("---------Login to Mini Supermaket Management System---------");
            System.out.println("------------------------------------------------------------\n");
            account = StaticFunctionService.loginToSystem();
            account = accountBL.login(account.getUserName(), account.getPassword());
            if (account != null) {
                if (account.getIsAmin() == 1) {
                    Integer choice1 = -1;
                    do {

                        choice1 = StaticFunctionService.printMenu(menuService.cashierMenu, 2);

                        switch (choice1) {
                            case 1:// create Order
                                OrderService.createOrder(account);
                                break;
                            case 2:
                                Integer choice2 = StaticFunctionService.printMenu(menuService.updateOrder, 2);
                                switch (choice2) {
                                    case 1:// refund order
                                        try {
                                            if (OrderService.refund()) {
                                                System.out.println("Refund success!");
                                            } else {
                                                System.out.println("Fails! Try again!");
                                            }
                                        } catch (SQLException e) {

                                            System.out.println("Fails! Try again!");
                                        }
                                        break;
                                    case 2:// update quantity
                                        Order newOrder = OrderService.refundProduct();
                                        if (newOrder != null) {
                                            System.out.println("\nYour Order:");
                                            OrderService.printOrder(newOrder);
                                        }
                                        break;
                                }
                                break;
                            case 0:
                                break;
                            default:
                                break;
                        }
                    } while (choice1 != 0);
                } else if (account.getIsAmin() == 0) {
                    Integer choice3 = -1;
                    do {
                        choice3 = StaticFunctionService.printMenu(menuService.managerMenu, 3);
                        Product product = new Product();
                        switch (choice3) {
                            case 1:// insert Product
                                String productid = ProductSevice.inputId();
                                if (productBL.getById(productid) != null) {
                                    System.out.println("Product has existed!");
                                    break;
                                }
                                product = ProductSevice.inputInformation(productid);
                                if (product == null) {
                                    break;
                                }
                                product.setProductId(productid);
                                if (productBL.insertProduct(product)) {
                                    System.out.println("Insert success!");
                                } else {
                                    System.out.println("Insert fails");
                                }
                                break;
                            case 2:// update Product
                                Integer choice4;
                                choice4 = StaticFunctionService.printMenu(menuService.updateMenu, 2);
                                switch (choice4) {
                                    case 1:
                                        ProductSevice.updatePrice();
                                        break;
                                    case 2:
                                        if (ProductSevice.updateProduct()) {
                                            System.out.println("Update success!");
                                        } else {
                                            System.out.println("Fails");
                                        }
                                        break;
                                    case 0:
                                        break;
                                }
                                break;
                            case 3:// search product
                                Product product2=ProductSevice.searchProduct();
                                if (product2!=null){
                                    System.out.println("Your result : ");
                                    System.out.println(product2);
                                }else{
                                    System.out.println("No result");
                                }
                                break;
                            case 0:
                                break;
                            default:
                                break;
                        }
                    } while (choice3 != 0);

                }
            } else {
                System.out.println("Wrong Username/password");
            }
        } while (true);

    }
}
