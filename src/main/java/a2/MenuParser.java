package a2;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuParser {
    private String filePath;

    public MenuParser(String filePath) {
        this.filePath = filePath;
    }

    public Menu readMenu() {
        ArrayList<String> items = new ArrayList<String>();
        HashMap<String, Double> itemPrice = new HashMap<String, Double>();
        HashMap<String, ItemType> itemType = new HashMap<String, ItemType>();
        HashMap<String, String> pizzaTypeMethods = new HashMap<String, String>();

        // TODO
        itemPrice.put("Coke", 1.0);
        itemPrice.put("Diet Coke", 2.5);

        return new Menu(items, itemPrice, itemType, pizzaTypeMethods);
    }
}
