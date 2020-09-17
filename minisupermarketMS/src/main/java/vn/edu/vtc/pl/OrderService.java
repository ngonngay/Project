package vn.edu.vtc.pl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import vn.edu.vtc.bl.OrderBL;
import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.persistance.Account;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;

public class OrderService {
    public static void createOrder(Account account) {
        ProductBL productBL=new ProductBL();
        OrderBL orderBL=new OrderBL();
        Order order=new Order();
        System.out.println("----------------------------------");
        System.out.println("|          Create Order          |");
        System.out.println("|    ------ Add product ------   |");
        System.out.println("|                                |");
        System.out.println("----------------------------------");
        do {
            //input productID
            String productId=null;
            do try {
                System.out.print("> Input product ID: ");
                productId = new Scanner(System.in).nextLine();
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
                if (p.getProductId().equalsIgnoreCase(productId)){
                    //input product quantity
                    do try {
                        if (p.getLeftQuantity()==0){
                            System.out.println("Sold out!");
                            System.out.println("Try with other product");
                            break;
                        }
                        System.out.print("> Input quantity:  ");
                        quantity = new Scanner(System.in).nextInt();
                        if (p.getLeftQuantity()==0){
                            System.out.println("No product to select!");
                        }
                        if (quantity<0){
                            System.out.println("New quantity must greater than 0 !");
                        }
                        if (quantity>p.getLeftQuantity()){
                            System.out.println("Product quantity doesn't enough !");
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
                    if (product.getLeftQuantity()==0){
                        System.out.println("Sold out!");
                        System.out.println("Try with other product");
                        break;
                    }
                    System.out.print("> Input quantity:  ");
                    quantity = new Scanner(System.in).nextInt();
                    if (quantity<0){
                        System.out.println("New quantity must greater than 0");
                    }
                    if (quantity>product.getLeftQuantity()){
                        System.out.println("Product quantity doesn't enough !");
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
                    for (Product p:order.getProductList()) {
                        if (p.getAmount()==0){
                            order.getProductList().remove(p);
                        }
                    }
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
        System.out.println("|--------------------------------|");
        int orderId=-1;
        do try {
            System.out.println(">Input order ID : ");
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
        int orderId=-1;
        do try {
            System.out.println(">Input order Id: ");
            orderId=new Scanner(System.in).nextInt();
            if (orderId >0){
                break;
            }
            if (orderId==-1){
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
            String productId;
            do try {
                productId=new Scanner(System.in).nextLine();
                break;
            }catch (Exception e){
                System.out.println("Something wrong, try again!");
            }while (true);
            for (Product product:order.getProductList()) {
                if (product.getProductId().equalsIgnoreCase(productId)){
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
                            product.setAmount(newQuantity);
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
    public static void printOrder(Order order) {
        System.out.println("\n");
        System.out.println("------------------------------------------");
        System.out.print(order.getStore_name());
        System.out.print("             Address: " + order.getAddress() + "\n");
        System.out.println("------------------------------------------");
        System.out.println("           -------ORDER-------            ");
        System.out.print("Date: " + order.getDate());
        System.out.print("         ID: " + order.getId() + "\n");
        System.out.println("------------------------------------------");
        System.out.println("Name               Price    Amount  Total");
        System.out.println("------------------------------------------");
                for (Product product : order.getProductList()) {
            System.out.println(product.getName());
            System.out.print(product.getProductId());
            System.out.format("               %8s %4d   %4s\n", printPrice(product.getPrice()), product.getAmount(), printPrice(Total(product)));
            if (product.getDiscounted() >= 1) {
                    System.out.format("Discount  %32s",printPrice(product.getDiscounted()));
                    System.out.println("\n");
            }
            else{
                    System.out.println("\n");
            }
        }
        System.out.println("------------------------------------------");
        System.out.print("Total:                       " + printPrice(totalOrder(order))
                + "VND\n");
        System.out.println("------------------------------------------");
        System.out.println("      Thank you and see you again!");
        System.out.println("          Hotline:18001000");
        System.out.println("      Website:https://vinmart.vn");
        System.out.println("------------------------------------------\n\n");
    }
    public static String printOrder2(Order order) {
        String orderDetail = "";
        String str1 = "";
        String str2 = String.format("");
        str1 = "\n";
        str1 = str1 + "-----------------------------------------------------------------------------";
        str1 = str1 + String.format("\n%10s", order.getStore_name());
        str1 = str1 + String.format("%37s", "Địa chỉ: " +order.getAddress());
        str1 = str1 + "\n----------------------------------------------------------------------------";
        str1 = str1 + "\n                    -------HÓA ĐƠN THANH TOÁN-------         ";
        str1 = str1 + String.format("\nThời gian: %15s", order.getDate());
        str1 = str1 + String.format("%17s", "    Mã: " + order.getId());
        str1 = str1 + String.format("\n%40s", "NVBH: " + order.getStaff_id());
        str1 = str1 + "\n----------------------------------------------------------------------------";
        str1 = str1 + "\nTên mặt hàng            Giá            Số lượng     Thành tiền";
        str1 = str1 + "\n----------------------------------------------------------------------------";
        for (Product product : order.getProductList()) {
            str1 = str1 + String.format("\n%.20s", product.getName());
            str1 = str1 + String.format("\n%-15s", product.getProductId());
            str1 = str1 + String.format("%18s%15d%23s", printPrice(product.getPrice()), product.getAmount(), printPrice(Total(product)));
            if (product.getDiscounted() >= 1) {
                    str1 = str1 + String.format("\nKhuyến mãi: %59s", printPrice(product.getDiscounted()));
                    str1 = str1 + '\n';
            }
            else{
                    str1 = str1 + "\n";
            }
        }
        str1 = str1 + "\n----------------------------------------------------------------------------";
        str1 = str1 + String.format("\nTổng thanh toán: %48s", printPrice(totalOrder(order)));
        str1 = str1 + "VNĐ";
        str1 = str1 + "\n----------------------------------------------------------------------------";
        str1 = str1 + "\n                        Cảm ơn và hẹn gặp lại bạn!";
        str1 = str1 + "\n                            Hotline:18001000";
        str1 = str1 + "\n                        Website:https://vinmart.vn";
        str1 = str1 + "\n----------------------------------------------------------------------------\n\n";
        orderDetail = orderDetail + str1;
        
        return orderDetail;
    }
    public static Double totalOrder(Order order) {
        Double totalOrder = 0.;
        for (Product product : order.getProductList()) {
            totalOrder += (product.getPrice()-product.getDiscounted())*product.getAmount();
        }
        return totalOrder;
    }
    public static Double totalOrder(List<Order> orders) {
        Double totalOrder = 0.;
        for (Order order:orders){
            totalOrder+=totalOrder(order);
        }
        return totalOrder;
    }
    public static String printPrice(Double price){
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        
        String str1 = currencyVN.format(price);
        String str2 =str1.replace(".", ",");
        String str3=str2.replace("₫", "");
        return str3;
    }
    public static Double Total(Product p){
        Double total = p.getPrice()*p.getAmount();
        return total;
    }
    public static List<String> validateSQLdatetime(Timestamp sqlDate){
        String date=String.valueOf(sqlDate);
        String[] strings=date.split(" ");
        String time=strings[1].replace(".0", "");
        String datetime=strings[0];
        String[] dateArray=datetime.split("-");
        String dateMonthYear="";
        for (int i = 2; i >-1; i--) {
            if (i!=0) {
                dateMonthYear=dateMonthYear+dateArray[i]+"-";
            }else{
                dateMonthYear=dateMonthYear+dateArray[i];
            }
        }
        List<String> result=new ArrayList<>();
        result.add(time);
        result.add(dateMonthYear);
        return result;
    }
    public static String printReport(List<Order> listOrder) {
        String totalReport = "";
        String str2 = "";
        str2 = "                                                                  VTC ACADEMY";
        str2 = str2 + "\n           PF08\n";
        str2 = str2 + "\n                                                    THÔNG KÊ HÓA ĐƠN BÁN HÀNG\n";
        str2 = str2 + "\n------------------------------------------------------------------------------------------------------------------------------";
        str2 = str2 + "\n|  Mã hóa đơn   |   Ngày bán            |   Giờ bán      |   Tổng tiền hóa đơn   | Nhân viên bán hàng  ";
        str2 = str2 + "\n------------------------------------------------------------------------------------------------------------------------------";
        for(int i=0;i<listOrder.size(); i++) {
            Order order = listOrder.get(i);
            List<String> dateTime = validateSQLdatetime(order.getDate());
            if(order.getId()>=10&&totalOrder(order)<10000){
                str2 = str2 + String.format("\n" + "|%8d%28s %20s  %23s   %34s", order.getId(), dateTime.get(1), dateTime.get(0), printPrice(totalOrder(order)), order.getStaff_name());
            }
            else if(order.getId()>9&&totalOrder(order) >= 10000&&totalOrder(order)<=99999){
                str2 = str2 + String.format("\n" + "|%8d%28s %20s  %23s %34s", order.getId(), dateTime.get(1), dateTime.get(0), printPrice(totalOrder(order)), order.getStaff_name());
            }
            else if(order.getId()>=10&&totalOrder(order)>=100000){
                str2 = str2 + String.format("\n" + "|%8d%28s %20s  %23s %33s", order.getId(), dateTime.get(1), dateTime.get(0), printPrice(totalOrder(order)), order.getStaff_name());
            }
            else if(order.getId()<10&&totalOrder(order)>=10000&&totalOrder(order)<=99999){
                str2 = str2 + String.format("\n" + "|%8d %28s %20s  %23s %35s", order.getId(), dateTime.get(1), dateTime.get(0), printPrice(totalOrder(order)), order.getStaff_name());
            }
            else if(order.getId()<10&&totalOrder(order)>=100000){
                str2 = str2 + String.format("\n" + "|%8d %28s %20s  %23s %33s", order.getId(), dateTime.get(1), dateTime.get(0), printPrice(totalOrder(order)), order.getStaff_name());
            }
            else{
            str2 = str2 + String.format("\n" + "|%8d %28s %20s  %23s   %34s", order.getId(), dateTime.get(1), dateTime.get(0), printPrice(totalOrder(order)), order.getStaff_name());
            }
        }
        str2 = str2 + "\n------------------------------------------------------------------------------------------------------------------------------";
        str2 = str2 + "\n\n\n       Người lập biểu                          Kế toán trưởng                      Người đại diện theo phát luật";
        str2 = str2 + "\n     (Ký, ghi rõ họ tên)                     (Ký, ghi rõ họ tên)                     (Ký, ghi rõ họ tên, đóng dấu)\n\n\n";
        totalReport = totalReport + str2;
        
        return totalReport;
    }
}
    