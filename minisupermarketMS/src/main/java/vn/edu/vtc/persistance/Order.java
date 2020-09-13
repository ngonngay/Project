package vn.edu.vtc.persistance;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> productList = new ArrayList<>();
    private Integer id;
    private Timestamp date;
    private Integer staff_id;
    private Integer store_id = 1;
    private String store_name;
    private String address;
    private String staff_name;

    public Order() {
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public Order(List<Product> productList, Integer id, Timestamp date, Integer staff_id, Integer store_id) {
        this.productList = productList;
        this.id = id;
        this.date = date;
        this.staff_id = staff_id;
        this.store_id = store_id;
    }

    public Order(List<Product> productList, Integer staff_id) {
        this.productList = productList;
        this.staff_id = staff_id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    public boolean addProduct(Product product){
        productList.add(product);
        return true;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }


    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "productList=" + productList +
                ", id=" + id +
                ", staff name = " +staff_name+
                ", date=" + date +
                ", staff_id=" + staff_id +
                ", store_id=" + store_id +
                ", store_name='" + store_name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}