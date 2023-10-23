/**
 * HW02 : PaperProduct.java.
 * @author kalanidissanayake
 * @version 1
 */
public class PaperProduct {
    private final String name;
    private int numberOfSheets;
    private final double weightOfUnitSheet;
    private static int totalProductsToShip;
    public static final double COST_PER_GRAM = 0.025;

    /**
     * constructs the PaperProduct Object.
     * @param name : string variable representing the name of a product at a given index
     * @param numberOfSheets : int representing the number of the sheets of paper present in this product
     * @param weightOfUnitSheet : double representing the weight, in grams, of one sheet of
     * the paper product at a given instance
     */
    public PaperProduct(String name, int numberOfSheets, double weightOfUnitSheet) {
        if (name == null || name.equals("")) {
            name = "A4";
        }
        this.name = name;
        setNumberOfSheets(numberOfSheets);
        if (weightOfUnitSheet < 0) {
            weightOfUnitSheet = 0.25;
        }
        this.weightOfUnitSheet = weightOfUnitSheet;
        totalProductsToShip = 10;
    }
    /**
     * constructs the PaperProduct Object.
     * @param name : string variable representing the name of a product at a given index
     * @param numberOfSheets : int representing the number of the sheets of paper present in this product
     */
    public PaperProduct(String name, int numberOfSheets) {
        this(name, numberOfSheets, 0.25);
    }
    /**
     * constructs the PaperProduct Object.
     * @param name : string variable representing the name of a product at a given index
     */
    public PaperProduct(String name) {
        this(name, 500, 0.25);
    }
    /**
     * constructs the PaperProduct Object (deep copy).
     * @param p : another PaperProduct Object
     */
    public PaperProduct(PaperProduct p) {
        this.name = new String(p.getName());
        this.numberOfSheets = p.getNumberOfSheets();
        this.weightOfUnitSheet = p.getWeightOfUnitSheet();
    }
    /**
     * calculates total Weight.
     * @return the total weight
     */
    public double totalWeight() {
        double weight = numberOfSheets * weightOfUnitSheet;
        return weight;
    }
    /**
     * calculates total cost.
     * @return the total cost
     */
    public double totalCost() {
        double cost = totalWeight() * COST_PER_GRAM;
        return cost;
    }
    /**
     * a string summary of the object.
     * @return a string representing the object
     */
    public String paperString() {
        return String.format("%.2fg of %s for $%.2f", totalWeight(), name, totalCost());
    }
    /**
     * shipping details.
     * @param companyName : name of company
     * @return a string summary of the shipping details
     */
    public String ship(String companyName) {
        if (totalProductsToShip != 0) {
            totalProductsToShip--;
            return String.format("Shipped %.2fg of %s for $%.2f to %s", totalWeight(), name, totalCost(), companyName);
        } else {
            return ("Cannot ship any items, Warehouse is empty");
        }
    }
    /**
     * get the Name.
     * @return name : string variable representing the name of a product at a given index
     */
    public String getName() {
        return name;
    }
    /**
     * get the weight of unit sheet.
     * @return weightOfUnitSheet : double representing the weight, in grams, of one
     * sheet of the paper product at a given instance
     */
    public double getWeightOfUnitSheet() {
        return weightOfUnitSheet;
    }
    /**
     * get the total products to ship.
     * @return totalProductsToShip :  an int representing the total number of paperProducts that can be shipped
     */
    public static int getTotalProductsToShip() {
        return totalProductsToShip;
    }
    /**
     * get the number of sheets.
     * @return numberOfSheets : int representing the number of the sheets of paper present in this product
     */
    public int getNumberOfSheets() {
        return numberOfSheets;
    }
    /**
     * set the NumberOfSheets.
     * @param numberOfSheets : int representing the number of the sheets of paper present in this product
     */
    public void setNumberOfSheets(int numberOfSheets) {
        if (numberOfSheets < 0) {
            numberOfSheets = 500;
        }
        this.numberOfSheets = numberOfSheets;
    }
}
