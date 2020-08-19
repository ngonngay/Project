package vn.edu.vtc.service;

import java.util.ArrayList;

public class MenuService {
    public ArrayList<String> cashierMenu = new ArrayList<String>();
    public ArrayList<String> managerMenu = new ArrayList<String>();
    public ArrayList<String> updateMenu = new ArrayList<String>();
    public ArrayList<String> updateOrder = new ArrayList<String>();
    public MenuService(){
        cashierMenu.add("Welcome to Cashier's Menu");
        cashierMenu.add("1. Create Order");
        cashierMenu.add("2. Update Order");
        cashierMenu.add("0. Exit");
        managerMenu.add("Welcome to Manager's Menu");
        managerMenu.add("1. Insert product");
        managerMenu.add("2. Update product");
        managerMenu.add("0. Exit");
        updateMenu.add("Update Menu");
        updateMenu.add("1. Update price");
        updateMenu.add("2. Update all information");
        updateMenu.add("0. Exit");
        updateOrder.add("Update order menu");
        updateOrder.add("1. Refunded order");
        updateOrder.add("2. Update quantity");
        updateOrder.add("0. Exit");

    }
}
