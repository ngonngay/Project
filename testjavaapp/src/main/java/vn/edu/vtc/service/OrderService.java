package vn.edu.vtc.service;

import vn.edu.vtc.bl.OrderBL;
import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persistance.Account;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;

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
            try {
                productId = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.println("Wrong!");
            }
            Product product=productBL.getById(productId);
            System.out.println(product);
            System.out.print("|       2. Input quantity:  ");
            int quantity=0;
            do try {
                quantity = new Scanner(System.in).nextInt();
                if (quantity>0){
                    break;
                }
                System.out.println("New quantity must greater than 0");
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
}
