package vn.edu.vtc.pl;

import java.util.Scanner;

import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.persistance.Product;

public class InsertProduct {
    public static Product inputInformation(String productId) {
        Product product = new Product();
        ProductBL productBL = new ProductBL();
        System.out.println("Input product information:\n");
        String name = " ";
        do
            try {
                System.out.println("Product name : ");
                name = new Scanner(System.in).nextLine();
                if (name.equalsIgnoreCase("exist")) {
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
                if (opinion.equalsIgnoreCase("exist")) {
                    return null;
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong!");
            }
        while (true);
        System.out.println("Size: ");
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
        System.out.println("Shape:");
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
        System.out.println("Color:");
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
        System.out.println("Origin: ");
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
        System.out.println("Material :");
        String material = "";
        do
            try {
                material = new Scanner(System.in).nextLine();
                if (material.equalsIgnoreCase("exist")) {
                    return null;
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong!");
            }
        while (true);
        System.out.println("Purpose:");
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
                System.out.println("Price:");
                price = new Scanner(System.in).nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Wrong!");
            }while (true);
        String calculationUnit = "";
        do
            try {
                calculationUnit = new Scanner(System.in).nextLine();
                if (calculationUnit.equalsIgnoreCase("exist")) {
                    return null;
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong!");
            }
        while (true);
        System.out.println("Unit quantity: ");
        int quantity = 0;
        do
            try {
                quantity = new Scanner(System.in).nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Wrong!");
            }
        while (true);
        Integer supplier_id = 1;
        String description = opinion + ";" + size + ";" + shape + ";" + color + ";" + origin + ";" + material + ";"
                + purpose;

        System.out.println("Insert: Y/N");
        String check = new Scanner(System.in).nextLine();
        if (check.equalsIgnoreCase("Y")) {
            product.setName(name);
            product.setLeftQuantity(quantity);
            product.setDescription(description);
            product.setCalculationUnit(calculationUnit);
            product.setSupplier_id(supplier_id);
            product.setPrice(price);
            System.out.println(product.getPrice());
            return product;
        }
        return null;
    }
}