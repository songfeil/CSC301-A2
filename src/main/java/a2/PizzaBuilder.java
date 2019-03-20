package a2;

import java.util.ArrayList;

public class PizzaBuilder{
    private PizzaSize size;
    private PizzaType type;
    private ArrayList<PizzaTopping> toppings;

    public PizzaBuilder() {
        size = null;
        type = null;
        toppings = new ArrayList<PizzaTopping>();
    }

    public PizzaBuilder addTopping(PizzaTopping p) {
        toppings.add(p);
        return this;
    }

    public PizzaBuilder addSize(PizzaSize p) {
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
    InvalidPizzaException(String errorMessage) {
        super(errorMessage);
    }
}