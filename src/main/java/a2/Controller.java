package a2;

import java.util.ArrayList;
import java.util.Map;

public class Controller {
    private ArrayList<Order> orders;
    public Map<String, Menu> menuMap;

    Controller(String filename) {
        MenuDAO dao = new MenuDAO(filename);
        menuMap = dao.getMenuMap();

        orders = new ArrayList<Order>();
    }

    public void addOrder(Order e) {
        orders.add(e);
    }

    public void cancelOrder(Order o) {
        if (o != null) {
            orders.remove(o);
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
