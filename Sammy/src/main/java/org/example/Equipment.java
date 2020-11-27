/**
 * Author: Lucious Morrison
 * Date: 11/19/20
 * Assignment: Unit 11 Case Problems - Sammy Equipment
 */

package org.example;

/**
 * Abstract class used to provide implementation for subclasses
 */
public abstract class Equipment {
    public static final String[] EQUIPMENT_NAMES = {"personal watercraft", "pontoon boat", "rowboat", "canoe", "kayak",
        "beach chair", "umbrella", "other"}; // Names of the type of equipment that are possible to rent
    public static final int[] SURCHARGES = {48, 45, 15, 12, 12, 5, 4, 0}; // Array of surcharges based on equipment type
    protected int equipmentIndex;
    protected String equipmentName;
    protected int fee;

    /**
     * Constructor used to create an Equipment object
     * @param equipmentIndex index of the equipment corresponding to the EQUIPMENT_NAMES array
     */
    public Equipment(int equipmentIndex) {
        setEquipmentIndex(equipmentIndex);
    }

    /**
     * Getter method for equipment index
     * @return the index of the equipment
     */
    public int getEquipmentIndex() {
        return equipmentIndex;
    }

    /**
     * Setter method for equipment index
     * @param equipmentIndex number used to define the equipment index
     */
    public abstract void setEquipmentIndex(int equipmentIndex);

    /**
     * Getter method for equipment name
     * @return string of the equipment's name
     */
    public String getEquipmentName() {
        return equipmentName;
    }

    /**
     * Setter method for equipment name
     */
    public abstract void setEquipmentName();

    /**
     * Getter method for equipment fee
     * @return the integer value for fee corresponding to the equipment index
     */
    public int getFee() {
        return fee;
    }

    /**
     * Setter method for equipment fee
     */
    public abstract void setFee();

    /**
     * Shows if equipment requires a lesson
     */
    public abstract String lessonPolicyMethod();
}
