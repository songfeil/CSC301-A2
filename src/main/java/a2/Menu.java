package a2;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    private ArrayList<Item> items;

    public Menu() {
    }

    public Menu(ArrayList<Item> items) {
        this.items = items;
    }

    private Item getItemByName(String name) throws NoSuchItemException {
        for (Item item: items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }

        throw new NoSuchItemException();
    }

    public double getPrice(String itemName) {
        try {
            return getItemByName(itemName).getPrice();
        } catch (NoSuchItemException e) {
            return 0.0;
        }
    }

    public void getFullMenu() {
        System.out.println("Full menu placeholder.");
    }

    public Item newItem(String name) throws NoSuchItemException {
        try {
            Item item = getItemByName(name);
            return (Item) item.clone();
        } catch (CloneNotSupportedException e) {
            throw new NoSuchItemException();
        }
    }

    public Item newItemByIndex(int idx) throws NoSuchItemException {
        try {
            return (Item) items.get(idx).clone();
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchItemException();
        } catch (CloneNotSupportedException e) {
            throw new NoSuchItemException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append(Integer.toString(i + 1));
            sb.append(". ");
            sb.append(items.get(i).getName());
            sb.append("    ");
            sb.append(items.get(i).getPrice());
            sb.append("\n");
        }
        return sb.toString();
    }

}
