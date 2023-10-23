/**
 * HW03 : Bus.java .
 * @author kalanidissanayake
 * @version 1
 */
public class Bus extends Vehicle {
    private String location;
    private int stopsPerMile;
    /**
     * constructs Bus object (4 args).
     * @param id : a string representing the identifier for the vehicle
     * @param numMiles : an int representing the number of miles the vehicle has travelled
     * @param location : a string that represents the general area of the route
     * @param stopsPerMile : an int representing how many times a bus stops in one mile
     */
    public Bus(String id, int numMiles, String location, int stopsPerMile) {
        super(id, numMiles, new String[20]);
        this.location = location;
        this.stopsPerMile = stopsPerMile;
    }
    /**
     * constructs Bus object (2 args).
     * @param id : a string representing the identifier for the vehicle
     * @param location : a string that represents the general area of the route
     */
    public Bus(String id, String location) {
        this(id, 0, location, 2);
    }
    /**
     * an abstract method defining whether the car can drive that far.
     * @param distance : the distance a vehicle is needed to drive
     * @return true (if car can drive distance) or false (if car CANT drive distance)
     */
    public boolean canDrive(int distance) {
        if (distance >= 0) {
            return true;
        }
        return false;
    }
    /**
     * calculates cost for the vehicle to go the distance.
     * @param distance : an int representing the distance a vehicle is needed to drive
     * @return the cost for the vehicle to go the distance
     */
    public double calculateCost(int distance) {
        if (canDrive(distance)) {
            return ((3 * distance) / stopsPerMile);
        }
        return -1;
    }
    /**
     * add a group of (new) passengers to the passengers array.
     * @param distance : an int representing the distance a vehicle is needed to drive
     * @param passengersBoarding : an array of strings represening the new passengers to add to passenger list
     * @return true (if all customers can fit in the vehicle and car can drive) or
     * false (if all customers CANT fit in the vehicle or car CANT drive)
     */
    public boolean addPassenger(int distance, String[] passengersBoarding) {
        int passengersBoarded = 0;
        if (canDrive(distance)) {
            for (int i = 0; i < passengersBoarding.length; i++) {
                if (passengers[i] == null) {
                    if (passengersBoarding[i] != null) {
                        passengers[i] = passengersBoarding[i];
                        passengersBoarded++;
                    }
                }
            }
            setEarnings(getEarnings() + (passengersBoarded * calculateCost(distance)));
            numMiles += distance;
            return true;
        }
        return false;
    }
    /**
     * compares if 2 Bus objects are equal.
     * @param o : another object
     * @return true (if obects are equal) or false (if obects ARENT equal)
     */
    public boolean equals(Object o) {
        if (o instanceof Bus) {
            Bus b =  (Bus) o;
            return (super.equals(b) && (this.location == b.location)
                    && (this.stopsPerMile == b.stopsPerMile));
        }
        return false;
    }
    /**
     * creates a string representaion of Bus.
     * @return string representation of Bus
     */
    public String toString() {
        return ("Bus " + super.toString() + String.format(" This bus drives around %s and makes %d stops per mile.",
                location, stopsPerMile));
    }
    /**
     * set a value for location.
     * @param location : a string that represents the general area of the route
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * set a value for stopsPerMile.
     * @param stopsPerMile : an int representing how many times a bus stops in one mile
     */
    public void setStopsPerMile(int stopsPerMile) {
        this.stopsPerMile = stopsPerMile;
    }
    /**
     * get the value in location.
     * @return location : a string that represents the general area of the route
     */
    public String getLocation() {
        return location;
    }
    /**
     * get the value in stopsPerMile.
     * @return stopsPerMile : an int representing how many times a bus stops in one mile
     */
    public int getStopsPerMile() {
        return stopsPerMile;
    }
}
