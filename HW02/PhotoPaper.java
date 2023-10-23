/**
 * HW02 : PhotoPaper.java.
 * @author kalanidissanayake
 * @version 1
 */
public class PhotoPaper extends PaperProduct {
    private double glossiness;
    /**
     * constructs the PhotoPaper object.
     * @param name : string variable representing the name of a product at a given index
     * @param numberOfSheets : int representing the number of the sheets of paper present in this product
     * @param weightOfUnitSheet : double representing the weight, in grams, of one sheet of
     * the paper product at a given instance
     * @param glossiness : double representing the glossiness of the paper product
     */
    public PhotoPaper(String name, int numberOfSheets, double weightOfUnitSheet, double glossiness) {
        super(name, numberOfSheets, weightOfUnitSheet);
        setGlossiness(glossiness);
    }
    /**
     * constructs the PhotoPaper object.
     * @param name : string variable representing the name of a product at a given index
     * @param numberOfSheets : int representing the number of the sheets of paper present in this product
     */
    public PhotoPaper(String name, int numberOfSheets) {
        super(name, numberOfSheets);
        this.glossiness = 70;
    }
    /**
     * constructs the PhotoPaper object.
     * @param name : string variable representing the name of a product at a given index
     */
    public PhotoPaper(String name) {
        super(name);
        this.glossiness = 70;
    }
    /**
     * constructs the PhotoPaper object (deep copy).
     * @param p : another photoPaper object
     */
    public PhotoPaper(PhotoPaper p) {
        super(p);
        this.glossiness = p.getGlossiness();
    }
   /**
    * creates a string representing the object.
    * @return  a string representing the object
    */
    public String photoString() {
        return String.format("%.2f%% glossy and %.2fg of %s for $%.2f",
                glossiness, totalWeight(), getName(), totalCost());
    }
    /**
     * shipping details.
     * @param companyName : name of company
     * @return String summary of shipping details
     */
    public String shipPhoto(String companyName) {
        if (getTotalProductsToShip() != 0) {
            return (String.format("Paper is %.2f%% glossy. ", glossiness)
                    + ship(companyName));
        } else {
            return String.format("Paper is %.2f%% glossy. Cannot ship any items, Warehouse is empty", glossiness);
        }
    }
    /**
     * set glossiness.
     * @param glossiness : : double representing the glossiness of the paper product
     */
    public void setGlossiness(double glossiness) {
        this.glossiness = glossiness;
        if (glossiness > 100 || glossiness < 0) {
            this.glossiness = 70;
        }
    }
    /**
     * get glossiness.
     * @return glossiness : double representing the glossiness of the paper product
     */
    public double getGlossiness() {
        return glossiness;
    }
}
