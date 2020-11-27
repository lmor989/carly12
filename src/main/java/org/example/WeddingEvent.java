package org.example;

/**
 * Author: Lucious Morrison
 * Date: 11/11/20
 * Assignment: Unit 10 Case Problems - Carly WeddingEvent
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * WeddingEvent represents an wedding event by Carly's Catering.
 */
public class WeddingEvent extends Event {
    private static final String[] APPETIZER_CHOICES = {"Mozzarella Sticks", "Onion Rings", "Nachos", "Bread", "Salad",
        "Other"};
    private static final String[] ENTREE_CHOICES = {"Steak", "Shrimp", "Chicken", "Crab", "Lobster", "Other"};
    private static final String[] DESSERT_CHOICES = {"Cake", "Ice Cream", "Cookies", "Cinnamon Rolls", "Cotton Candy",
        "Other"};
    private int appetizer;
    private int entree1;
    private int entree2;
    private int dessert;
    private boolean isBuffetStyle;
    protected List<Employee> employeeList = new ArrayList<>();

    /**
     * Creates a WeddingEvent object that with the given parameters
     *
     * @param num           - Event number used in superclass constructor
     * @param guests        - Number of guests used in superclass constructor
     * @param appetizer     - Index of appetizer
     * @param entree1       - Index of first entree
     * @param entree2       - Index of second entree
     * @param dessert       - Index of dessert
     */
    public WeddingEvent(String num, int guests, int appetizer, int entree1, int entree2, int dessert) {
        super(num, guests, 0);
        setAppetizer(appetizer);
        setEntree1(entree1);
        setEntree2(entree2);
        setDessert(dessert);
        setBuffetStyle();
    }

    /**
     * Getter method for appetizer choices
     * @return the string array for appetizer choices
     */
    public static String[] getAppetizerChoices() {
        return APPETIZER_CHOICES;
    }

    /**
     * Getter method for entree choices
     * @return the string array for entree choices
     */
    public static String[] getEntreeChoices() {
        return ENTREE_CHOICES;
    }

    /**
     * Getter method for dessert choices
     * @return the string array for dessert choices
     */
    public static String[] getDessertChoices() {
        return DESSERT_CHOICES;
    }

    /**
     * Getter method for appetizer numerical value
     * @return the integer/index of appetizer choice
     */
    public int getAppetizer() {
        return appetizer;
    }

    /**
     * Setter method for appetizer choice
     * @param appetizer numerical value of appetizer based off array
     */
    public void setAppetizer(int appetizer) {
        if (appetizer > APPETIZER_CHOICES.length - 1 || appetizer < 0) {
            appetizer = 5;
        }
        this.appetizer = appetizer;
    }

    /**
     * Getter method for the first entree choice
     * @return the numerical value of the choice
     */
    public int getEntree1() {
        return entree1;
    }

    /**
     * Setter method for the first entree choice
     * @param entree1 the numerical value of the choice
     */
    public void setEntree1(int entree1) {
        if (entree1 > ENTREE_CHOICES.length - 1 || entree1 < 0) {
            entree1 = 5;
        }
        this.entree1 = entree1;
    }

    /**
     * Getter method for the second entree choice
     * @return the numerical value of the choice
     */
    public int getEntree2() {
        return entree2;
    }

    /**
     * Setter method for the second entree choice
     * @param entree2 the numerical value of the choice
     */
    public void setEntree2(int entree2) {
        if (entree2 > ENTREE_CHOICES.length - 1 || entree2 < 0) {
            entree2 = 5;
        }
        this.entree2 = entree2;
    }

    /**
     * Getter method for the dessert choice
     * @return the numerical value of the choice
     */
    public int getDessert() {
        return dessert;
    }

    /**
     * Setter method for the dessert choice
     * @param dessert the numerical value of the choice
     */
    public void setDessert(int dessert) {
        if (dessert > DESSERT_CHOICES.length - 1 || dessert < 0) {
            dessert = 5;
        }
        this.dessert = dessert;
    }

    /**
     * Getter method for to determine if the entree is buffet style
     * @return true or false
     */
    public boolean isBuffetStyle() {
        return isBuffetStyle;
    }

    /**
     * Setter method for buffet style boolean based on entrees selected
     * If one entree is buffet style, meal is automatically buffet style
     */
    public void setBuffetStyle() {
        if (getEntree1() <= 1 || getEntree2() <= 1){
            isBuffetStyle = true;
        } else {
            isBuffetStyle = false;
        }
    }

    /**
     * Getter method to show all details of a wedding event's appetizer, entrees and dessert
     * @return a string showing all details
     */
    public String getMenu() {
        String buffetSaying;
        if (isBuffetStyle == true) {
            buffetSaying = "a buffet";
        } else {
            buffetSaying = "not buffet";

        }
        return "The menu for this wedding event is " + buffetSaying + " and includes the following: " + APPETIZER_CHOICES[appetizer] +
            ", " + ENTREE_CHOICES[entree1] + ", " + ENTREE_CHOICES[entree2] + ", " + DESSERT_CHOICES[dessert] + "\n";
    }

    /**
     * Getter method for employee list
     * @return this WeddingEvent's employeeList
     */
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    /**
     * Setter method for employee list
     * @param employeeList used to define this WeddingEvent's employeeList
     */
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
