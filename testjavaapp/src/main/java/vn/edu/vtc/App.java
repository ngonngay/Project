package vn.edu.vtc;


import vn.edu.vtc.dal.AccountDAL;
import vn.edu.vtc.dal.OrderDAL;
import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persistance.Account;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;
import vn.edu.vtc.service.StaticFuncitionService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        Account account = new Account();
        do {
            System.out.println("Login");
            account=StaticFuncitionService.loginToSystem();
            AccountDAL accountDAL=new AccountDAL();
            account=accountDAL.getAccount(account.getUserName(),account.getPassword());

            if (account.getIsAmin()==1) {

                ArrayList<String> cashierMenu = new ArrayList<String>();

                cashierMenu.add("Welcome to Cashier's Menu");
                cashierMenu.add("1. Create Order");
                cashierMenu.add("2. Update Order");
                cashierMenu.add("0. Exit");

                System.out.println("\n");

                Integer choice1 = StaticFuncitionService.printMenu(cashierMenu, 2);

                switch (choice1) {
                    case 1:
                        createOrder();
                        break;
                    case 2:
                        updateOrder();
                        break;
                    case 0:
                        break;
                    default:
                        break;
                }

            } else if (account.getIsAmin()==0) {
                ArrayList<String> managerMenu = new ArrayList<String>();

                System.out.println("Welcome to Manager's Menu");
                System.out.println("1. Insert product");
                System.out.println("2. Update product");
                System.out.println("0. Exit");

                Integer choice3 = StaticFuncitionService.printMenu(managerMenu, 2);

                switch (choice3) {
                    case 1:
                        insertProduct();
                        break;
                    case 2:
                        updateProduct();
                    case 0:
                        break;
                    default:
                        break;
                }
            }
        } while (true);

    }

    private static void insertProduct() {
    }
    private static void updateProduct() {
    }

    public static void flush() {

    }

    public static void createOrder() {

        System.out.println("|          Create Order          |");
        System.out.println("|    ------ Add product ------   |");
        System.out.println("|                                |");
        System.out.print("|       1. Input product ID: ");
        Integer idProduct;
        try   {
            idProduct = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            System.out.println("Wrong!");
            e.printStackTrace();
        }
        System.out.print("|       2. Input quantity:  ");
        Integer numQuantity;
        try   {
            numQuantity = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            System.out.println("Wrong!");
            e.printStackTrace();
        }
        System.out.println("Continue?(Yes or No: ");
        String continued = " ";
        try   {
            continued = new Scanner(System.in).nextLine();
        } catch (Exception e) {
            System.out.println("Wrong!");
            e.printStackTrace();
        }
        if (continued.equalsIgnoreCase("Yes")) {
            createOrder();
        } else if (continued.equalsIgnoreCase("No")) {
            System.out.println("Checkout(Yes/No): ");
            String checkout = " ";
            try   {
                checkout = new Scanner(System.in).nextLine();
            } catch (Exception e) {
                System.out.println("Wrong!");
                e.printStackTrace();
            }

            if (checkout.equalsIgnoreCase("Yes")) {
                System.out.println("Your detail");
            } else if (checkout.equalsIgnoreCase("No")) {
                createOrder();
            } else {
                System.out.println("Failed! Try again");
            }
        } else {
            System.out.println("Failed! Try again");
        }
    }

    public static void updateOrder() {

        System.out.println("|--------------------------------|");
        System.out.println("|          Update order          |");
        System.out.println("|         Input order ID         |");
        Integer idProduct1;
        try   {
            idProduct1 = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            System.out.println("Wrong!");
            e.printStackTrace();
        }

        ArrayList<String> updateOrder = new ArrayList<String>();

        updateOrder.add("Update order menu");
        updateOrder.add("1. Refunded order");
        updateOrder.add("2. Update quantity");
        updateOrder.add("0. Exit");

        Integer choice2 = StaticFuncitionService.printMenu(updateOrder, 2);

        switch (choice2) {
            case 1:
                System.out.println("Refunded order");
                break;
            case 2:
                System.out.print("Update quantity: ");
                Integer quantity1;
                try   {
                    quantity1 = new Scanner(System.in).nextInt();
                } catch (Exception e) {
                    System.out.println("Wrong!");
                    e.printStackTrace();
                }
            default:
        }

    }

}

