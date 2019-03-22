package a2;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.Map;
import java.util.Scanner;

public class PizzaParlour {
    private static final String seperateLine = "=======================================================";
    private Controller controller;

    PizzaParlour() {
        this.controller = new Controller();
    }

    void success(String str) {
        System.out.println(seperateLine);
        System.out.println("Success in " + str + "!");
        System.out.println(seperateLine);
    }

    private void createOrder(Scanner scanner) {
        OrderBuilder ob = new OrderBuilder();

        boolean done = false;

        while (!done) {
            System.out.println("Add an item to the order (Enter 0 to stop):");
            System.out.println("1 - Add a pizza");
            System.out.println("2 - Add a drink");

            int selectedOption = Integer.valueOf(scanner.nextLine());
            switch (selectedOption) {
                case 0:
                    done = true;
                    break;
                case 1:
                    try {
                        Item newPizza = createPizza(scanner);
                        ob.addItem(newPizza);
                    } catch (InvalidPizzaException e) {
                        System.out.println("Sorry, this is an invalid pizza!");
                    }
                    break;
                case 2:
                    try {
                        Item newDrink = createItem(scanner, controller.menuMap.get("Drink"));
                        ob.addItem(newDrink);
                    } catch (NoSuchItemException e) {
                        System.out.println("Sorry, this is an invalid drink!");
                    }
                    break;
                default:
                    System.out.println("Invalid input option.");
            }
        }

        try {
            Order order = ob.build();
            controller.addOrder(order);
            success("creating order");
        } catch (EmptyOrderException e) {
            System.out.println("Sorry, empty order.");
        }

    }

    private Item createPizza(Scanner scanner) throws InvalidPizzaException {
        try {
            System.out.println(seperateLine);
            PizzaBuilder pb = new PizzaBuilder();

            pb.addSize(createItem(scanner, controller.menuMap.get("Size")));
            pb.addType((PizzaType) createItem(scanner, controller.menuMap.get("Type")));

            boolean done = false;
            while (!done) {
                System.out.println("Add a topping (Enter 0 to stop):");
                System.out.println(controller.menuMap.get("Toppings").toString());
                int toppingID = Integer.valueOf(scanner.nextLine());

                if (toppingID == 0) {
                    done = true;
                } else {
                    pb.addTopping(controller.menuMap.get("Toppings").newItemByIndex(toppingID));
                }
            }

            return pb.build();
        } catch (NoSuchItemException e) {
            throw new InvalidPizzaException("Invalid Pizza");
        }

    }

    private Item createItem(Scanner scanner, Menu menu) throws NoSuchItemException {
        System.out.println(seperateLine);
        System.out.println("Select the item you like:");
        System.out.println(menu);
        int drinkId = Integer.valueOf(scanner.nextLine());
        success("adding item");
        return menu.newItemByIndex(drinkId);
    }

    private boolean listOrder() {
        if (controller.getOrders().size() == 0) {
            System.out.println("No orders!");
        }

        for (Order order: controller.getOrders()) {
            System.out.println(order);
        }

        return !(controller.getOrders().size() == 0);
    }

    private void cancelOrder(Scanner scanner) {
        if (listOrder()) {
            int idx = Integer.valueOf(scanner.nextLine());
            controller.cancelOrderByIndex(idx);

            System.out.println(seperateLine);
            System.out.println("Cancelled");
            System.out.println(seperateLine);
        }
    }

    private void queryMenu(Scanner scanner) {
        System.out.println("Enter an item name, or press enter for full menu:");

        String res = scanner.nextLine();

        if (res.equals("")) {
            System.out.println("Enter");
            for (Map.Entry<String, Menu> entry : controller.menuMap.entrySet()) {
                System.out.println("--- " + entry.getKey() + " Menu: ---");
                System.out.println(entry.getValue());
            }
        } else {
            for (Map.Entry<String, Menu> entry : controller.menuMap.entrySet()) {
                try {
                    double price = entry.getValue().getPrice(res);
                    System.out.println(price);
                    return;
                } catch (NoSuchItemException e) {}
            }
            System.out.println("Sorry, item not found in menu.");
        }
    }

    private void printOptions() {
        System.out.println(seperateLine);
        System.out.println("Please type a number:");

        System.out.println("1 - Submit a new order");
        System.out.println("2 - Update an existing order");
        System.out.println("3 - Cancel an existing order");
        System.out.println("4 - Pick up or delivery an existing order");
        System.out.println("5 - Display menu");
        System.out.println("6 - Exit");
    }

    private void pickUpOrDelivery(Scanner scanner) {
        if (listOrder()) {
            int idx = Integer.valueOf(scanner.nextLine());
            Order order = controller.getOrderByIndex(idx);

            System.out.println("--- Select a method: ---");
            System.out.println("1. Pickup from store");
            System.out.println("2. Pizza Parlour’s in-house delivery person");
            System.out.println("3. Uber Eats");
            System.out.println("4. Foodora");

            int idx1 = Integer.valueOf(scanner.nextLine());
            String address;
            switch (idx1) {
                case 1:
                    controller.cancelOrderByIndex(idx);
                    break;
                case 2:
                    getAddress(scanner);
                    controller.cancelOrderByIndex(idx);
                    break;
                case 3:
                    address = getAddress(scanner);
                    Delivery uberEats = new UberEats(address, order);
                    uberEats.saveToFile();
                    controller.cancelOrderByIndex(idx);
                    break;
                case 4:
                    address = getAddress(scanner);
                    Delivery foodora = new Foodora(address, order);
                    foodora.saveToFile();
                    controller.cancelOrderByIndex(idx);
                    break;
                default:
                    System.out.println("Invalid input");

            }
        }
    }

    private String getAddress(Scanner scanner) {
        System.out.println("Enter your address: ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to 301 Pizza!: ");

        PizzaParlour pp = new PizzaParlour();
        Scanner scanner = new Scanner(System.in);

        int currState = 0;
        String inputControl = "";
        while (!inputControl.equals("Exit") && !inputControl.equals("6")) {
            switch (currState) {
                case 0:
                    pp.printOptions();
                    break;
                case 1:
                    pp.createOrder(scanner);
                    currState = 0;
                    continue;
                case 3:
                    pp.cancelOrder(scanner);
                    currState = 0;
                    continue;
                case 4:
                    pp.pickUpOrDelivery(scanner);
                    currState = 0;
                    continue;
                case 5:
                    pp.queryMenu(scanner);
                    currState = 0;
                    continue;
                default:
                    currState = 0;
                    continue;
            }

            inputControl = scanner.nextLine();
            try {
                currState = Integer.valueOf(inputControl);
            } catch (Exception e) {
                currState = 0;
            }
        }

        scanner.close();
    }

}