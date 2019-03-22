package a2;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MenuDAO {
    private Map<String, Menu> menuMap;

    MenuDAO(String filename) {
        menuMap = new HashMap<String, Menu>();
        readFromJSON(filename);
    }

    private void readFromJSON(String filename) {
        //JSON parser object to parse read file
        JSONParser parser = new JSONParser();

        try
        {
            Object obj = parser.parse(new FileReader(filename));
            JSONObject jsonObject = (JSONObject) obj;
            Menu drinks = getMenu(jsonObject, "Drink");
            Menu types = getMenu(jsonObject, "Type");
            Menu toppings = getMenu(jsonObject, "Toppings");
            Menu sizes = getMenu(jsonObject, "Size");
            menuMap.put("Drink", drinks);
            menuMap.put("Size", sizes);
            menuMap.put("Toppings", toppings);
            menuMap.put("Type", types);

        } catch (FileNotFoundException e) {
            System.out.println("Not found menu.json, exit now.");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private Menu getMenu(JSONObject jsonobj,String category) {
        // loop array
        JSONArray type = (JSONArray) jsonobj.get(category);
        Iterator<JSONObject> iterator = type.iterator();
        Menu menu = new Menu();
        while (iterator.hasNext()) {
            JSONObject obj = iterator.next();
            String name = obj.keySet().iterator().next().toString();
            Double price = Double.valueOf(obj.get(name).toString());
            menu.addItem(new Item(name, price));
        }
        return menu;
    }

    public Map<String, Menu> getMenuMap() {
        return menuMap;
    }

    public static void main(String[] args) {
        MenuDAO menuDAO = new MenuDAO("menu.json");
        System.out.println(menuDAO.getMenuMap());
    }
}
