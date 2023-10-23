public class Driver {
	public static void main(String[] args) {
		GarageOwner theOwner = new GarageOwner("Kalani Dissanayake", 18);
		Car[] carCatalogue = new Car[3];
		Garage myGarage = new Garage(theOwner, carCatalogue);
		
		Car car1 = new Car(2000, "Toyota", "Camry", "black", 75);
		Car car2 = new Car(2013, "Ford", "Focus");
		Car car3 = new Car();
		
		carCatalogue[0] = myGarage.addCar(0, car1);
		carCatalogue[1] = myGarage.addCar(1, car2);
		carCatalogue[2] = myGarage.addCar(2, car3);
		
		carCatalogue[1] = myGarage.sellCar(1);
		
		System.out.print(myGarage.getCarsOwned() + "\n");
		
		myGarage.showCertainCars(85);
	} // end main
} // end class
