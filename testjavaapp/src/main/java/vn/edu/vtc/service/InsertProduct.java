package vn.edu.vtc.service;

import vn.edu.vtc.persistance.Product;

import java.util.Scanner;

public class InsertProduct {
    public static Product inputInformation(){
    Product product = new Product();
    System.out.println("Input product information:\n");
            System.out.println("Product name : ");
            String name="";
            do try{

                name=new Scanner(System.in).nextLine();
                if (name.equalsIgnoreCase("exist")){return null;}
                break;
            } catch (Exception e){
                System.out.println("Wrong!");
            }while (true);
            System.out.println("Product description:");
            System.out.println("--------------------");
            System.out.println("General description: ");
            String opinion="";
            do try{
                opinion=new Scanner(System.in).nextLine();
                if (opinion.equalsIgnoreCase("exist")){return null;}
                break;
            } catch (Exception e){
                System.out.println("Wrong!");
            }while (true);
            System.out.println("Size: ");
            String size="";
            do try{
                size=new Scanner(System.in).nextLine();
                if (size.equalsIgnoreCase("exist")){return null;}
                break;
            } catch (Exception e){
                System.out.println("Wrong!");
            }while (true);
            System.out.println("Shape:");
            String shape="";
            do try{
                shape=new Scanner(System.in).nextLine();
                if (shape.equalsIgnoreCase("exist")){return null;}
                break;
            } catch (Exception e){
                System.out.println("Wrong!");
            }while (true);
            System.out.println("Color:");
            String color="";
            do try{
                color=new Scanner(System.in).nextLine();
                if (color.equalsIgnoreCase("exist")){return null;}
                break;
            } catch (Exception e){
                System.out.println("Wrong!");
            }while (true);
            System.out.println("Origin: ");
            String origin="";
            do try{
            origin= new Scanner(System.in).nextLine();
                if (origin.equalsIgnoreCase("exist")){return null;}
                break;
            } catch (Exception e){
                System.out.println("Wrong!");
            }while (true);
            System.out.println("Material :");
            String material="";
            do try{
                material=new Scanner(System.in).nextLine();
                if (material.equalsIgnoreCase("exist")){return null;}
                break;
            } catch (Exception e){
                System.out.println("Wrong!");
            }while (true);
            System.out.println("Purpose:");
            String purpose="";
            do try{
                purpose= new Scanner(System.in).nextLine();
                if (purpose.equalsIgnoreCase("exist")){return null;}
                break;
            } catch (Exception e){
                System.out.println("Wrong!");
            }while (true);
            System.out.println("-------------------------\n");

            System.out.println("Category: ");
            String category="";
            do try{
                category=new Scanner(System.in).nextLine();
                if (category.equalsIgnoreCase("exist")){return null;}
                break;
            } catch (Exception e){
                System.out.println("Wrong!");
            }while (true);
            System.out.println("Price:");
            Double price=0.;
            do try{
                price = new Scanner(System.in).nextDouble();
                break;
            } catch (Exception e){
                System.out.println("Wrong!");
            }while (true);
            System.out.println("Left quantity: ");
            int quantity=0;
            do try{
                quantity= new Scanner(System.in).nextInt();
                break;
            } catch (Exception e){
                System.out.println("Wrong!");
            }while (true);
            Integer amount=0;
            System.out.println("Supplier:");
            Integer supplier_id=1;
            String description = opinion + ";" + size + ";" + shape + ";" + color + ";" + origin + ";" + material + ";" + purpose;

            System.out.println("Insert: Y/N");
            String check = new Scanner(System.in).nextLine();
            if (check.equalsIgnoreCase("Y")) {
            product.setName(name);
            product.setLeftQuantity(quantity);
            product.setDescription(description);
            product.setCategory(category);
            product.setSupplier_id(supplier_id);
            product.setPrice(price);
            return product;
        }
            return null;
    }

    }

