package vn.edu.vtc.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vn.edu.vtc.persistance.Product;

public class ProductDAL implements DAL<Product> {
    public int update(Double newPrice, String productId) {
        if (newPrice == 0. || productId==null) {
            return 0;
        }
        try (Connection connection = DbUtil.getConnection()) {
            try (
                    PreparedStatement preparedStatement = connection.prepareStatement("update Products set price=? where product_id=?;")) {
                preparedStatement.setDouble(1, newPrice);
                preparedStatement.setString(2, productId);
                Statement statement = connection.createStatement();
                statement.execute("lock tables Products write,Invoices write,OrderDetail write,Stores write;");
                if (preparedStatement.executeUpdate() != 1) {
                    return 0;
                }
            } catch (Exception e) {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    private Product getProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setProductId(resultSet.getString("product_id"));
        product.setName(resultSet.getString("product_name"));
        product.setDescription(resultSet.getString("product_Description"));
        try {
            product.setDiscounted(resultSet.getDouble("discount_value"));
        } catch (Exception e) {
            product.setDiscounted(0.);
        }
//        product.setCategory();
        product.setPrice(resultSet.getDouble("price"));
        try {
            product.setIsSelling(resultSet.getInt("stopSelling"));
        } catch (Exception e) {
            product.setIsSelling(0);
        }
        try {
            product.setLeftQuantity(resultSet.getInt("left_quantity"));
        } catch (Exception e) {
            product.setLeftQuantity(0);
        }
        try {
            product.setSupplier_id(resultSet.getInt("supplier_id"));
        } catch (Exception e) {
            product.setSupplier_id(1);
        }
        
        return product;
    }

    @Override
    public int insert(Product newProduct) {
        try (Connection connection = DbUtil.getConnection();
             Statement statement = connection.createStatement()) {
            //check exist
            if (getById(newProduct.getProductId()) != null) {
                return 0;
            }
            connection.setAutoCommit(false);
            statement.execute("lock tables Products write,Invoices write,OrderDetail write,Stores write;");
            try (PreparedStatement preparedStatement = connection.prepareStatement("insert into Products(product_id,product_name,product_Description,price,left_quantity,supplier_id)values(?,?,?,?,?,?);")) {
                preparedStatement.setString(1, newProduct.getProductId());
                preparedStatement.setString(2, newProduct.getName());
                preparedStatement.setString(3, newProduct.getDescription());
                preparedStatement.setDouble(4, newProduct.getPrice());
                preparedStatement.setInt(5, newProduct.getLeftQuantity());
                preparedStatement.setInt(6, newProduct.getSupplier_id());
                if (preparedStatement.executeUpdate() != 1) {
                    System.out.println("1");
                    connection.rollback();
                    return 0;
                }
            } catch (Exception e) {
                connection.rollback();
                return 0;
            }
            statement.execute("unlock tables");
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            return 0;
        }
        return 1;
    }

    @Override
    public Product getById(int productId) {
        Product product = null;
        if (productId == -1) {
            return null;
        }
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from Products where product_id=?")) {
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = getProduct(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public int update(Product updatingProduct) {
        try (Connection connection = DbUtil.getConnection();
             Statement statement = connection.createStatement()) {
            //if updating was null, do not update
            if (updatingProduct == null) {
                return 0;
            }
            //check exist
            if (getById(updatingProduct.getProductId()) == null) {
                return 0;
            }
            //update product
            connection.setAutoCommit(false);
            statement.execute("lock tables Products write,Invoices write,OrderDetail write,Stores write;");
            try (PreparedStatement preparedStatement = connection.prepareStatement("update Products set product_name=?,product_Description=?,price=?,left_quantity=? where product_id=?;")) {
                preparedStatement.setString(1, updatingProduct.getName());
                preparedStatement.setString(2, updatingProduct.getDescription());
                preparedStatement.setDouble(3, updatingProduct.getPrice());
                preparedStatement.setInt(4, updatingProduct.getLeftQuantity());
                preparedStatement.setString(5, updatingProduct.getProductId());
                if (preparedStatement.executeUpdate() != 1) {
                    return 0;
                }
            } catch (Exception e) {
                return 0;
            }
            connection.setAutoCommit(true);
            statement.execute("unlock tables");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public boolean getByName(String name) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from Products where product_name=?;")) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Product getById(String productId) {
        Product product = null;
        if (productId==null) {
            return null;
        }
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from Products where product_id=?")) {
            preparedStatement.setString(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = getProduct(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}