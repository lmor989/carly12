/**
 * Author: Lucious Morrison
 * Date: 11/19/20
 * Assignment: Unit 11 Case Problems - Sammy EquipmentWithoutLesson
 */

package org.example;

/**
 * Creates an Equipment object that requires a lesson
 */
public class EquipmentWithoutLesson extends Equipment {

    public EquipmentWithoutLesson(int equipmentIndex) {
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
        this.fee = SURCHARGES[equipmentIndex];
    }

    /**
     * Shows equipment does not require a lesson
     */
    public String lessonPolicyMethod() {
        return "This equipment does not require a lesson";
    }
}
