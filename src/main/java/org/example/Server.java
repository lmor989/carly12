package org.example;

/**
 * Subclass of Employee
 * Represents a Server in Carly's Catering
 */
public class Server extends Employee {
    public static final double MINIMUM_WAGE = 7.25; // Constant minimum wage for servers
    public static final double MAXIMUM_WAGE = 15.00; // Constant maximum wage for servers

    /**
     * Constructs a Server object
     * @param idNum Identification Number of Server
     * @param lastName Last name of Server
     * @param firstName First name of Server
     * @param payRate Pay rate of Server
     */
    public Server(String idNum, String lastName, String firstName, double payRate) {
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
        this.jobTitle = "Server";
    }
}
