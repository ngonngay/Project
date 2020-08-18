package vn.edu.vtc.service;

import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persistance.Product;

import java.util.Scanner;

public class UpdateProduct {
    public boolean updateProduct(){
        int id =StaticFuncitionService.inputId();
        ProductDAL productDAL=new ProductDAL();
        Product product= InsertProduct.inputInformation();
        product.setProductId(id);
        return (productDAL.updateProduct(product)>0);
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
