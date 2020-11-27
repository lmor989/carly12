/**
 * Author: Lucious Morrison
 * Date: 11/19/20
 * Assignment: Unit 11 Case Problems - Sammy LessonWithRental
 */

package org.example;

/**
 * Represents a rental with the possibility of a lesson being required by Sammy's Seashore
 */
public class LessonWithRental extends Rental {
    private static final String[] INSTRUCTORS = {"Sekcienski", "Morris", "Davis", "James", "Smith", "McGee", "Howard",
        "Bradley"};
    private boolean isLessonRequired;

    /**
     * Constructs an LessonWithRental object
     *
     * @param num rental contract number
     * @param minutes minutes rental loaned
     * @param equipmentType type of rental equipment loaned
     * @param isLessonRequired is a lesson required to use this equipment
     */
    public LessonWithRental(String num, int minutes, int equipmentType, boolean isLessonRequired) {
        super(num, minutes, equipmentType);
        //setLessonRequired();
    }

    /**
     * Getter method for retrieving the instructors array
     * @return the instructors array
     */
    public static String[] getINSTRUCTORS() {
        return INSTRUCTORS;
    }

    /**
     * Getter method to retrieve the boolean value of isLessonRequired
     * @return the true/false value of the boolean
     */
    public boolean isLessonRequired() {
        return isLessonRequired;
    }

    

    /**
     * Getter method to display an actual string about if the lesson is required
     * @return a string that uses the equipmentname to determine if a lesson will be required
     */
    public String getInstructor() {
        if (isLessonRequired == true) {
            return "To rent the " + super.getItemRented().getEquipmentName() + ", training is required. The " +
                "instructor for training is " + INSTRUCTORS[super.getItemRented().getEquipmentIndex()] + ".";
        } else {
            return "To rent the " + super.getItemRented().getEquipmentName() + ", training is not required.";
        }
    }
}
