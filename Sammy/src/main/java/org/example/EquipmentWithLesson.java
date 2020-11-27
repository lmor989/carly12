/**
 * Author: Lucious Morrison
 * Date: 11/19/20
 * Assignment: Unit 11 Case Problems - Sammy EquipmentWithLesson
 */

package org.example;

/**
 * Creates an Equipment object that requires a lesson
 */
public class EquipmentWithLesson extends Equipment {
    public static final int LESSON_COST = 32;

    public EquipmentWithLesson(int equipmentIndex) {
        super(equipmentIndex);
        setEquipmentIndex(equipmentIndex);
        setEquipmentName();
        setFee();
    }

    /**
     * Setter method for equipment index
     * @param equipmentIndex number used to define the equipment index
     */
    public void setEquipmentIndex(int equipmentIndex) {
        this.equipmentIndex = equipmentIndex;
    }

    /**
     * Setter method for equipment name
     */
    public void setEquipmentName() {
        this.equipmentName = EQUIPMENT_NAMES[equipmentIndex];
    }

    /**
     * Setter method for equipment fee
     */
    public void setFee() {
        this.fee = SURCHARGES[equipmentIndex] + LESSON_COST;
    }

    /**
     * Shows equipment requires a lesson
     */
    public String lessonPolicyMethod() {
        return "This equipment requires a lesson, which is $" + LESSON_COST;
    }
}
