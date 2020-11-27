package org.example;

/**
 * Base class that subclasses for job types will implement in their implementation
 */
public abstract class Employee {
    private String idNumber; // Employee's identification number
    private String lastName; // Employee's last name
    private String firstName; // Employee's first name
    protected double payRate; // Employee's pay rate
    protected String jobTitle; // Employee's job title

    /**
     * Getter method for identification number
     * @return this Employee's idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * Setter method for identification number
     * @param idNumber used to define this Employee's idNumber field
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Getter method for last name
     * @return this Employee's lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for last name
     * @param lastName used to define this Employee's lastName field
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter method for first name
     * @return this Employee's firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method for first name
     * @param firstName used to define this Employee's firstName field
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter method for pay rate
     * @return this Employee's payRate
     */
    public double getPayRate() {
        return payRate;
    }

    /**
     * Abstract setter method for pay rate
     * @param payRate used to define this Employee's payRate
     */
    public abstract void setPayRate(double payRate);

    /**
     * Getter method for Employee's job title
     * @return this Employee's jobTitle
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Abstract setter method for job title
     */
    public abstract void setJobTitle();
}
