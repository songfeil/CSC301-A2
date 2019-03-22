package a2;

import jdk.nashorn.internal.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuDAO {
    private Map<String, Menu> menuMap;

    MenuDAO() {}

    MenuDAO(String filename) {
        menuMap = new HashMap<String, Menu>();
        readFromJSON(filename);
    }

    private void readFromJSON(String filename) {

    }

    public Map<String, Menu> getMenuMap() {
        return getSampleMap();
    }

    private Map<String, Menu> getSampleMap() {
        HashMap<String, Menu> sampleMap = new HashMap<String, Menu>();
        Menu drinks = new Menu();
        drinks.addItem(new Item("Coke", 1.0));
        drinks.addItem(new Item("Diet Coke", 2.0));
        Menu sizes = new Menu();
        sizes.addItem(new Item("Large", 1.25));
        sizes.addItem(new Item("Medium", 3.45));
        Menu toppings = new Menu();
        toppings.addItem(new Item("Toppings 1", 1.0));
        toppings.addItem(new Item("toppings 2", 2.5));
        Menu types = new Menu();
        PizzaTypeFactory ptf = new PizzaTypeFactory();
        try {
            types.addItem(ptf.generateType("Pepperoni", 4.0));
            types.addItem(ptf.generateType("Margherita", 8.0));
        } catch (Exception ignored) {}

        sampleMap.put("Drink", drinks);
        sampleMap.put("Size", sizes);
        sampleMap.put("Toppings", toppings);
        sampleMap.put("Type", types);


        return sampleMap;
    }

    public static void main(String[] args) {
        MenuDAO menuDAO = new MenuDAO("menu.json");
        System.out.println(menuDAO.getMenuMap());
    }
}
