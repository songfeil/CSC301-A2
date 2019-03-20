package a2;

import java.util.ArrayList;

public class Controller {
    private ArrayList<Order> orders;
    public Menu drinkMenu;
    public Menu toppingsMenu;
    public Menu sizeMenu;
    public Menu typeMenu;

    Controller() {
        this.drinkMenu = new Menu();
        this.toppingsMenu = new Menu();
        this.sizeMenu = new Menu();
        this.typeMenu = new Menu();
    }

    public void addOrder(Order e) {
        orders.add(e);
    }

    public static void main(String[] args) {

    }
}
