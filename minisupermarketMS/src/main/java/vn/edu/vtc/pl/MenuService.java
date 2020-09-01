package vn.edu.vtc.pl;

import java.util.ArrayList;

public class MenuService {
    public ArrayList<String> cashierMenu = new ArrayList<String>();
    public ArrayList<String> managerMenu = new ArrayList<String>();
    public ArrayList<String> updateMenu = new ArrayList<String>();
    public ArrayList<String> updateOrder = new ArrayList<String>();
    public MenuService(){
        cashierMenu.add("\n+--------------------------------+");
        cashierMenu.add("|                                |");
        cashierMenu.add("|---Welcome to Cashier's Menu!---|");
        cashierMenu.add("|                                |");
        cashierMenu.add("|--------------------------------|");
        cashierMenu.add("|   1. Create order              |");
        cashierMenu.add("|--------------------------------|");
        cashierMenu.add("|   2. Update order              |");
        cashierMenu.add("|--------------------------------|");
        cashierMenu.add("|   0. Log out                   |");
        cashierMenu.add("\\--------------------------------/");
        cashierMenu.add("\n");

        managerMenu.add("\n+--------------------------------+");
        managerMenu.add("|                                |");
        managerMenu.add("|---Welcome to Manager's Menu!---|");
        managerMenu.add("|                                |");
        managerMenu.add("|--------------------------------|");
        managerMenu.add("|   1. Insert product            |");
        managerMenu.add("|--------------------------------|");
        managerMenu.add("|   2. Update product            |");
        managerMenu.add("|--------------------------------|");
        managerMenu.add("|   3. Search product            |");
        managerMenu.add("|--------------------------------|");
        managerMenu.add("|   0. Log out                   |");
        managerMenu.add("\\--------------------------------/");
        managerMenu.add("\n");
        updateOrder.add("\n+--------------------------------+");
        updateOrder.add("|---Welcome to Cashier's Menu!---|");
        updateOrder.add("|--------------------------------|");
        updateOrder.add("|          Update order          |");
        updateOrder.add("|                                |");
        updateOrder.add("|     ----- Update Menu -----    |");
        updateOrder.add("|                                |");
        updateOrder.add("|   1. Refund order              |");
        updateOrder.add("|   2. Refund product            |");
        updateOrder.add("|   0. Back                      |");
        updateOrder.add("\\--------------------------------/");
        updateOrder.add("\n");

        updateMenu.add("+--------------------------------+");
        updateMenu.add("|---Welcome to Manager's Menu!---|");
        updateMenu.add("|--------------------------------|");
        updateMenu.add("|   ----- Update product -----   |");
        updateMenu.add("|                                |");
        updateMenu.add("|     ----- Update Menu -----    |");
        updateMenu.add("|                                |");
        updateMenu.add("|  1. Update price               |");
        updateMenu.add("|  2. Update information         |");
        updateMenu.add("|  0. Back                       |");
        updateMenu.add("\\--------------------------------/");
        updateMenu.add("\n");

    }
}