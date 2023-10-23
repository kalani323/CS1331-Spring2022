/**
 * HW03: Car.java .
 * @author kalanidissanayake
 * @version 1
 */
public class Car extends Vehicle {
    private double rate;
    private double fees;
    private int maxNumMiles;
    /**
     * Constructs Car object (6 args).
     * @param id : a string representing the identifier for the vehicle
     * @param numMiles : an int representing the number of miles the vehicle has travelled
     * @param passengers : an array of strings representing the passengers aboard the vehicle
     * each item in array represents a passenger's name
     * @param rate : a double representing the price of using the car to go 1 mile
     * @param fees : a double representing the total fees for the car once
     * @param maxNumMiles : an int representing the total number of miles that the car can drive before it is retired
     */
    public Car(String id, int numMiles, String[] passengers, double rate, double fees, int maxNumMiles) {
        super(id, numMiles, passengers);
        this.rate = rate;
        this.fees = fees;
        this.maxNumMiles = maxNumMiles;
    }
    /**
     * Constructs Car object (3 args).
     * @param id : a string representing the identifier for the vehicle
     * @param numMiles : an int representing the number of miles the vehicle has travelled
     * @param maxNumMiles : an int representing the total number of miles that the car can drive before it is retired
     */
    public Car(String id, int numMiles, int maxNumMiles) {
        super(id, numMiles, new String[4]);
        this.maxNumMiles = maxNumMiles;
        this.rate = 10;
        this.fees = 15;
    }
    /**
     * Constructs Car object (1 arg).
     * @param id : a string representing the identifier for the vehicle
     */
    public Car(String id) {
        this(id, 0, 200);
    }
    /**
     * returns true or false based on whether the car can drive that far.
     * @param distance : the distance a vehicle is needed to drive
     * @return true (if car can drive distance) or false (if car CANT drive distance)
     */
    public boolean canDrive(int distance) {
        if (distance <= maxNumMiles && distance > 0) {
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
            return ((rate * distance) + fees);
        }
        return -1;
    }
    /**
     * add a group of (new) passengers to the passengers array.
     * @param distance : an int representing the distance a vehicle is needed to drive
     * @param passengersBoarding : an array of strings represening the new passengers to add to passenger list
     * @return true (if all customers can fit in the vehicle and car can drive)
     * or false (if all customers CANT fit in the vehicle or car CANT drive)
     */
    public boolean addPassenger(int distance, String[] passengersBoarding) {
        // calculate spots available on bus
        int spotsAvailable = 0;
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                spotsAvailable++;
            }
        }
        // then if there is space for everyone, add them to list
        if ((passengersBoarding.length <= spotsAvailable) && canDrive(distance)) {
            for (int i = 0; i < passengersBoarding.length; i++) {
                if (passengers[i] == null) {
                    passengers[i] = passengersBoarding[i];
                }
            }
            setEarnings(getEarnings() + calculateCost(distance));
            numMiles += distance;
            return true;
        }
        return false;
    }
    /**
     * compares if 2 Car objects are equal.
     * @param o : another object
     * @return true (if obects are equal) or false (if obects ARENT equal)
     */
    public boolean equals(Object o) {
        if (o instanceof Car) {
            Car oCar =  (Car) o;
            return (super.equals(o) && (this.rate == oCar.rate)
                    && (this.fees == oCar.fees) && (this.maxNumMiles == oCar.maxNumMiles));
        }
        return false;
    }
    /**
     * creates a string representaion of Car.
     * @return string representation of Car
     */
    public String toString() {
        return ("Car " + super.toString() + String.format(" It can only drive %d miles. It costs %.2f dollars per "
                + "mile and there is a one-time fee of %.2f dollars",
                maxNumMiles, rate, fees));
    }
    /**
     * set a value for rate.
     * @param rate : a double representing the price of using the car to go 1 mile
     */
    public void setRate(double rate) {
        this.rate = rate;
    }
    /**
     * set a value for fees.
     * @param fees : a double representing the total fees for the car once
     */
    public void setFees(double fees) {
        this.fees = fees;
    }
    /**
     * set a value for maxNumMiles.
     * @param maxNumMiles : an int representing the total number of miles that the car can drive before it is retired
     */
    public void setMaxNumMiles(int maxNumMiles) {
        this.maxNumMiles = maxNumMiles;
    }
    /**
     * get the value in rate.
     * @return rate : a double representing the price of using the car to go 1 mile
     */
    public double getRate() {
        return rate;
    }
    /**
     * get the value in fees.
     * @return fees : a double representing the total fees for the car once
     */
    public double getFees() {
        return fees;
    }
    /**
     * get the value in maxNumMiles.
     * @return maxNumMiles : an int representing the total number of miles that the car can drive before it is retired
     */
    public int getMaxNumMiles() {
        return maxNumMiles;
    }
}
