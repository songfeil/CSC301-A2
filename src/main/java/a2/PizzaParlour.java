package a2;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.Scanner;

public class PizzaParlour {
    private static final String seperateLine = "=======================================================";
    private Controller controller;

    PizzaParlour() {
        this.controller = new Controller();
    }

    public void createOrder(Scanner scanner) {
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
                        Pizza newPizza = createPizza(scanner);
                        ob.addPizza(newPizza);
                    } catch (InvalidPizzaException e) {
                        System.out.println("Sorry, this is an invalid pizza!");
                    }
                    break;
                case 2:
                    try {
                        Drink newDrink = createDrink(scanner);
                        ob.addDrink(newDrink);
                    } catch (NoSuchItemException e) {
                        System.out.println("Sorry, this is an invalid drink!");
                    }
                    break;
                default:
                    System.out.println("Invalid input option.");
            }
        }

        try {
            controller.addOrder(ob.build());
        } catch (EmptyOrderException e) {
            System.out.println("Sorry, empty order.");
        }

    }

    public Pizza createPizza(Scanner scanner) throws InvalidPizzaException {
        try {
            PizzaBuilder pb = new PizzaBuilder();

            System.out.println("Select a size:");
            System.out.println(controller.sizeMenu.toString());
            int sizeID = Integer.valueOf(scanner.nextLine());
            pb.addSize((PizzaSize) controller.sizeMenu.newItemByIndex(sizeID));

            System.out.println("Select a type:");
            System.out.println(controller.typeMenu.toString());
            int typeID = Integer.valueOf(scanner.nextLine());
            pb.addType((PizzaType) controller.sizeMenu.newItemByIndex(typeID));

            boolean done = false;
            while (!done) {
                System.out.println("Add a topping (Enter 0 to stop):");
                System.out.println(controller.toppingsMenu.toString());
                int toppingID = Integer.valueOf(scanner.nextLine());

                if (toppingID == 0) {
                    done = true;
                } else {
                    pb.addTopping((PizzaTopping) controller.sizeMenu.newItemByIndex(toppingID));
                }
            }

            return pb.build();
        } catch (NoSuchItemException e) {
            throw new InvalidPizzaException("Invalid Pizza");
        }

    }

    public Drink createDrink(Scanner scanner) throws NoSuchItemException {
        System.out.println("Select the drink you like:");
        System.out.println(controller.drinkMenu.toString());

        int drinkId = Integer.valueOf(scanner.nextLine());

        return (Drink) controller.drinkMenu.newItemByIndex(drinkId);
    }

    public void printOptions() {
        System.out.println("Please type a number:");

        System.out.println("1 - Submit a new order");
        System.out.println("2 - Update an existing order");
        System.out.println("3 - Cancel an existing order");
        System.out.println("4 - Ask for pick up or delivery");
        System.out.println("5 - Display menu");
        System.out.println("6 - Exit");
    }

    public static void main(String[] args) {

        System.out.println("Welcome to 301 Pizza!: ");
        System.out.println(seperateLine);

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
                    break;
            }

            inputControl = scanner.nextLine();
            currState = Integer.valueOf(inputControl);
        }

        scanner.close();
    }

}