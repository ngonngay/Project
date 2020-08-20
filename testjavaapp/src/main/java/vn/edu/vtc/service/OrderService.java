package vn.edu.vtc.service;

import vn.edu.vtc.bl.OrderBL;
import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persistance.Account;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderService {

    public static Order createOrder(Account account) {
        ProductBL productBL=new ProductBL();
        OrderBL orderBL=new OrderBL();
        Order order=new Order();
        System.out.println("|          Create Order          |");
        System.out.println("|    ------ Add product ------   |");
        System.out.println("|                                |");
        do {
            System.out.print("|       1. Input product ID: ");
            int productId=-1;
            do try {
                productId = new Scanner(System.in).nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Wrong!");
            }while (true);
            Product product=productBL.getById(productId);
            System.out.println(product);

            int quantity=0;
            do try {
                System.out.print("       2. Input quantity:  ");
                quantity = new Scanner(System.in).nextInt();

                if (quantity<0){
                    System.out.println("New quantity must greater than 0");
                }
                if (quantity>product.getLeftQuantity()){
                    System.out.println("Wrong!");

                }
                if (quantity>0&&quantity<product.getLeftQuantity()){
                    break;
                }
            } catch (Exception e) {
                System.err.println("Wrong!");
            }while (true);
            if (quantity!=0&&(product.getLeftQuantity()>quantity)) {
                product.setAmount(quantity);
            }
            order.addProduct(product);
            System.out.println("Continue add product?(Y/N): ");
            String continued = new Scanner(System.in).nextLine();
            if (continued.equalsIgnoreCase("N")){
                System.out.println("Checkout(Y/N): ");
                String checkout = new Scanner(System.in).nextLine();
                if (checkout.equalsIgnoreCase("Y")) {
                    order.setStaff_id(account.getStaff_id());
                    order.setStore_id(1);
                    order=orderBL.createOrder(order);
                    return order;
                }
                return null;
            }
        }while (true);
    }

    public static boolean refund() throws SQLException {
        //input order-id
        //set value at refund_order column at 0 (0:true ; 1: false)
        System.out.println("|--------------------------------|");
        System.out.println("|          Update order          |");
        System.out.println("|         Input order ID         |");
        int orderId=-1;
        try {
             orderId= new Scanner(System.in).nextInt();
        } catch (Exception e) {
            System.out.println("Wrong!");
            e.printStackTrace();
        }
        OrderBL orderBL=new OrderBL();
        if (orderId!=-1){
            return orderBL.refundOrder(orderId);
        }
        return false;
    }

}
