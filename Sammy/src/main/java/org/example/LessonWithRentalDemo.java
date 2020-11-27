/**
 * Author: Lucious Morrison
 * Date: 11/19/20
 * Assignment: Unit 11 Case Problems - Sammy LessonWithRentalDemo
 */

package org.example;

import java.util.Random;
import java.util.Scanner;

/**
 * LessonWithRentalDemo is used to create LessonWithRental objects based on user input and display the information
 * about the created events.
 */
public class LessonWithRentalDemo extends RentalDemo {
    private static final int NUM_EVENTS = 3; // Number of LessonWithRental objects that will be stored in array
    private static LessonWithRental[] lessonWithRentalArr = new LessonWithRental[NUM_EVENTS];
    private static Random rand = new Random();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        askUserForObjects();
        displayAll();
    }

    /**
     * Asks the user if they want to create their own LessonWithRental objects or
     * use randomly generated rentals(for testing purposes)..
     */
    public static void askUserForObjects() {
        int num;
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to use randomly generated objects(easy grading :) ) or create your " +
            "own?\n1). Use randomly generated objects\n2). Create Own Objects\n3). Exit");

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
            lessonWithRentalArr[i] = new LessonWithRental("A" +
                getRandomValue(minContractNumber, maxContractNumber),
                getRandomValue(minMinutes, maxMinutes),
                getRandomValue(minEquipmentType,maxEquipmentType),
                rand.nextBoolean());
        }
    }

    /**
     * Prompts the user to create LessonWithRental objects to be stored in array
     */
    public static void createOwnObjects() {
        for(int i = 0; i < NUM_EVENTS; i++) {
            System.out.println("Rental #" + (i + 1));
            lessonWithRentalArr[i] = new LessonWithRental(
                askUserForContractNumber(),
                askUserForMinutes(),
                askUserForEquipmentType(),
                rand.nextBoolean());

            System.out.println();
        }
    }

    /**
     * Display all objects within array
     */
    public static void displayAll() {
        for (LessonWithRental obj : lessonWithRentalArr) {
            displayDetails(obj);
            System.out.println(obj.getInstructor() + "\n");
        }
    }
}
