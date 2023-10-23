/**
 * HW02 : DiscountedPaper.java.
 * @author kalanidissanayake
 * @version 1
 */
public class DiscountedPaper extends PaperProduct {
    private double discount;
    private GoldenTicket ticket;
    /**
     * constructs the DiscountedPaper object.
     * @param name : string variable representing the name of a product at a given index
     * @param numberOfSheets : int representing the number of the sheets of paper present in this product
     * @param weightOfUnitSheet : double representing the weight, in grams, of one sheet of
     * the paper product at a given instance
     * @param discount : a double representing the discount of the paper product, in percent
     * @param ticket : represents whether this product has a golden ticket attatched to it
     */
    public DiscountedPaper(String name, int numberOfSheets, double weightOfUnitSheet,
        double discount, GoldenTicket ticket) {
        super(name, numberOfSheets, weightOfUnitSheet);
        setDiscount(discount);
        this.ticket = ticket;
    }
    /**
     * constructs the DiscountedPaper object.
     * @param name : string variable representing the name of a product at a given index
     * @param numberOfSheets : int representing the number of the sheets of paper present in this product
     */
    public DiscountedPaper(String name, int numberOfSheets) {
        super(name, numberOfSheets);
        this.discount = 15;
        this.ticket = null;
    }
    /**
     * constructs the DiscountedPaper object.
     * @param name : string variable representing the name of a product at a given index
     */
    public DiscountedPaper(String name) {
        super(name);
        this.discount = 15;
        this.ticket = null;
    }
    /**
     * constructs the DiscountedPaper object (deep copy).
     * @param p : another DiscountedPaper object
     */
    public DiscountedPaper(DiscountedPaper p) {
        super(new String(p.getName()), p.getNumberOfSheets(), p.getWeightOfUnitSheet());
        this.discount = p.getDiscount();
        this.ticket = new GoldenTicket(p.ticket.getCatchphrase(), p.ticket.getDiscount());
    }
    /**
     * caluclate discounted cost.
     * @return the discounted cost
     */
    public double discountedCost() {
        double cost = 0;
        cost += totalCost();
        cost *= (1 - (discount / 100));
        if (ticket != null) {
            cost *= (1 - (ticket.getDiscount() / 100));
        }
        return cost;
    }
    /**
     * shipping details.
     * @param companyName : name of the company
     * @return string representing the shipping details
     */
    public String shipDiscounted(String companyName) {
        if (getTotalProductsToShip() != 0) {
            return  (ship(companyName) + String.format(" The total cost after the discount is %.2f", discountedCost()));
        } else {
            return String.format("Cannot ship any items, Warehouse is empty! The total cost"
                    + " after the discount is %.2f", discountedCost());
        }
    }
    /**
     * creates a string representing the discounting of this product as an entry for the accounting department.
     * @return string representing the discounting of the product
     */
    public String botherAccounting() {
        if (this.ticket == null) {
            ticket = new GoldenTicket("", 0);
        }
        return String.format("Discounted Paper Product:\nOriginal Cost: %.2f\nFinal Cost: %.2f"
                + "\nOriginal Discount: %.2f%%\nGolden Ticket Discount: %.2f%%",
                totalCost(), discountedCost(), discount, ticket.getDiscount());
    }
    /**
     * set discount.
     * @param discount : a double representing the discount of the paper product, in percent
     */
    public void setDiscount(double discount) {
        this.discount = discount;
        if (discount <= 0 || discount > 50) {
            this.discount = 15.0;
        }
    }
    /**
     * set ticket.
     * @param ticket : represents whether this product has a golden ticket attatched to it
     */
    public void setTicket(GoldenTicket ticket) {
        this.ticket = ticket;
    }
    /**
     * get discount.
     * @return discount : a double representing the discount of the paper product, in percent
     */
    public double getDiscount() {
        return discount;
    }
    /**
     * get ticket.
     * @return ticket : represents whether this product has a golden ticket attatched to it
     */
    public GoldenTicket getTicket() {
        return ticket;
    }
}
