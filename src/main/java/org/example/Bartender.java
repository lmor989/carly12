package org.example;

/**
 * Subclass of Employee
 * Represents a Bartender in Carly's Catering
 */
public class Bartender extends Employee {
    public static final double MINIMUM_WAGE = 10.00; // Constant minimum wage for bartenders
    public static final double MAXIMUM_WAGE = 18.00; // Constant maximum wage for bartenders

    /**
     * Constructs a Bartender object
     * @param idNum Identification Number of Bartender
     * @param lastName Last name of Bartender
     * @param firstName First name of Bartender
     * @param payRate Pay rate of Bartender
     */
    public Bartender(String idNum, String lastName, String firstName, double payRate) {
        setIdNumber(idNum);
        setLastName(lastName);
        setFirstName(firstName);
        setPayRate(payRate);
        setJobTitle();
    }

    /**
     * Overwritten setter method for pay rate
     * @param payRate used to define this Employee's payRate
     */
    @Override public void setPayRate(double payRate) {
        if (payRate > MAXIMUM_WAGE) {
            payRate = MAXIMUM_WAGE;
        } else if (payRate < MINIMUM_WAGE) {
            payRate = MINIMUM_WAGE;
        }
        this.payRate = payRate;
    }

    @Override public void setJobTitle() {
        this.jobTitle = "Bartender";
    }
}
