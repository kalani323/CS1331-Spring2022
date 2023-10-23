/**
 * HW05: Dessert.java .
 * @author kalanidissanayake
 * @version 1
 */
public class Dessert implements Comparable<Dessert> {
    private String flavor;
    private double sweetness;
    /**
     * constructs Dessert (2 args).
     * @param flavor : flavor of the dessert
     * @param sweetness : sweetness of the dessert
     */
    public Dessert(String flavor, double sweetness) {
        setFlavor(flavor);
        setSweetness(sweetness);
    }
    /**
     * constructs Dessert (no args).
     */
    public Dessert() {
        this("vanilla", 25.0);
    }
    /**
     * creates a string representation of Dessert.
     * @return returns a string representation of Dessert
     */
    public String toString() {
        return String.format("This is a %s dessert with a sweetness of %.2f.",
                flavor, sweetness);
    }
    /**
     * compares to objects to see if they are equal or not.
     * @param o : another Object
     * @return true (if objects have the same flavor and sweetness)
     * or false (if objects DONT have the same flavor and sweetness)
     */
    public boolean equals(Object o) {
        if (o instanceof Dessert) {
            Dessert oD = (Dessert) o;
            return ((this.getFlavor().equals(oD.getFlavor()))
                    && (this.getSweetness() == oD.getSweetness()));
        } else {
            return false;
        }
    }
    /**
     * compares to objects to see if they are equal or not.
     * @param d : another dessert that is being compared to THIS dessert
     * @return int of the difference
     */
    public int compareTo(Dessert d) {
        int result = 0;
        if (this.sweetness > d.getSweetness() || this.sweetness < d.getSweetness()) {
            return (int) (this.sweetness - d.getSweetness());
        } else {
            return (this.compareTo(d));
        }
    }
    /**
     * sets flavor.
     * @param flavor : flavor of the dessert
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    /**
     *  set sweetness.
     * @param sweetness : sweetness of the dessert
     */
    public void setSweetness(double sweetness) {
        this.sweetness = sweetness;
    }
    /**
     * get flavor.
     * @return flavor : flavor of the dessert
     */
    public String getFlavor() {
        return flavor;
    }
    /**
     * get sweetness.
     * @return sweetness : sweetness of the dessert
     */
    public double getSweetness() {
        return sweetness;
    }
}
