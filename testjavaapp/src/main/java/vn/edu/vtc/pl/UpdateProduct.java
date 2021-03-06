package vn.edu.vtc.pl;

import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.persistance.Product;

import java.util.Scanner;

public class UpdateProduct {
    ProductBL productBL=new ProductBL();
    public boolean updateProduct(){
        int id =StaticFuncitionService.inputId();
        Product product= InsertProduct.inputInformation(id);
        product.setProductId(id);
        return (productBL.updateProduct(product));
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
        return (productBL.updateProduct(newPrice,id));
    }
}
