public class Garage {
    private GarageOwner theOwner;
    private Car[] carCatalogue;

    public Garage(GarageOwner theOwner, Car[] carCatalogue) {
        this.theOwner = theOwner;
        this.carCatalogue = carCatalogue;
    }

    public Garage() {
        this.theOwner = new GarageOwner("Enzo Ferrari", 35);
        this.carCatalogue = new Car[4];
    }

    public Car addCar(int index, Car p) {
        if (index > carCatalogue.length || index < 0 || p == null) {
            System.out.println("Cannot add a car to this spot");
            return null;
        }
        if (carCatalogue[index] == null) {
            System.out.println("A " + p.getColor() + " " + p.getYear() + " "
                   + p.getMake() + " " + p.getModel() + " was just parked here.");
            carCatalogue[index] = p;
            return carCatalogue[index];
        } else {
            System.out.println("There was a " + carCatalogue[index].getColor() + " "
                   + carCatalogue[index].getYear() + " " + carCatalogue[index].getMake() + " "
                   + carCatalogue[index].getModel() + " here.");
            return carCatalogue[index];
        }
    } // end addCar method

    public Car sellCar(int index) {
        Car temp = null;
        if (index > carCatalogue.length || index < 0 || carCatalogue[index] == null) {
            System.out.println("There was no car to sell!");
            temp = null;
        } else {
            System.out.println(theOwner.getName() + " just sold a "
                   + carCatalogue[index].getColor() + " " + carCatalogue[index].getYear() + " "
                   + carCatalogue[index].getMake() + " " + carCatalogue[index].getModel() + ".");
            temp = carCatalogue[index];
            carCatalogue[index] = null;
        }
        return temp;
    } // end sellCar method

    public void showCertainCars(int conditionCategory) {
        for (int i = 0; i < carCatalogue.length; i++) {
            if ((carCatalogue[i] != null) && (carCatalogue[i].getConditionCategory() >= conditionCategory)) {
                System.out.println("A " + carCatalogue[i].getColor() + " "
                           + carCatalogue[i].getYear() + " " + carCatalogue[i].getMake() + " "
                           + carCatalogue[i].getModel() + " with a condition category of "
                           + carCatalogue[i].getConditionCategory());
            }
        }
    } // end showCertainCars method
    public int getCarsOwned() {
        int sum = 0;
        for (int i = 0; i < carCatalogue.length; i++) {
            if (carCatalogue[i] != null) {
                sum++;
            }
        }
        return sum;
    }
} // end class
