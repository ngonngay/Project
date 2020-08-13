package vn.edu.vtc.dal;

import vn.edu.vtc.persistance.Product;

import java.sql.*;

public class ProductDAL {
    public Product getProductById(Integer product_id){
        Product product=null;
        try (Connection connection=DbUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("select *from Products where product_id=?;")) {
            preparedStatement.setInt(1,product_id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                product=getProduct(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
    public int insertProduct(Product newProduct){
        try(Connection connection=DbUtil.getConnection();
            Statement statement = connection.createStatement()) {
            //check exist
            if (getProductById(newProduct.getProduct_id())!=null){
                return 0;
            }
            connection.setAutoCommit(false);
            statement.execute("lock tables Products write,Invoices write,OrderDetail write,Stores write;");
            try(PreparedStatement preparedStatement = connection.prepareStatement("insert into Products(product_id,product_name,product_Description,price,left_quantity,supplier_id)values(?,?,?,?,?,?);")){
                preparedStatement.setInt(1,newProduct.getProduct_id());
                preparedStatement.setString(2,newProduct.getName());
                preparedStatement.setString(3,newProduct.getDescription());
                preparedStatement.setDouble(4,newProduct.getPrice());
                preparedStatement.setInt(5,newProduct.getLeftQuantity());
                preparedStatement.setInt(6,newProduct.getSupplier_id());
                if (preparedStatement.executeUpdate()!=1){
                    connection.rollback();
                    return 0;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            statement.execute("unlock tables");
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 1;
    }
    public Integer updateProduct(Product updatingProduct){

        try(Connection connection=DbUtil.getConnection();
            Statement statement=connection.createStatement()) {
            //if updating was null, do not update
            if (updatingProduct==null){
                return 0;
            }
            //check exist
            if (getProductById(updatingProduct.getProduct_id())==null){
                return 0;
            }
            //update product
            try(PreparedStatement preparedStatement=connection.prepareStatement("update Products set product_name=?,product_Description=?,price=?,left_quantity=? where product_id=?;")){
                preparedStatement.setString(1,updatingProduct.getName());
                preparedStatement.setString(2,updatingProduct.getDescription());
                preparedStatement.setDouble(3,updatingProduct.getPrice());
                preparedStatement.setInt(4,updatingProduct.getLeftQuantity());
                preparedStatement.setInt(5,updatingProduct.getProduct_id());
                if (preparedStatement.executeUpdate()!=1){
                    return 0;
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
    private Product getProduct(ResultSet resultSet) throws SQLException {
        Product product=new Product();
        product.setProduct_id(resultSet.getInt("product_id"));
        product.setName(resultSet.getString("product_name"));
        product.setDescription(resultSet.getString("product_Description"));
//        product.setCategory();
        product.setPrice(resultSet.getDouble("price"));
        product.setIsSelling(resultSet.getShort("stopSelling"));
        product.setLeftQuantity(resultSet.getInt("left_quantity"));
        product.setSupplier_id(resultSet.getInt("supplier_id"));
        return product;
    }
}
