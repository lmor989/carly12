package org.example;

import java.util.Random;
import java.util.Scanner;

/**
 * WeddingEventDemo is used to create WeddingEvent objects based on user input and display the information
 * about the created events.
 */
public class WeddingEventDemo extends EventDemo {
    private static final int NUM_EVENTS = 3; // Number of WeddingEvent objects that will be stored in array
    private static WeddingEvent[] WeddingEventArr = new WeddingEvent[NUM_EVENTS]; // Array to store WeddingEvent objects
    protected static Random rand;
    protected static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        askUserForObjects();
        displayAll();
    }

    /**
     * Asks user to choose between random objects or create their own
     */
    public static void askUserForObjects() {
        int num;
        System.out.println("Would you like to use randomly generated events or create your own?\n1)" +
            ". Use random events\n2). Create Own Objects\n3). Exit");
        num = input.nextInt();
        if (num == 1) {
            usePrebuiltObjects();
        } else if (num == 2) {
            createOwnObjects();
        } else if (num == 3) {
            System.exit(0);
        } else {
            System.out.println("Invalid selection");
            askUserForEventNumber();
        }
    }

    /**
     * Generates random objects and stores them in array
     */
    public static void usePrebuiltObjects() {
        int minEventNumber = 100;
        int maxEventNumber = 999;
        int minGuests = 5;
        int maxGuests = 100;
        int minFoodSelection = 0;
        int maxFoodSelection = 5;
        int eventType = 4;
        rand = new Random();
        for(int i = 0; i < NUM_EVENTS; i++) {
            boolean value = rand.nextBoolean();
            WeddingEventArr[i] = new WeddingEvent("A" +
                getRandomValue(minEventNumber, maxEventNumber),
                getRandomValue(minGuests, maxGuests),
                getRandomValue(minFoodSelection, maxFoodSelection),
                getRandomValue(minFoodSelection, maxFoodSelection),
                getRandomValue(minFoodSelection, maxFoodSelection),
                getRandomValue(minFoodSelection, maxFoodSelection));
        }
    }

    /**
     * Prompts the user to create WeddingEvent objects to be stored in
     * array.
     */
    public static void createOwnObjects() {
        for(int i = 0; i < NUM_EVENTS; i++) {
            System.out.println("Event #" + (i + 1));
            WeddingEventArr[i] = new WeddingEvent(
                askUserForEventNumber(),
                askUserForGuests(),
                askUserForAppetizer(),
                askUserForEntree1(),
                askUserForEntree2(),
                askUserForDessert());
            System.out.println();
        }
    }

    /**
     * Display all objects within array
     */
    public static void displayAll() {
        for (WeddingEvent obj : WeddingEventArr) {
            displayDetails(obj);
            System.out.println(obj.getMenu());
        }
    }

    /**
     * Displays Appetizers
     */
    public static void displayAppetizers() {
        System.out.println("Appetizers Menu: ");
        for (int i = 0; i < WeddingEvent.getAppetizerChoices().length; i++) {
            System.out.println(i + 1 + ") " + WeddingEvent.getAppetizerChoices()[i]);
        }
    }

    /**
     * Displays Entrees
     */
    public static void displayEntrees() {
        System.out.println("Entrees Menu: ");
        for (int i = 0; i < WeddingEvent.getEntreeChoices().length; i++) {
            System.out.println(i + 1 + ") " + WeddingEvent.getEntreeChoices()[i]);
        }
    }

    /**
     * Displays Desserts
     */
    public static void displayDesserts() {
        System.out.println("Desserts Menu: ");
        for (int i = 0; i < WeddingEvent.getDessertChoices().length; i++) {
            System.out.println(i + 1 + ") " + WeddingEvent.getDessertChoices()[i]);
        }
    }

    /**
     * Displays Buffet Options
     */
    public static void displayBuffetOptions() {
        System.out.println("Buffet?:\n1) Yes\n2) No");
    }

    /**
     * Runs displayAppetizers method, then accepts input from the user
     *
     * @return numerical value of the food being chosen
     */
    public static int askUserForAppetizer() {
        int num = 0;
        displayAppetizers();
        try {
            num = Integer.parseInt(input.nextLine());
        }
        catch(Exception e) {
            System.out.println("You've entered a non-numerical value for your appetizer choice, please try again");
            num = askUserForAppetizer();
        }
        return num;
    }

    /**
     * Displays the entrees, then accepts input from the user
     *
     * @return numerical value of the first entree being chosen
     */
    public static int askUserForEntree1() {
        int num = 0;
        System.out.println("First entree");
        displayEntrees();
        try {
            num = Integer.parseInt(input.nextLine());
        }
        catch(Exception e) {
            System.out.println("You've entered a non-numerical value for your first entree, please try again");
            num = askUserForEntree1();
        }
        return num;
    }

    /**
     * Displays the entrees, then accepts input from the user
     *
     * @return numerical value of the second entree being chosen
     */
    public static int askUserForEntree2() {
        int num = 0;
        System.out.println("Second entree");
        displayEntrees();
        try {
            num = Integer.parseInt(input.nextLine());
        }
        catch(Exception e) {
            System.out.println("You've entered a non-numerical value for your second entree, please try again");
            num = askUserForEntree2();
        }
        return num;
    }

    /**
     * Displays the desserts, then accepts input from the user
     *
     * @return numerical value of the dessert being chosen
     */
    public static int askUserForDessert() {
        int num = 0;
        System.out.println("Dessert");
        displayDesserts();
        try {
            num = Integer.parseInt(input.nextLine());
        }
        catch(Exception e) {
            System.out.println("You've entered a non-numerical value for your dessert, please try again");
            num = askUserForDessert();
        }
        return num;
    }

    /**
     * Displays the buffet options, then accepts input from the user
     *
     * @return boolean to represent if the meal is buffet style or not
     */
    public static boolean askUserForBuffetType() {
        displayBuffetOptions();
        int option = input.nextInt();
        if (option == 1) {
            return true;
        } else {
            return false;
        }
    }

}
