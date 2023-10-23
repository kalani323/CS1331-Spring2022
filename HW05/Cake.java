/**
 * HW05: Cake.java .
 * @author kalanidissanayake
 * @version 1
 */
public class Cake extends Dessert {
    private String frosting;
    /**
     * constructs Dessert (3 args).
     * @param flavor : flavor of the dessert
     * @param sweetness : sweetness of the dessert
     * @param frosting : what the frosting of the cake is
     */
    public Cake(String flavor, double sweetness, String frosting) {
        super(flavor, sweetness);
        setFrosting(frosting);
    }
    /**
     * constructs Dessert (1 args).
     * @param flavor : flavor of the dessert
     */
    public Cake(String flavor) {
        this(flavor, 45.0, "vanilla");
    }
    /**
     * creates a string representation of Cake.
     * @return returns a string representation of Cake
     */
    public String toString() {
        return String.format("This is a %s cake with a %s frosting and has a sweetness of %.2f",
                getFlavor(), frosting, getSweetness());
    }
    /**
     * compares to objects to see if they are equal or not.
     * @param o : another Object
     * @return true (if objects have the same flavor, sweetness, and frosting)
     * or false (if objects DONT have the same flavor, sweetness, and frosting)
     */
    public boolean equals(Object o) {
        if (o instanceof Cake) {
            Cake oC = (Cake) o;
            return ((this.getFlavor().equals(oC.getFlavor()))
                    && (this.getSweetness() == oC.getSweetness())
                    && (this.getFrosting().equals(oC.getFrosting())));
        } else {
            return false;
        }
    }
    /**
     * set frosting.
     * @param frosting : what the frosting of the cake is
     */
    public void setFrosting(String frosting) {
        this.frosting = frosting;
    }
    /**
     * get frosting.
     * @return frosting : what the frosting of the cake is
     */
    public String getFrosting() {
        return frosting;
    }
}
