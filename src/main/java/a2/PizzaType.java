package a2;

public class PizzaType extends Item{
    public PizzaType(String name, double price) {
        super(name, price);
    }

    public void make() {
        System.out.println("Processing method for pizza type: " + this.getName());
    }

}

class Pepperoni extends PizzaType {
    public Pepperoni(double price) {
        super("Pepperoni", price);
    }

    @Override
    public void make() {
        System.out.println("Making Pepperoni");
    }
}

class Margherita extends PizzaType {
    public Margherita(double price) {
        super("Margherita", price);
    }

    @Override
    public void make() {
        System.out.println("Making Margherita");
    }
}

class Vegetarian extends PizzaType {
    public Vegetarian(double price) {
        super("Vegetarian", price);
    }

    @Override
    public void make() {
        System.out.println("Making Vegetarian");
    }
}

class Neapolitan extends PizzaType {
    public Neapolitan(double price) {
        super("Neapolitan", price);
    }

    @Override
    public void make() {
        System.out.println("Making Neapolitan");
    }
}
