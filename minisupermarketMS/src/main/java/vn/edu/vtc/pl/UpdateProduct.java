package vn.edu.vtc.pl;

import java.util.Scanner;

import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.persistance.Product;

public class UpdateProduct {
    ProductBL productBL=new ProductBL();
    public boolean updateProduct(){
        String id =StaticFunctionService.inputId();
        Product product= InsertProduct.inputInformation(id);
        product.setProductId(id);
        return (productBL.updateProduct(product));
    }
    public boolean updatePrice(){
        String id=StaticFunctionService.inputId();

        Double newPrice=0.;
        do try{
            System.out.print("input new price:");
            newPrice=new Scanner(System.in).nextDouble();
            break;
        }catch (Exception e){
            System.out.println("Wrong types!");
        }while (true);
        return (productBL.updateProduct(newPrice,id));
    }
}