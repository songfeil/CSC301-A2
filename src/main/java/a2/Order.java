package a2;

import java.util.List;

public class Order {
    private int id;
    private List<Pizza> pizzas;
    private List<Drink> drinks;

    Order(int id, List<Pizza> pizzas, List<Drink> drinks) {
        this.id = id;
        this.pizzas = pizzas;
        this.drinks = drinks;
    }

    public int getId() {
        return id;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public List<Drink> getDrinks() {
        return drinks;
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

        // Add Pizza
        sb.append(" | Pizzas: ");
        for (Pizza p: pizzas) {
            sb.append(p);
            sb.append(" ");
        }

        // Add Drink
        sb.append("Drinks: ");
        for (Drink d: drinks) {
            sb.append(d);
            sb.append(" ");
        }

        sb.append("\n");
        sb.append("-------------");

        return sb.toString();
    }
}

