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

        sb.append(size.getName());
        sb.append(" ");
        sb.append(type.getName());
        sb.append(" ");
        sb.append("Pizza, ");

        // Add topping
        sb.append("with ");
        for (Item pt: toppings) {
            sb.append(pt.getName());
            sb.append(", ");
        }

        sb.append("\t");
        sb.append(this.getPrice());

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
