package a2;

import java.util.List;

public class Order {
    private int id;
    private List<Item> items;

    Order(int id, List<Item> items) {
        this.id = id;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getPrice() {
        double price = 0.0;
        for (Item item: items) {
            price += item.getPrice();
        }
        return price;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("--- Order ID: ");
        sb.append(Integer.toString(id));
        sb.append("---\n");

        for (int i = 0; i < items.size(); i++) {
            sb.append(Integer.toString(i + 1));
            sb.append(". ");
            sb.append(items.get(i));
            sb.append("\n");
        }

        sb.append("\n");
        sb.append("Total Price: ");
        sb.append(Double.toString(getPrice()));
        sb.append("\n");

        return sb.toString();
    }

}

