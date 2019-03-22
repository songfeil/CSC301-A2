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

class PizzaTypeFactory {
    Item generateType(String type, double price) throws NotSupportedPizzaTypeException {

        if (type.equalsIgnoreCase("Pepperoni")) {
            return new Pepperoni(price);
        } else if (type.equalsIgnoreCase("Margherita")) {
            return new Margherita(price);
        } else if (type.equalsIgnoreCase("Vegetarian")) {
            return new Vegetarian(price);
        } else if (type.equalsIgnoreCase("Neapolitan")) {
            return new Neapolitan(price);
        }

        throw new NotSupportedPizzaTypeException();
    }
}

class NotSupportedPizzaTypeException extends Exception {}