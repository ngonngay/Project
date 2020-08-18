package vn.edu.vtc.service;

import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persistance.Product;

import java.util.Scanner;

public class UpdateProduct {
    public boolean updateProduct(){
        System.out.println("Input productID:");
        int product=-1;
        do try{
            Scanner scanner=new Scanner(System.in);
            product=scanner.nextInt();
            scanner.close();
            break;
        }catch (Exception e){
            System.out.println("Wrong types!");
        }while (true);






        return true;
    }
    public boolean updatePrice(){
        int id=StaticFuncitionService.inputId();
        System.out.println("input new price:");
        Double newPrice=0.;
        do try{
            newPrice=new Scanner(System.in).nextDouble();
            break;
        }catch (Exception e){
            System.out.println("Wrong types!");
        }while (true);
        ProductDAL productDAL=new ProductDAL();
        return (productDAL.updatePrice(newPrice,id)>1);
    }
}
