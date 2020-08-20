package vn.edu.vtc.bl;

import vn.edu.vtc.dal.DAL;
import vn.edu.vtc.dal.DalFactory;
import vn.edu.vtc.dal.OrderDAL;
import vn.edu.vtc.persistance.Order;

import java.sql.SQLException;

public class OrderBL {
    private DAL<Order> dal= DalFactory.getDAL(Order.class);
    public Order createOrder(Order newOrder){
        OrderDAL orderDAL=(OrderDAL) dal;
        return orderDAL.createOrder(newOrder);
    }

    public boolean refundOrder(int orderId) throws SQLException {
        OrderDAL orderDAL=(OrderDAL) dal;
        return orderDAL.refundOrder(orderId)>0;
    }
}
