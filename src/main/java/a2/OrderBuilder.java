package a2;

import java.util.ArrayList;

public class OrderBuilder{
    static private int currOrderId = 0;

    private ArrayList<Pizza> pizzas;
    private ArrayList<Drink> drinks;

    public OrderBuilder() {
        pizzas = new ArrayList<Pizza>();
        drinks = new ArrayList<Drink>();
    }

    public OrderBuilder addPizza(Pizza p) {
        pizzas.add(p);
        return this;
    }

    public OrderBuilder addDrink(Drink d) {
        drinks.add(d);
        return this;
    }

    public OrderBuilder removePizza(int idx) {
        pizzas.remove(idx);
        return this;
    }

    public OrderBuilder removeDrink(int idx) {
        pizzas.remove(idx);
        return this;
    }

    public Order build() throws EmptyOrderException {
        // Throw an error if the order is empty
        if (pizzas.size() == 0 && drinks.size() == 0) {
            throw new EmptyOrderException("This order is empty.");
        }

        return new Order(++currOrderId, pizzas, drinks);
    }
}

class EmptyOrderException extends Exception {
    EmptyOrderException(String errorMessage) {
        super(errorMessage);
    }
}