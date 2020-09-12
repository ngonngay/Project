package vn.edu.vtc.bl;

import java.util.List;

import vn.edu.vtc.dal.DAL;
import vn.edu.vtc.dal.DalFactory;
import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persistance.Product;

public class ProductBL {
    private DAL<Product> dal = DalFactory.getDAL(Product.class);
    ProductDAL productDAL=(ProductDAL)dal;

    public boolean insertProduct(Product newProduct) {
        return dal.insert(newProduct) > 0;
    }

    public Product getById(String productId) {
        Product item = new Product();
        return productDAL.getById(productId);
    }
    public boolean updateProduct(Product updatingProduct){
        return dal.update(updatingProduct)>0;
    }
    public boolean updateProduct(Double newPrice,String productId){
        return productDAL.update(newPrice, productId)>0;
    }
    public boolean getByName(String name){
        return productDAL.getByName(name);
    }
    public List<Product> getByName2(String name){
        return productDAL.getByName2(name);
    }
}