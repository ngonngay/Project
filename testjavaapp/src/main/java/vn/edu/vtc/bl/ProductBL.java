package vn.edu.vtc.bl;

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

    public Product getById(int productId) {
        Product item = new Product();
        return dal.getById(productId);
    }
    public boolean updateProduct(Product updatingProduct){
        return dal.update(updatingProduct)>0;
    }
    public boolean updateProduct(Double newPrice,int productId){

        return productDAL.update(newPrice, productId)>0;
    }
    public boolean getByName(String name){
        return productDAL.getByName(name);
    }
}
