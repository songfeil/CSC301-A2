package a2;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuParser {
    private String filePath;

    public MenuParser(String filePath) {
        this.filePath = filePath;
    }

    public Menu readMenu() {
        ArrayList<Item> items = new ArrayList<Item>();

        // TODO
        items.add(new Pepperoni(1.0));
        items.add(new Neapolitan(2.0));
        items.add(new Margherita(3.0));
        items.add(new Vegetarian(4.0));

        return new Menu(items);
    }
}
