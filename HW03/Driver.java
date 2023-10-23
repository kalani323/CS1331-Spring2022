/**
 * HW04 : Driver.java .
 * @author kalanidissanayake
 * @version 1
 */
public class Driver {
    /**
     * main method (where all arguments from other class are executed).
     * @param args : command line arguments
     */
    public static void main(String[] args) {
        // TESTING CAR CLASS
        // create 2 car objects
        Car c1 = new Car("Car1");
        Car c2 = new Car("Car2", 12, 40);
        // add passengers to at lease one of the car objects
        String[] passengers = {"ross", "rachel", "phoebe"};
        boolean testAddPassengerCar = c1.addPassenger(10, passengers);
        // call toString on both Car objects
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        // Check to see if 2 Car objects are equal
        System.out.println(c1.equals(c2));

        // TESTING BUS CLASS
        // create 2 bus objects
        Bus b1 = new Bus("Bus1", "Atlanta");
        Bus b2 = new Bus("Bus2", 14, "Marietta", 4);
        // add passengers to at lease one of the car objects
        boolean testAddPassengerBus = b2.addPassenger(10, passengers);
        // call toString on both Bus objects
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        // Check to see if 2 Bus objects are equal
        System.out.println(b1.equals(b2));
    } // end main
} // end classs
