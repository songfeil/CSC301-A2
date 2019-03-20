package a2;

public class Item {
    private String name;
    private double price;


    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class NoSuchItemException extends Exception {}
