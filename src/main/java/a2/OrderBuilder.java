package a2;

import java.util.ArrayList;

public class OrderBuilder{
    static private int currOrderId = 0;

    private ArrayList<Item> items;

    public OrderBuilder() {
        items = new ArrayList<Item>();
    }

    public OrderBuilder addItem(Item p) {
        items.add(p);
        return this;
    }

    public OrderBuilder removeItem(int idx) {
        items.remove(idx);
        return this;
    }

    public Order build() throws EmptyOrderException {
        // Throw an error if the order is empty
        if (items.size() == 0) {
            throw new EmptyOrderException("This order is empty.");
        }

        return new Order(++currOrderId, items);
    }
}

class EmptyOrderException extends Exception {
    EmptyOrderException(String errorMessage) {
        super(errorMessage);
    }
}