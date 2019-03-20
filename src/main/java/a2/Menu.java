package a2;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    private ArrayList<String> items;
    private HashMap<String, Double> itemPrice;
    private HashMap<String, ItemType> itemType;
    private HashMap<String, String> pizzaTypeMethods;

    public Menu() {

    }

    public Menu(ArrayList<String> items, HashMap<String, Double> itemPrice, HashMap<String, ItemType> itemType, HashMap<String, String> pizzaTypeMethods) {
        this.items = items;
        this.itemPrice = itemPrice;
        this.itemType = itemType;
        this.pizzaTypeMethods = pizzaTypeMethods;
    }

    public double getPrice(String itemName) {
        return itemPrice.get(itemName);
    }

    public void getFullMenu() {
        System.out.println("Full menu placeholder.");
    }

    public Item newItem(String name) throws NoSuchItemException {
        if (itemPrice.get(name) == null || itemType.get(name) == null) {
            throw new NoSuchItemException();
        }

        ItemType type = itemType.get(name);
        Item newItem;

        switch (type) {
            case DRINK:
                newItem = new Drink(name, itemPrice.get(name));
                break;
            case PSIZE:
                newItem = new PizzaSize(name, itemPrice.get(name));
                break;
            case PTOPPING:
                newItem = new PizzaTopping(name, itemPrice.get(name));
                break;
            case PTYPE:
                newItem = new PizzaType(name, itemPrice.get(name), pizzaTypeMethods.get(name));
                break;
            default:
                newItem = null;
        }

        return newItem;
    }

    public Item newItemByIndex(int idx) throws NoSuchItemException, IndexOutOfBoundsException {
        String name = items.get(idx);
        return newItem(name);
    }

    @Override
    public String toString() {
        return "Menu placeholder";
    }
}
