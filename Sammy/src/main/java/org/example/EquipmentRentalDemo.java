/**
 * Author: Lucious Morrison
 * Date: 11/19/20
 * Assignment: Unit 11 Case Problems - Sammy EquipmentRentalDemo
 */

package org.example;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Creates Rental objects and shows details about them
 */
public class EquipmentRentalDemo extends RentalDemo {
    private static final int NUM_EVENTS = 3; // Number of Rental objects that will be stored in array
    private static Rental[] rentalArr = new Rental[NUM_EVENTS]; // Array to store Rental objects

    public static void main(String[] args) {
        askUserForObjects();
        displayAll();
    }

    /**
     * Asks the user for the contract number
     *
     * @return The contract number provided by the user
     */
    public static String askUserForContractNumber() {
        String num;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter contract number >> ");
        num = input.nextLine();
        return num;
    }

    /**
     * Asks the user for the number of minutes for the rental until * a valid amount is provided.
     *
     * @return The number of minutes for the rental provided by the user
     */
    public static int askUserForMinutes() {
        int minutes;
        final int LOW_MIN = 60;
        final int HIGH_MIN = 7200;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter minutes >> ");
        minutes = input.nextInt();
        while (minutes < LOW_MIN || minutes > HIGH_MIN) {
            System.out.println("Time must be between " + LOW_MIN +
                " minutes and " + HIGH_MIN + " minutes");
            System.out.print("Please reenter minutes >> ");
            minutes = input.nextInt();
        }
        return minutes;
    }

    /**
     * Asks the user for the equipment type numerical value
     *
     * @return the numerical value of chosen equipment
     */
    public static int askUserForEquipmentType() {
        int num;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter equipment type by number >> ");
        num = input.nextInt();
        return num;
    }

    /**
     * Displays the details of the given Rental object.
     *
     * @param rental - The rental object for which you will display * details
     */
    public static void displayDetails(Rental rental) {
        System.out.println("Contract #" + rental.getContractNumber());
        System.out.println("For a rental of " + rental.getHours() +
            " hours and " + rental.getExtraMinutes() +
            " minutes,\n    at a rate of $" + rental.HOUR_RATE +
            " per hour and $1 per minute, with the equipment surcharge\n    the price is $" +
                rental.getPrice());
        System.out.println("This type of rental is: " + rental.getItemRented().getEquipmentName());
        System.out.println(rental.getItemRented().lessonPolicyMethod());

    }

    /**
     * Asks the user if they want to create their own rentals or
     * use randomly generated rentals(for testing purposes)..
     */
    public static void askUserForObjects() {
        int num;
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to use prebuilt rentals(easy grading :) ) or create your own?\n1). Use Prebuilt rentals\n2). Create Own Objects\n3). Exit");

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

    /**
     * Generates random objects and stores them in array
     */
    public static void usePrebuiltObjects() {
        int minContractNumber = 100;
        int maxContractNumber = 999;
        int minMinutes = 60;
        int maxMinutes = 7200;
        int minEquipmentType = 0;
        int maxEquipmentType = 8;
        for(int i = 0; i < NUM_EVENTS; i++) {
            rentalArr[i] = new Rental("A" +
                getRandomValue(minContractNumber, maxContractNumber),
                getRandomValue(minMinutes, maxMinutes),
                getRandomValue(minEquipmentType,maxEquipmentType));
        }
    }

    /**
     * Prompts the user to create rental objects to be stored in
     * array.
     */
    public static void createOwnObjects() {
        for(int i = 0; i < NUM_EVENTS; i++) {
            System.out.println("Rental #" + (i + 1));
            rentalArr[i] = new Rental(
                askUserForContractNumber(),
                askUserForMinutes(),
                askUserForEquipmentType());
            System.out.println();
        }
    }

    /**
     * Sorts array by rental number
     */
    public static void sortByContractNumber() {
        for (int i = 0; i < rentalArr.length; i++) {
            for (int j = i + 1; j < rentalArr.length; j++) {
                if (rentalArr[i].getContractNumber().compareTo(rentalArr[j].getContractNumber()) > 0) {
                    Rental temp = rentalArr[i];
                    rentalArr[i] = rentalArr[j];
                    rentalArr[j] = temp;
                }
            }
        }
        displayAll();
    }

    /**
     * Sort array by number of minutes
     */
    public static void sortByNumMinutes() {
        for (int i = 0; i < rentalArr.length; i++) {
            for (int j = i + 1; j < rentalArr.length; j++) {
                int totalMinutesA = rentalArr[i].getHours() * 60 + rentalArr[i].getExtraMinutes();
                int totalMinutesB = rentalArr[j].getHours() * 60 + rentalArr[j].getExtraMinutes();
                if (totalMinutesA > totalMinutesB) {
                    Rental temp = rentalArr[i];
                    rentalArr[i] = rentalArr[j];
                    rentalArr[j] = temp;
                }
            }
        }
        displayAll();
    }

    /**
     * Display all objects within array
     */
    public static void displayAll() {
        for (Rental obj : rentalArr) {
            displayDetails(obj);
            System.out.println();
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

}
