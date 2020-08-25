package vn.edu.vtc.bl;

import java.sql.SQLException;
import java.util.List;

import vn.edu.vtc.dal.DAL;
import vn.edu.vtc.dal.DalFactory;
import vn.edu.vtc.dal.OrderDAL;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;

public class OrderBL {
    private DAL<Order> dal= DalFactory.getDAL(Order.class);
    OrderDAL orderDAL=(OrderDAL) dal;
    public Order createOrder(Order newOrder){
        return orderDAL.createOrder(newOrder);
    }

    public boolean refundOrder(int orderId) throws SQLException {
        return orderDAL.refundOrder(orderId)>0;
    }
    public Order refundProduct(List<Product> productList, int orderId){
        return orderDAL.refundProduct(productList,orderId);
    }
    public Order getbyId(int orderId){
        return dal.getById(orderId);
    }
}