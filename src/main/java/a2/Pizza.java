package a2;

import java.util.List;

public class Pizza extends Item {
    private Item size;
    private PizzaType type;
    private List<Item> toppings;

    Pizza(Item size, PizzaType type, List<Item> toppings) {
        super("Pizza", 0.0);
        this.size = size;
        this.type = type;
        this.toppings = toppings;
    }

    @Override
    public double getPrice() {
        double price = 0.0;
        price += size.getPrice();
        price += type.getPrice();
        for (Item pt : toppings) {
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
        for (Item pt: toppings) {
            sb.append(pt);
            sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PizzaType type = new Vegetarian(0.0);
        Item size = new Item("Large", 1.0);

        PizzaBuilder pb = new PizzaBuilder();
        try {
            Pizza p = pb.addSize(size).addType(type).addTopping(new Item("T1", 1.0)).addTopping(new Item("T2", 0.5)).build();
            System.out.println(p);
        } catch (InvalidPizzaException e) {
            e.printStackTrace();
        }
    }
}
