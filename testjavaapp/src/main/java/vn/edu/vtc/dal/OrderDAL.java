package vn.edu.vtc.dal;

import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;

import java.sql.*;
import java.util.List;


public class OrderDAL implements DAL<Order>{
    public Order createOrder(Order newOrder){
        Order order=new Order();
        //if there no item, do not add order
        if (newOrder.getProductList()==null||newOrder.getProductList().isEmpty()){
            return order;
        }
        //create new order:
        /* step 1: insert newOrder to Invoices table(store_id,staff_id)
         *  step 2: get newOrder id from Invoices (max_id)
         *  step 3: insert list<Product> to OrderDetail
         *  step 4: set value to order (print)
         * */
        try (Connection connection=DbUtil.getConnection();
             Statement statement=connection.createStatement()){
            connection.setAutoCommit(false);
            //lock tables to insert data
            statement.execute("lock tables Products write,Invoices write,OrderDetail write,Stores write;");
                //create new invoice (step1)
                try (PreparedStatement preparedStatement=connection.prepareStatement("insert into Invoices(staff_id,store_id)values(?,?);")){
                    preparedStatement.setInt(1,newOrder.getStaff_id());
                    preparedStatement.setInt(2,1);
                    ResultSet resultSet;
                    if (preparedStatement.executeUpdate()==1){
                        resultSet=statement.executeQuery("select last_insert_id() as invoice_id;");
                        while (resultSet.next()){
                            //get newOrder id (step 2)
                            newOrder.setId(resultSet.getInt("invoice_id"));
                        }

                    }else {
                        //has fails
                        connection.rollback();
                        return order;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                //insert list product to orderDetail
                try (PreparedStatement preparedStatement=connection.prepareStatement("insert into OrderDetail(invoice_id,product_id,quantity,price,discounted)values(?,?,?,?,?);")){
                    for (Product p: newOrder.getProductList()) {
                        /*
                        * decrease amount of p.getLeftQuantity
                        * */
                        preparedStatement.setInt(1,newOrder.getId());
                        preparedStatement.setInt(2,p.getProductId());
                        preparedStatement.setInt(3,p.getAmount());
                        preparedStatement.setDouble(4,p.getPrice());
                        preparedStatement.setDouble(5,p.getDiscounted());
                        if (preparedStatement.executeUpdate()!=1){
                            connection.rollback();
                            return order;
                        }

                    }
                }
                //get new info
                try(PreparedStatement preparedStatement =connection.prepareStatement("select Invoices.invoice_id,invoice_date,store_name,address,OrderDetail.product_id,product_name,OrderDetail.price,OrderDetail.quantity,OrderDetail.discounted,OrderDetail.refunded  from (Stores inner join Invoices on Invoices.store_id=Stores.store_id inner join OrderDetail on Invoices.invoice_id=OrderDetail.invoice_id inner join Products on OrderDetail.product_id=Products.product_id)   where Invoices.invoice_id=?;")){
                    preparedStatement.setInt(1,newOrder.getId());
                    ResultSet resultSet =preparedStatement.executeQuery();
                    while (resultSet.next()){
                        order.setId(resultSet.getInt("invoice_id"));
                        order.setDate(resultSet.getTimestamp("invoice_date"));
                        order.setStore_name(resultSet.getString("store_name"));
                        order.setAddress(resultSet.getString("address"));
                        Product product=getProduct(resultSet);
                        order.getProductList().add(product);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                statement.execute("unlock tables");
                connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    private Product getProduct(ResultSet resultSet) throws SQLException {
        Product product=new Product();
        product.setProductId(resultSet.getInt("product_id"));
        product.setName(resultSet.getString("product_name"));
        product.setAmount(resultSet.getInt("quantity"));
        product.setPrice(resultSet.getDouble("price"));
        product.setDiscounted(resultSet.getDouble("discounted"));
        product.setRefundedInOrder(resultSet.getInt("refunded"));
        return product;
    }

    @Override
    public int insert(Order newOrder) {
        return 0;
    }

    @Override
    public Order getById(int idE) {
        return null;
    }

    @Override
    public int update(Order order) {
        return 0;
    }


    // private Object rollbackTransaction(Connection con) throws SQLException {
    //     // rollback transaction
    //     con.rollback();
    //     // unlock tables
    //     Statement stm = con.createStatement();
    //     stm.execute("unlock tables;");
    //     // set auto commit is true
    //     con.setAutoCommit(true);
    //     return null;
    // }
}
