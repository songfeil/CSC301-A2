package a2;

import java.util.List;

public class Order {
    private int id;
    private List<Item> items;
    private Delivery delivery;

    Order(int id, List<Item> items, Delivery delivery) {
        this.id = id;
        this.items = items;
        this.delivery = delivery;
    }

    public int getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getPrice() {
        return 0.0;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("--- Order ---\n");

        // Add Id
        sb.append("ID: ");
        sb.append(Integer.toString(id));

        // Add Item
        sb.append("Items: ");
        sb.append("\n");
        for (Item d: items) {
            sb.append(d);
            sb.append(" ");
        }

        sb.append("\n");
        sb.append("-------------");

        return sb.toString();
    }

}

