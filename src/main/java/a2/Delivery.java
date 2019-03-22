package a2;

public class Delivery {
    protected String address;
    protected Order order;

    Delivery(String address, Order order) {
        this.address = address;
        this.order = order;
    }

    public void saveToFile() {}
}

class UberEats extends Delivery {
    UberEats(String address, Order order) {
        super(address, order);
    }

    @Override
    public void saveToFile() {
        System.out.println(this.order);
    }
}

class Foodora extends Delivery {
    Foodora(String address, Order order) {
        super(address, order);
    }

    @Override
    public void saveToFile() {
        super.saveToFile();
    }
}

class PickUp extends Delivery {
    PickUp(String address, Order order) {
        super(address, order);
    }

    @Override
    public void saveToFile() { }
}