package vn.edu.vtc.pl;

import vn.edu.vtc.bl.OrderBL;
import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.persistance.Account;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class OrderService {

    public static void createOrder(Account account) {
        ProductBL productBL=new ProductBL();
        OrderBL orderBL=new OrderBL();
        Order order=new Order();
        System.out.println("|          Create Order          |");
        System.out.println("|    ------ Add product ------   |");
        System.out.println("|                                |");
        do {
            //input productID
            int productId=-1;
            do try {
                System.out.print("      1. Input product ID: ");
                productId = new Scanner(System.in).nextInt();
                if (productBL.getById(productId)!=null){
                    break;
                }else {
                    System.out.println("This product id doesn't exist!");
                }

            } catch (Exception e) {
                System.out.println("Wrong!");
            }while (true);
            int quantity=0;
            boolean check=false;
            for (Product p:order.getProductList()) {
                if (p.getProductId()==productId){
                    //input product quantity
                    do try {
                        System.out.print("   2. Input quantity:  ");
                        quantity = new Scanner(System.in).nextInt();
                        if (p.getLeftQuantity()==0){
                            System.out.println("No product to select!");
                        }
                        if (quantity<0){
                            System.out.println("New quantity must greater than 0");
                        }
                        if (quantity>p.getLeftQuantity()){
                            System.out.println("Wrong!");
                        }
                        if (quantity>0&&quantity<p.getLeftQuantity()){
                            p.setAmount(p.getAmount()+quantity);
                            break;
                        }
                    } catch (Exception e) {
                        System.err.println("Wrong!");
                    }while (true);
                    check=true;
                }
            }
            if (!check){
                Product product=productBL.getById(productId);
                do try {
                    System.out.print("   2. Input quantity:  ");
                    quantity = new Scanner(System.in).nextInt();
                    if (quantity<0){
                        System.out.println("New quantity must greater than 0");
                    }
                    if (quantity>product.getLeftQuantity()){
                        System.out.println("Wrong!");
                    }

                    if (quantity!=0&&(product.getLeftQuantity()>quantity)) {
                        product.setAmount(quantity);
                        break;
                    }
                } catch (Exception e) {
                    System.err.println("Wrong!");
                }while (true);
                order.addProduct(product);
            }
            System.out.println("Continue add product?(Y/N): ");
            String continued = new Scanner(System.in).nextLine();
            if (continued.equalsIgnoreCase("N")){
                System.out.println("Checkout(Y/N): ");
                String checkout = new Scanner(System.in).nextLine();
                if (checkout.equalsIgnoreCase("Y")) {
                    order.setStaff_id(account.getStaff_id());
                    order.setStore_id(1);
                    order=orderBL.createOrder(order);
                    printOrder(order);
                    return;
                }else {
                    return;
                }
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
        do try {
             orderId= new Scanner(System.in).nextInt();
             break;
        } catch (Exception e) {
            System.out.println("Wrong!");
        }while (true);
        OrderBL orderBL=new OrderBL();
        if (orderId!=-1){
            return orderBL.refundOrder(orderId);
        }
        return false;
    }
    public static Order refundProduct(){
        //case1: decrease amount of product in order
        //case2: refund product (refund_quantity==product.amount)
        /*
        * step 1: input order_id
        * step 2: show detail
        * step 3: input product was refunded
        * step 4: input new quantity
        * step 5: if:
        *       +quantity<product.amount = > decrease
        *       +quantity=product.amount = > refund product { - set value of  "refunded" column at 0 (0:true 1:false)
        *                                                     - increase quantity product on db}
        *       +quantity>product.amount => false
        * */
        OrderBL orderBL=new OrderBL();
        Order newOrder = new Order();
        boolean check=false;
        System.out.println("Input order Id: ");

        int orderId;
        do try {
            orderId=new Scanner(System.in).nextInt();
            if (orderId >0){
                break;
            }
            if (orderId!=0){
                System.out.println("Something wrong, try again!");
            }
        }catch (Exception e){
            System.out.println("Something wrong, try again!");
        }while (true);
        Order order = orderBL.getbyId(orderId);
        //show detail

        if (order==null) {
            System.out.println("Couldn't found this order!");
            return null;
        }
            printOrder(order);

        //input refund product in order
        List<Product> refundProducts=new ArrayList<>();
        do {
            System.out.println("Input product id to refund : ");
            int productId;
            do try {
                productId=new Scanner(System.in).nextInt();
                if (productId >0){
                    break;
                }
                if (productId!=0){
                    System.out.println("Something wrong, try again!");
                }
            }catch (Exception e){
                System.out.println("Something wrong, try again!");
            }while (true);

            for (Product product:order.getProductList()) {
                if (product.getProductId()==productId){
                    check=true;
                    do try {
                        System.out.println("Input new quantity : ");
                        int newQuantity=new Scanner(System.in).nextInt();
                        if (newQuantity==0){
                            product.setAmount(newQuantity);
                            product.setRefundedInOrder(0);
                            refundProducts.add(product);
                            break;
                        }
                        if (newQuantity<product.getAmount()&&newQuantity!=0){
                            product.setAmount(product.getAmount()-newQuantity);
                            refundProducts.add(product);
                            break;
                        }
                        System.out.println("Something wrong ,Try again");

                    }catch (Exception e){
                        System.out.println("Something wrong, try again!");
                    }while (true);
                }
            }
            if (!check){
                System.out.println("couldn't found this id in order!");
                System.out.println("Try again?(Y/N)");
                String continues=new Scanner(System.in).nextLine();
                if (continues.equalsIgnoreCase("exit")){
                    return null;
                }
                if (continues.equalsIgnoreCase("N")){
                    return null;
                }
            }
            if (check){
                System.out.println("Refund more?(Y/N)");
                String continues=new Scanner(System.in).nextLine();
                if (continues.equalsIgnoreCase("N")){
                    System.out.println("Press any key to finish....");
                    String finish=new Scanner(System.in).nextLine();
                    break;
                }
            }
        }while (true);
        //send to BL
        if (check) {
            order = orderBL.refundProduct(refundProducts, order.getId());
        }
        return order;
    }
    public static void printOrder(Order order){
//        NumberFormat nf = NumberFormat.getInstance(new Locale("vi", "VN"));
            System.out.println("\n");
            System.out.println("|-----------------------------------------------------------------------------------------------|");
            System.out.print("|                 "+order.getStore_name());
            System.out.print("                                      Address: " +order.getAddress());
            System.out.println("               |");
            System.out.println("|-----------------------------------------------------------------------------------------------|");
            System.out.println("|                                     -------ORDER-------                                       |");
            System.out.print("|     Date:        " +order.getDate());
            System.out.print("                                         ID: " +order.getId());
            System.out.println("                          |");
            System.out.println("|-----------------------------------------------------------------------------------------------|");
            System.out.println(
                    "|   ID   |       Name        |       Price       |   Discount   |  Amount  |       Total         | ");
            System.out.println("|-----------------------------------------------------------------------------------------------|");
            for (Product product : order.getProductList()) {

                System.out.format(
                        "|%5d   |%11s        |%12.2f       |%11.2f   |%7d  |%13.2f        |\n",product.getProductId(), product.getName(),product.getPrice(), product.getDiscounted(), product.getAmount(), product.Total());
                // System.out.println("\n");
            }
            System.out.println("|-----------------------------------------------------------------------------------------------|");
            System.out.print("| TỔNG TIỀN PHẢI THANH TOÁN:                                                    "+totalOrder(order));
            System.out.print("         |");
            System.out.println("|-----------------------------------------------------------------------------------------------|");
            System.out.println("|                               Cảm ơn quý khách và hẹn gặp lại!                                |");
            System.out.println("|                            Hotline:1800 1000  Website: vtc.edu.vn                             |");
            System.out.println("|-----------------------------------------------------------------------------------------------|");
    }
    public static Double totalOrder(Order order) {
        Double totalOrder = 0.;
        for (Product product : order.getProductList()) {
            totalOrder += product.Total();
        }
        return totalOrder;
    }

}
