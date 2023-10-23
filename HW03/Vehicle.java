/**
 * HW03: Vehicle.java .
 * @author kalanidissanayake
 * @version 1
 */
public abstract class Vehicle {
    private final String id;
    private double earnings;
    protected int numMiles;
    protected String[] passengers;
    /**
     * constructs Vehicle (3 args).
     * @param id : a string representing the identifier for the vehicle
     * @param numMiles : an int representing the number of miles the vehicle has travelled
     * @param passengers : an array of strings representing the passengers aboard the vehicle
     * each item in array represents a passenger's name
     */
    public Vehicle(String id, int numMiles, String[] passengers) {
        this.id = id;
        this.numMiles = numMiles;
        this.passengers = passengers;
        this.earnings = 0;
    }
    /**
     * constructs Vehicle (2 args).
     * @param id : a string representing the identifier for the vehicle
     * @param passengers : an array of strings representing the passengers aboard the vehicle
     * each item in array represents a passenger's name
     */
    public Vehicle(String id, String[] passengers) {
        this(id, 0, passengers);
    }
    /**
     * an abstract method defining whether the car can drive that far.
     * @param distance : the distance a vehicle is needed to drive
     * @return true (if car can drive distance) or false (if car CANT drive distance)
     */
    public abstract boolean canDrive(int distance);
    /**
     * calculates cost for the vehicle to go the distance.
     * @param distance : an int representing the distance a vehicle is needed to drive
     * @return the cost for the vehicle to go the distance
     */
    public abstract double calculateCost(int distance);
    /**
     * add a group of (new) passengers to the passengers array.
     * @param distance : an int representing the distance a vehicle is needed to drive
     * @param newPassengers : an array of strings represening the new passengers to add to passenger list
     * @return true (if all customers can fit in the vehicle and car can drive)
     * or false (if all customers CANT fit in the vehicle or car CANT drive)
     */
    public abstract boolean addPassenger(int distance, String[] newPassengers);
    /**
     * charges the customer for the ride (adds this value to earnings).
     * @param distance : an int representing the distance a vehicle is needed to drive
     */
    public void chargeRide(int distance) {
        if (canDrive(distance)) {
            this.numMiles += distance;
            earnings += calculateCost(distance);
        }
    }
    /**
     * compares if 2 Vehicle objects are equal.
     * @param o : another object
     * @return true (if obects are equal) or false (if obects ARENT equal)
     */
    public boolean equals(Object o) {
        if (o instanceof Vehicle) {
            Vehicle oVehicle =  (Vehicle) o;
            return ((this.id.equals(oVehicle.id)) && (this.numMiles == oVehicle.numMiles));
        }
        return false;
    }
    /**
     * creates a string representaion of Vehicle.
     * @return string representation of Vehicle
     */
    public String toString() {
        return String.format("%s has driven %d miles and has earned %.2f dollars.", id, numMiles, earnings);
    }
    /**
     * set a value for earnings.
     * @param earnings : a double representing the total amount of money this vehicle made by exporting passengers
     */
    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }
    /**
     * set a value for numMiles.
     * @param numMiles : an int representing the number of miles the vehicle has travelled
     */
    public void setNumMiles(int numMiles) {
        this.numMiles = numMiles;
    }
    /**
     * get the value in earnings.
     * @return earnings : a double representing the total amount of money this vehicle made by exporting passengers
     */
    public double getEarnings() {
        return earnings;
    }
    /**
     * get the value in numMiles.
     * @return numMiles : an int representing the number of miles the vehicle has travelled
     */
    public int getNumMiles() {
        return numMiles;
    }
}
