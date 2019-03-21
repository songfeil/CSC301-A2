package a2;

enum DeliveryMethod {
    UBEREATS,
    FOODORA,
    PICKUP
}

public class Delivery {
    private DeliveryMethod method;
    private String address;

    public Delivery(DeliveryMethod method, String address) {
        this.method = method;
        this.address = address;
    }

    public void saveToFile(Order order) {}
}

class UberEats extends Delivery {
    UberEats(String address) {
        super(DeliveryMethod.UBEREATS, address);
    }

    @Override
    public void saveToFile(Order order) {
        super.saveToFile(order);
    }
}

class Foodora extends Delivery {
    Foodora(String address) {
        super(DeliveryMethod.FOODORA, address);
    }

    @Override
    public void saveToFile(Order order) {
        super.saveToFile(order);
    }
}

class PickUp extends Delivery {
    PickUp(String address) {
        super(DeliveryMethod.PICKUP, address);
    }

    @Override
    public void saveToFile(Order order) { }
}