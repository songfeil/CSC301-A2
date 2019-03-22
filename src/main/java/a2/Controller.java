package a2;

import java.util.ArrayList;
import java.util.Map;

public class Controller {
    private ArrayList<Order> orders;
    public Map<String, Menu> menuMap;

    Controller() {
        MenuDAO dao = new MenuDAO();
        menuMap = dao.getMenuMap();

        orders = new ArrayList<Order>();
    }

    public void addOrder(Order e) {
        orders.add(e);
    }

    public void cancelOrderByIndex(int idx) {
        try {
            orders.remove(idx - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No order with order ID " + Integer.toString(idx - 1));
        }
    }

    public Order getOrderByIndex(int idx) {
        try {
            return orders.get(idx - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No order with order ID " + Integer.toString(idx - 1));
            return null;
        }
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public static void main(String[] args) {

    }
}
