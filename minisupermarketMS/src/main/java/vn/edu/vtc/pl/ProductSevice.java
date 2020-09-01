package vn.edu.vtc.pl;

import java.util.Scanner;

import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.persistance.Product;

public class ProductSevice {
    static ProductBL productBL=new ProductBL();
    public static Product searchProduct(){
        System.out.println("|--------------------------------|");
        System.out.println("|          Search Product        |");
        System.out.println("|--------------------------------|\n");
        String id=ProductSevice.inputId();
        return new ProductBL().getById(id);
    }
    public static boolean updateProduct(){
        String id =ProductSevice.inputId();
        Product product= inputInformation(id);
        product.setProductId(id);
        return (productBL.updateProduct(product));
    }
    public static void updatePrice(){
        String id="";
        Product product=null;
        do {
            id=inputId();
            product=productBL.getById(id);
            if (product!=null) {
                System.out.println(product);
                break;
            }
            System.out.println("Product doesn't exist");
        } while (true);
        
        Double newPrice=0.;
        do try{
            System.out.print("input new price:");
            newPrice=new Scanner(System.in).nextDouble();
            break;
        }catch (Exception e){
            System.out.println("Wrong types!");
        }while (true);
        System.out.print("Update price ?(Y/N) ");
        String check1=new Scanner(System.in).nextLine();
        if (check1.equalsIgnoreCase("Y")) {
            if(productBL.updateProduct(newPrice,id)){
                System.out.println("Update Success!");
                System.out.println("Product with item number "+ id + " has been updated for the price of "+product.getPrice()+" to "+newPrice);
            }else{
                System.out.println("Update failed,please try again!");
            }
        } else {
            return;
        }
       
    }
    public static String inputId() {
        String productId = null;
        do
            try {
                System.out.print("Product ID: ");
                productId = new Scanner(System.in).nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Wrong!");
            }
        while (true);
        return productId;
    }
    public static Product inputInformation(String productId) {
        Product product = new Product();
        ProductBL productBL = new ProductBL();
        System.out.println("Input product information:\n");
        String name = " ";
        do
            try {
                System.out.print("\nProduct name : ");
                name = new Scanner(System.in).nextLine();
                if (name.equalsIgnoreCase("exit")) {
                    return null;
                }
                if (productBL.getByName(name)) {
                    System.out.println("This name has existed!");
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Wrong!");
            }
        while (true);
        System.out.println("Product description:");
        System.out.println("--------------------");
        System.out.println("General description: ");
        String opinion = "";
        do
            try {
                opinion = new Scanner(System.in).nextLine();
                if (opinion.equalsIgnoreCase("exit")) {
                    return null;
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong!");
            }
        while (true);
        System.out.print("\nSize: ");
        String size = "";
        do
            try {
                size = new Scanner(System.in).nextLine();
                if (size.equalsIgnoreCase("exist")) {
                    return null;
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong!");
            }
        while (true);
        System.out.print("\nShape:");
        String shape = "";
        do
            try {
                shape = new Scanner(System.in).nextLine();
                if (shape.equalsIgnoreCase("exist")) {
                    return null;
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong!");
            }
        while (true);
        System.out.print("\nColor:");
        String color = "";
        do
            try {
                color = new Scanner(System.in).nextLine();
                if (color.equalsIgnoreCase("exist")) {
                    return null;
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong!");
            }
        while (true);
        System.out.print("\nOrigin: ");
        String origin = "";
        do
            try {
                origin = new Scanner(System.in).nextLine();
                if (origin.equalsIgnoreCase("exist")) {
                    return null;
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong!");
            }
        while (true);
        System.out.print("\nMaterial :");
        String material = "";
        do
            try {
                material = new Scanner(System.in).nextLine();
                if (material.equalsIgnoreCase("exit")) {
                    return null;
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong!");
            }
        while (true);
        System.out.print("\nPurpose:");
        String purpose = "";
        do
            try {
                purpose = new Scanner(System.in).nextLine();
                if (purpose.equalsIgnoreCase("exist")) {
                    return null;
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong!");
            }
        while (true);
        System.out.println("-------------------------\n");



        Double price = 0.;
            do try {
                System.out.println("\nPrice:");
                price = new Scanner(System.in).nextDouble();
                if (price>0) {
                    break;
                }else {
                    System.out.print("Price must be greater than 0!");
                }
            } catch (Exception e) {
                System.out.println("Wrong!");
            }while (true);
        int quantity = 0;
        do
            try {
                System.out.print("\nUnit quantity: ");
                quantity = new Scanner(System.in).nextInt();
                if (quantity>0) {
                    break;
                }else {
                    System.out.println("Quantity must be greater than 0!");
                }
            } catch (Exception e) {
                System.out.println("Wrong!");
            }
        while (true);
        Integer supplier_id = 1;
        String description = opinion + ";" + size + ";" + shape + ";" + color + ";" + origin + ";" + material + ";"
                + purpose;

        System.out.println("Insert Product: Y/N");
        String check = new Scanner(System.in).nextLine();
        if (check.equalsIgnoreCase("Y")) {
            product.setName(name);
            product.setLeftQuantity(quantity);
            product.setDescription(description);
            product.setSupplier_id(supplier_id);
            product.setPrice(price);
            return product;
        }
        return null;
    }
}