package org.example;

/**
 * Subclass of Employee
 * Represents a Manager in Carly's Catering
 */
public class Manager extends Employee {
    public static final double MINIMUM_WAGE = 15.00; // Constant minimum wage for managers
    public static final double MAXIMUM_WAGE = 30.00; // Constant maximum wage for managers

    /**
     * Constructs a Manager object
     * @param idNum Identification Number of Manager
     * @param lastName Last name of Manager
     * @param firstName First name of Manager
     * @param payRate Pay rate of Manager
     */
    public Manager(String idNum, String lastName, String firstName, double payRate) {
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
        this.jobTitle = "Manager";
    }
}
