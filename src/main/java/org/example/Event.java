package org.example;

/**
 * Author: Lucious Morrison
 * Date: 11/11/20
 * Assignment: Unit 10 Case Problems - Carly Event
 */

/**
 * Event represents an event by Carly's Catering.
 */
public class Event {
    public final static double HIGH_GUEST_PRICE = 35.00; // price per guest for small events
    public final static double LOW_GUEST_PRICE = 32.00; // discounted price for guests for large events
    public final static int LARGE_EVENT = 50; // minimum number of guests for a large event
    public final static int EVENT_NUM_LENGTH = 4; // required length of the event number
    public final static String[] eventNames = {"wedding", "baptism", "birthday", "corporate", "other"}; // Names of the types of events that an event could be

    private String eventNumber;
    private int numOfGuests;
    private double pricePerGuest;
    private double priceForEvent;
    private int eventType; // Number corresponding to the event type within the array

    /**
     * Creates an Event where all the instance variables are set to default values
     */
    public Event() {
        this("A000", 0, 0);
    }

    /**
     * Creates an Event with the given event number and number guests.
     * It calculates the pricePerGuest and priceForEvent based on the number of guests.
     * Any remaining instance variables will be set to a default value
     *
     * @param num The event number
     * @param guests The number of guests
     * @param eventType - Numerical value/index of event type in array
     */
    public Event(String num, int guests, int eventType) {
        setEventNumber(num);
        setGuests(guests);
        setEventType(eventType);
    }

    /**
     * Sets the value of the event number based on the given value.
     * If the given value is the required length, with a letter followed by 3 digits,
     * then eventNumber is set to the uppercase version of the parameter.
     * Otherwise, it is set to a default value of "A000"
     *
     * @param num The desired value for an event number
     */
    private void setEventNumber(String num) {
        if (num.length() != EVENT_NUM_LENGTH ||
                !Character.isLetter(num.charAt(0)) ||
                !Character.isDigit(num.charAt(1)) ||
                !Character.isDigit(num.charAt(2)) ||
                !Character.isDigit(num.charAt(3))) {
            eventNumber = "A000";
        } else {
            eventNumber = num.toUpperCase();
        }
    }

    /**
     * Sets the number of guests to the given value
     * It with also set the pricePerGuest and priceForEvent based on the size of the event
     *
     * @param gsts Number of guests for the event
     */
    private void setGuests(int gsts) {
        numOfGuests = gsts;
        if (isLargeEvent()) {
            pricePerGuest = LOW_GUEST_PRICE;
            priceForEvent = numOfGuests * LOW_GUEST_PRICE;
        } else {
            pricePerGuest = HIGH_GUEST_PRICE;
            priceForEvent = numOfGuests * HIGH_GUEST_PRICE;
        }
    }

    /**
     * Sets the event type to the given value
     * Value corresponds to the index in eventNames array
     */
    private void setEventType(int eventType) {
        if (eventType >= eventNames.length ||
                eventType < 0) {
            eventType = eventNames.length - 1;
        }
        this.eventType = eventType;
    }

    /**
     * Gets the event number of this Event
     *
     * @return this Event's eventNumber
     */
    public String getEventNumber() {
        return eventNumber;
    }

    /**
     * Gets the number of guests for this Event
     *
     * @return this Event's numOfGuests
     */
    public int getGuests() {
        return numOfGuests;
    }

    /**
     * Gets the total price for this Event
     *
     * @return this Event's priceForEvent
     */
    public double getPriceForEvent() {
        return priceForEvent;
    }

    /**
     * Gets the price for each guest for this Event
     *
     * @return this Event's pricePerGuest
     */
    public double getPricePerGuest() {
        return pricePerGuest;
    }

    /**
     * Gets the event numerical value
     * @return this Event's eventType
     */
    public int getEventType() {
        return eventType;
    }

    /**
     * Gets the event type based on the numeric value of eventType
     * @return this Event's eventName
     */
    public String getEventName() {
        return eventNames[eventType];
    }

    /**
     * Checks if this Event is a large event
     * @return true if number of guests is greater than or equal to LARGE_EVENT.
     * 		Otherwise, it returns false.
     */
    public boolean isLargeEvent() {
        boolean isLarge = false;
        if (numOfGuests >= LARGE_EVENT) {
            isLarge = true;
        }
        return isLarge;
    }
}