package org.example;

/**
 * Author: Lucious Morrison
 * Date: 11/11/20
 * Assignment: Unit 10 Case Problems - Carly EventDemo
 */

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * EventDemo is used to create Event objects based on user input and display the information
 * about the created events.
 */
public class EventDemo {
    private static final int NUM_EVENTS = 8; // Number of Event objects that will be stored in array
    private static Event[] eventArr = new Event[NUM_EVENTS]; // Array to store Event objects

    public static void main(String[] args) {
        askUserForObjects();
    }

    /**
     * Asks the user for the event number.
     *
     * @return The event number provided by the user.
     */
    public static String askUserForEventNumber() {
        String num;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter event number >> ");
        num = input.nextLine();
        return num;
    }

    /**
     * Asks the user for the number of guests until a valid response * is given.
     *
     * @return The number of guests provided by the user.
     */
    public static int askUserForGuests() {
        int guests = 0;
        final int MIN_GUESTS = 5;
        final int MAX_GUESTS = 100;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of guests >> ");
        try {
            guests = Integer.parseInt(input.nextLine());
            while (guests < MIN_GUESTS || guests > MAX_GUESTS) {
                System.out.println("The number of guests must be between " +
                    MIN_GUESTS + " and " + MAX_GUESTS);
                System.out.print("Please renter >> ");
                guests = Integer.parseInt(input.nextLine());
            }
        }
        catch(Exception e) {
            System.out.println("You've entered a non-numerical value for the number of guests, please try again");
            askUserForGuests();
        }
        return guests;
    }

    /**
     * Asks the user for the event type, numerical value.
     *
     * @return The event type numerical value.
     */
    public static int askUserForEventType() {
        int num = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter event type by number >> ");
        try {
            num = Integer.parseInt(input.nextLine());
        }
        catch(Exception e) {
           System.out.println("You've selected a non-numerical value for the event type, please try again");
           askUserForEventType();
        }
        return num;
    }

    /**
     * Prints out the information about the given Event
     *
     * @param event - The Event to display the details of
     */
    public static void displayDetails(Event event) {
        System.out.println("Event #" + event.getEventNumber());
        System.out.println("The price for an event with " + event.getGuests() +
                " guests at $" + event.getPricePerGuest() + " per guest is $" + event.getPriceForEvent());
        System.out.println("The type of this event is: " + event.getEventName());

    }

    /**
     * Asks the user if they want to create their own events or use * prebuilt events(for testing purposes)..
     */
    public static void askUserForObjects() {
        int num;
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to use prebuilt events(easy grading :) ) or create your own?\n1). Use Prebuilt events\n2). Create Own Objects\n3). Exit");
        try {
            num = input.nextInt();
            if (num == 1) {
                usePrebuiltObjects();
            } else if (num == 2) {
                createOwnObjects();
            } else if (num == 3) {
                System.exit(0);
            } else {
                System.out.println("Invalid selection");
                askUserForObjects();
            }
        }
        catch(Exception e) {
            System.out.println("You've selected a non-numerical value, please try again");
            askUserForObjects();
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
        int minEventType = 0;
        int maxEventType = 4;
        for(int i = 0; i < NUM_EVENTS; i++) {
            eventArr[i] = new Event("A" +
                    getRandomValue(minEventNumber, maxEventNumber),
                    getRandomValue(minGuests, maxGuests),
                    getRandomValue(minEventType,maxEventType));
        }
    }

    /**
     * Prompts the user to create event objects to be stored in
     * array.
     */
    public static void createOwnObjects() {
        for(int i = 0; i < NUM_EVENTS; i++) {
            System.out.println("Event #" + (i + 1));
            eventArr[i] = new Event(
                    askUserForEventNumber(),
                    askUserForGuests(),
                    askUserForEventType());
            System.out.println();
        }
    }

    /**
     * Display all objects within array
     */
    public static void displayAll() {
        for (Event obj : eventArr) {
            displayDetails(obj);
        }
    }

    /**
     * Random number generator for prebuilt objects
     *
     * @param min - minimum number in range
     * @param max - maximum number in range
     *
     * @return random number in definted range
     */
    public static int getRandomValue(int min, int max) {
        return ThreadLocalRandom
                .current()
                .nextInt(min, max + 1);
    }

    /**
     * Random number generator for objects
     *
     * @param min - minimum number in range
     * @param max - maximum number in range
     *
     * @return random number in defined range
     */
    public static double getRandomDouble(double min, double max) {
        return ThreadLocalRandom
            .current()
            .nextDouble(min, max + 1);
    }
}

