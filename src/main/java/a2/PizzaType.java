package a2;

public class PizzaType extends Item{
    private String creatingMethods;

    public PizzaType(String name, double price, String methods) {
        super(name, price);
        this.creatingMethods = methods;
    }

    public void make() {
        System.out.println("Processing method for pizza type: " + this.getName());
    }

    public String getCreatingMethods() {
        return creatingMethods;
    }
}
