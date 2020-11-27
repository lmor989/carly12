/**
 * Author: Lucious Morrison
 * Date: 11/19/20
 * Assignment: Unit 11 Case Problems - Sammy Rental
 */

package org.example;

/**
 * Rental represents a rental for Sammy's Seashore.
 */
public class Rental {
    public static final int MINUTES_IN_HOUR = 60;
    public static final int HOUR_RATE = 40; // The rental rate for an hour
    public static final int CONTRACT_NUM_LENGTH = 4; // The required length of the contract number
    private static final int INDEX_OF_LAST_LESSON = 4; // Index of last item requiring lessons, indexes afterwards do
    // not require lessons
    private static final int INVENTORY_SIZE = 8; // Number of items in the equipment array
    private String contractNumber;
    private int hours;
    private int extraMinutes;
    private double totalPrice; // Total cost of the rental
    private double basePrice;
    private Equipment itemRented;
    /**
     * Creates a Rental object based on given contract number and rental minutes.
     *
     * @param num The contract number for this Rental
     * @param minutes The total number of minutes for this Rental
     * @param equipmentType - Numerical value of equipment rented
     */
    public Rental(String num, int minutes, int equipmentType) {
        setContractNumber(num);
        setEquipment(equipmentType);
        setHoursAndMinutes(minutes);
    }

    /**
     * Creates a Rental object with a contract number of "A000" and rental time of 0.
     * Price is also set to 0.
     * Any additional instance variables are set to a default value.
     */
    public Rental() {
        this("A000", 0, 0);
    }

    /**
     * Sets the contract number of this Event based on the given value.
     * If it meets the format requirements it sets it to the uppercase version of the
     * given value.  Otherwise, it sets it to "A000"
     *
     * @param num The desired contract number
     */
    private void setContractNumber(String num) {
        if (num.length() != CONTRACT_NUM_LENGTH ||
            !Character.isLetter(num.charAt(0)) ||
            !Character.isDigit(num.charAt(1)) ||
            !Character.isDigit(num.charAt(2)) ||
            !Character.isDigit(num.charAt(3))) {
            contractNumber = "A000";
        } else {
            contractNumber = num.toUpperCase();
        }
    }

    /**
     * Sets the hours, extra minutes, and price based on the given minutes.
     *
     * @param minutes The total number of minutes for this Rental
     */
    private void setHoursAndMinutes(int minutes) {
        hours = minutes / MINUTES_IN_HOUR;
        extraMinutes = minutes % MINUTES_IN_HOUR;
        if (extraMinutes <= HOUR_RATE) {
            basePrice = hours * HOUR_RATE + extraMinutes;
        } else {
            basePrice = hours * HOUR_RATE + HOUR_RATE;
        }
        totalPrice = basePrice + itemRented.getFee();
    }

    /**
     * Gets the contract number of the Rental
     *
     * @return this Rental's contractNumber
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * Gets the number of hours for this Rental
     *
     * @return this Rental's hour
     */
    public int getHours() {
        return hours;
    }

    /**
     * Gets the number of extra minutes beyond an hour for this Rental
     *
     * @return this Rental's extraMinutes
     */
    public int getExtraMinutes() {
        return extraMinutes;
    }

    /**
     * Gets the total price of this Rental
     *
     * @return this Rental's price
     */
    public double getPrice() {
        return totalPrice;
    }

    public void setEquipment(int equipmentType) {
        if (equipmentType <= INDEX_OF_LAST_LESSON && equipmentType > -1) {
            itemRented = new EquipmentWithLesson(equipmentType);
        } else if (equipmentType > INDEX_OF_LAST_LESSON && equipmentType < INVENTORY_SIZE - 1) {
            itemRented = new EquipmentWithoutLesson(equipmentType);
        } else {
            itemRented = new EquipmentWithoutLesson(INVENTORY_SIZE - 1);
        }
    }

    /**
     * Getter method for itemRented
     * @return itemRented object
     */
    public Equipment getItemRented() {
        return itemRented;
    }
}

