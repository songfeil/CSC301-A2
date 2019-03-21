package a2;

import java.util.ArrayList;

public class PizzaBuilder{
    private Item size;
    private PizzaType type;
    private ArrayList<Item> toppings;

    public PizzaBuilder() {
        size = null;
        type = null;
        toppings = new ArrayList<Item>();
    }

    public PizzaBuilder addTopping(Item p) {
        toppings.add(p);
        return this;
    }

    public PizzaBuilder addSize(Item p) {
        size = p;
        return this;
    }

    public PizzaBuilder addType(PizzaType p) {
        type = p;
        return this;
    }

    public PizzaBuilder removeTopping(int idx) {
        toppings.remove(idx);
        return this;
    }


    public Pizza build() throws InvalidPizzaException {
        // Throw an error if the order is empty
        if (toppings.size() == 0 || size == null || type == null) {
            throw new InvalidPizzaException("This pizza is invalid.");
        }

        return new Pizza(size, type, toppings);
    }
}

class InvalidPizzaException extends Exception {
    InvalidPizzaException(String errorMessage) {}
}