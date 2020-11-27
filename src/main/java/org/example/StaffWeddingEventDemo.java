/**
 * Author: Lucious Morrison
 * Date: 11/19/20
 * Assignment: Unit 11 Case Problems - Carly StaffWeddingEventDemo
 */

package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * StaffWeddingEventDemo is used to create WeddingEvent objects based on user input * and display the information
 * about the created WeddingEvent objects.
 */
public class StaffWeddingEventDemo extends WeddingEventDemo {
    private static final int NUM_EVENTS = 1; // Number of WeddingEvent objects that will be stored in array
    private static final int STARTING_SERVERS_BUFFET = 3; // Number of servings to start with on buffet events
    private static final int STARTING_SERVERS_NON_BUFFET = 1; // Number of servings to start on non buffet events
    private static final int EXTRA_SERVERS_BUFFET = 30; // Represents number of guests required for additional server
    // for buffet events
    private static final int EXTRA_SERVERS_NON_BUFFET = 12; // Represents number of guest required for additional server
    // for non buffet events
    private static final int STARTING_BARTENDERS = 1; // Number of bartenders to start with regardless of guests
    private static final int EXTRA_BARTENDERS = 20; // Represents the number of guests required to add an additional
    // bartender
    private static final String[] FIRST_NAMES = {"Paul", "Kawhi", "Ben", "Jimmy", "Donovan", "LeBron", "Anthony",
        "Luka", "Kevin", "Nikola", "Brandon", "Zion", "James", "Chris", "Stephen"};
    private static final String[] LAST_NAMES = {"George", "Leonard", "Simmons", "Butler", "Mitchell", "James",
        "Davis", "Doncic", "Durant", "Jokic", "Ingram", "Williamson", "Harden", "Paul" ,"Curry"};
    private static int startingServers; // Actual number of servers once buffet/nonbuffet is determined
    private static int extraServers; // Actual number of extra servers added
    private static int extraBartenders; // Actual number of extra bartenders added
    private static WeddingEvent aWeddingEvent; // Storing wedding event
    private static List<Employee> localList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        askUserForObjects();
        askUserForEmployees();
        aWeddingEvent.getEmployeeList().addAll(localList);
        displayDetails();
    }

    /**
     * Asks user to choose between random objects or create their own
     */
    public static void askUserForObjects() {
        int num;
        try {
            System.out.println("Would you like to use a randomly generated event or create your own?\n1)" +
                ". Use random event\n2). Create object\n3). Exit");
            num = Integer.parseInt(input.nextLine());
            if (num == 1) {
                usePrebuiltObject();
            } else if (num == 2) {
                createOwnObject();
            } else if (num == 3) {
                System.exit(0);
            } else {
                System.out.println("Invalid number selected");
                askUserForObjects();
            }
        }
        catch (Exception e) {
            System.out.println("You've entered a non-numerical value, please try again");
            askUserForObjects();
        }
    }

    /**
     * Generates random objects and stores them in array
     */
    public static void usePrebuiltObject() {
        int minEventNumber = 100;
        int maxEventNumber = 999;
        int minGuests = 5;
        int maxGuests = 100;
        int minFoodSelection = 0;
        int maxFoodSelection = 5;
            aWeddingEvent = new WeddingEvent("A" +
                getRandomValue(minEventNumber, maxEventNumber),
                getRandomValue(minGuests, maxGuests),
                getRandomValue(minFoodSelection, maxFoodSelection),
                getRandomValue(minFoodSelection, maxFoodSelection),
                getRandomValue(minFoodSelection, maxFoodSelection),
                getRandomValue(minFoodSelection, maxFoodSelection));
    }

    /**
     * Prompts the user to create WeddingEvent object to be stored in
     */
    public static WeddingEvent createOwnObject() {
            aWeddingEvent = new WeddingEvent(
                askUserForEventNumber(),
                askUserForGuests(),
                askUserForAppetizer(),
                askUserForEntree1(),
                askUserForEntree2(),
                askUserForDessert());
            return aWeddingEvent;
    }

    /**
     * Asks user to choose between random employees or create their own
     */
    public static void askUserForEmployees() {
        int num;
        try {
            System.out.println("Would you like to use randomly generated employees or create your own?\n1)" +
                ". Use random employees\n2). Create employees\n3). Exit");
            num = Integer.parseInt(input.nextLine());
            if (num == 1) {
                useRandomEmployees();
            } else if (num == 2) {
                createEmployees();
            } else if (num == 3) {
                System.exit(0);
            } else {
                System.out.println("Invalid number selected");
                askUserForEmployees();
            }
        }
        catch(Exception e) {
            System.out.println("You've entered a non-numerical value, please try again");
            askUserForEmployees();
        }
    }

    /**
     * Generates random employees and stores them in array list
     */
    public static void useRandomEmployees() {
        int minIDNumber = 100;
        int maxIDNumber = 999;
        int minName = 0;
        int maxName = 14;
        double minPayRate = 7.25;
        double maxPayRate = 30.00;
        determineServers();
        // Servers creation loop
        for(int i = 0; i < startingServers + extraServers ; i++) {
            localList.add(new Server("a" +
                getRandomValue(minIDNumber, maxIDNumber),
                LAST_NAMES[getRandomValue(minName, maxName)],
                FIRST_NAMES[getRandomValue(minName, maxName)],
                getRandomDouble(minPayRate, maxPayRate)));
        }
        // Bartenders creation loop
        for(int i = 0; i < STARTING_BARTENDERS + extraBartenders ; i++) {
            localList.add(new Bartender("a" +
                getRandomValue(minIDNumber, maxIDNumber),
                LAST_NAMES[getRandomValue(minName, maxName)],
                FIRST_NAMES[getRandomValue(minName, maxName)],
                getRandomDouble(minPayRate, maxPayRate)));
        }
        // Manager creation
            localList.add(new Manager("a" +
                getRandomValue(minIDNumber, maxIDNumber),
                LAST_NAMES[getRandomValue(minName, maxName)],
                FIRST_NAMES[getRandomValue(minName, maxName)],
                getRandomDouble(minPayRate, maxPayRate)));
    }

    private static void determineServers() {
        if (aWeddingEvent.isBuffetStyle()) {
            startingServers = STARTING_SERVERS_BUFFET;
            extraServers = (aWeddingEvent.getGuests() - 1) / EXTRA_SERVERS_BUFFET;
        } else {
            startingServers = STARTING_SERVERS_NON_BUFFET;
            extraServers = (aWeddingEvent.getGuests() - 1) / EXTRA_SERVERS_NON_BUFFET;
        }
        extraBartenders = (aWeddingEvent.getGuests() - 1) / EXTRA_BARTENDERS;
    }

    /**
     * Takes input to create employees
     */
    public static void createEmployees() {
        determineServers();
        // Servers creation loop
        for(int i = 0; i < startingServers + extraServers ; i++) {
            localList.add(new Server(
                askUserForIDNum(),
                askUserForLastName(),
                askUserForFirstName(),
                askUserForPayRate()));
            System.out.println("Server Created!");
        }
        // Bartenders creation loop
        for(int i = 0; i < STARTING_BARTENDERS + extraBartenders ; i++) {
            localList.add(new Bartender(
                askUserForIDNum(),
                askUserForLastName(),
                askUserForFirstName(),
                askUserForPayRate()));
            System.out.println("Bartender Created!");
        }
        // Manager creation
        localList.add(new Manager(
            askUserForIDNum(),
            askUserForLastName(),
            askUserForFirstName(),
            askUserForPayRate()));
        System.out.println("Manager Created!");
    }

    /**
     * Prints out the information about the employees at the wedding event
     *
     */
    public static void displayEmployeeCount() {
        System.out.println("Number of guests: " + aWeddingEvent.getGuests());
        System.out.println("Is a buffet? : " + aWeddingEvent.isBuffetStyle());
        System.out.println("Number of Servers: " + (startingServers + extraServers));
        System.out.println("Number of Bartenders: " + (STARTING_BARTENDERS + extraBartenders));
        System.out.println("Number of Managers: Always 1");
    }

    /**
     * Prints out the information about the employees at the wedding event
     *
     */
    public static void displayEmployees() {
        System.out.println("The staff for this event are:");
        for (Employee obj : aWeddingEvent.getEmployeeList()) {
            System.out.println("Identification Number: " + obj.getIdNumber());
            System.out.println("Name: " + obj.getFirstName() + " " + obj.getLastName());
            System.out.println("Pay Rate: $" + Math.round(obj.getPayRate() * 100.0) /100.0);
            System.out.println("Job Title: " + obj.getJobTitle());
            System.out.println();
        }
    }

    /**
     * Prints out the information about the given Wedding Event
     */
    public static void displayDetails() {
        System.out.println("Event #" + aWeddingEvent.getEventNumber());
        System.out.println("The price for an event with " + aWeddingEvent.getGuests() +
            " guests at $" + aWeddingEvent.getPricePerGuest() + " per guest is $" + aWeddingEvent.getPriceForEvent());
        System.out.println("The type of this event is: " + aWeddingEvent.getEventName());
        System.out.println(aWeddingEvent.getMenu());
        displayEmployees();
        displayEmployeeCount();
    }

    /**
     * Asks the user to choose identification number
     *
     * @return string value of input
     */
    public static String askUserForIDNum() {
        System.out.print("Enter Identification Number: ");
        return input.nextLine();
    }

    /**
     * Asks the user to choose first name
     *
     * @return string value of input
     */
    public static String askUserForFirstName() {
        System.out.print("Enter First Name: ");
        return input.nextLine();
    }

    /**
     * Asks the user to choose last name
     *
     * @return string value of input
     */
    public static String askUserForLastName() {
        System.out.print("Enter Last Name: ");
        return input.nextLine();
    }

    /**
     * Asks the user to choose pay rate
     *
     * @return double value of input
     */
    public static Double askUserForPayRate() {
        double payRate = 0.00;
        System.out.print("Enter Pay Rate: ");
        try {
            payRate = Double.parseDouble(input.nextLine());
        }
        catch(Exception e) {
            System.out.println("You've entered a non-numerical value, please try again");
            payRate = askUserForPayRate();
        }
        return payRate;
    }
}