package a2;

import java.util.List;

public class Pizza {
    private PizzaSize size;
    private PizzaType type;
    private List<PizzaTopping> toppings;

    Pizza(PizzaSize size, PizzaType type, List<PizzaTopping> toppings) {
        this.size = size;
        this.type = type;
        this.toppings = toppings;
    }

    double getPrice() {
        double price = 0.0;
        price += size.getPrice();
        price += type.getPrice();
        for (PizzaTopping pt : toppings) {
            price += pt.getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Pizza  |  ");

        // Add size
        sb.append("Size: ");
        sb.append(size.toString());

        // Add type
        sb.append("  |  Type: ");
        sb.append(type.toString());
        sb.append("\n");

        // Add topping
        sb.append("Toppings: ");
        for (PizzaTopping pt: toppings) {
            sb.append(pt);
            sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PizzaType type = new PizzaType("Vegetarian", 0.0, "Lalala");
        PizzaSize size = new PizzaSize("Large", 1.0);

        PizzaBuilder pb = new PizzaBuilder();
        try {
            Pizza p = pb.addSize(size).addType(type).addTopping(new PizzaTopping("T1", 1.0)).addTopping(new PizzaTopping("T2", 0.5)).build();
            System.out.println(p);
        } catch (InvalidPizzaException e) {
            e.printStackTrace();
        }
    }
}
