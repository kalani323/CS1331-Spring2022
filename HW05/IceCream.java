/**
 * HW05: IceCream.java .
 * @author kalanidissanayake
 * @version 1
 */
public class IceCream extends Dessert {
    private int scoops;
    private boolean cone;
    /**
     * constructs Dessert (3 args).
     * @param flavor : flavor of the dessert
     * @param sweetness : sweetness of the dessert
     * @param scoops : the number of scoops of ice cream you get
     * @param cone : represents if the ice cream has a cone
     */
    public IceCream(String flavor, double sweetness, int scoops, boolean cone) {
        super(flavor, sweetness);
        setScoops(scoops);
        setCone(cone);
    }
    /**
     * constructs Dessert (2 args).
     * @param scoops : the number of scoops of ice cream you get
     * @param cone : represents if the ice cream has a cone
     */
    public IceCream(int scoops, boolean cone) {
        this("vanilla", 45.0, scoops, cone);
    }
    /**
     * constructs Dessert (0 args).
     */
    public IceCream() {
        this("vanilla", 45.0, 1, false);
    }
    /**
     * creates a string representation of Ice cream.
     * @return returns a string representation of Ice cream
     */
    public String toString() {
        String statement = "";
        statement += String.format("This is a %s ice cream with %d scoops and ",
                getFlavor(), getScoops());
        if (getCone()) {
            statement += "has a cone";
        } else {
            statement += "does not have a cone";
        }
        return statement;
    }
    /**
     * compares to objects to see if they are equal or not.
     * @param o : another Object
     * @return true (if objects have the same flavor, sweetness, scoops, and if they have a cone or not)
     * or false (if objects DONT have the same flavor, sweetness, scoops, and if they have a cone or not)
     */
    public boolean equals(Object o) {
        if (o instanceof IceCream) {
            IceCream oC = (IceCream) o;
            return ((this.getFlavor().equals(oC.getFlavor()))
                    && (this.getSweetness() == oC.getSweetness())
                    && (this.getScoops() == oC.getScoops())
                    && (this.getCone() == oC.getCone()));
        } else {
            return false;
        }
    }
    /**
     * set Scoops.
     * @param scoops : the number of scoops of ice cream you get
     */
    public void setScoops(int scoops) {
        this.scoops = scoops;
    }
    /**
     * set Cone.
     * @param cone : represents if the ice cream has a cone
     */
    public void setCone(boolean cone) {
        this.cone = cone;
    }
    /**
     * get Scoops.
     * @return scoops : the number of scoops of ice cream you get
     */
    public int getScoops() {
        return scoops;
    }
    /**
     * get Cone.
     * @return cone : represents if the ice cream has a cone
     */
    public boolean getCone() {
        return cone;
    }
}
