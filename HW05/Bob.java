/**
 * HW05: Bob.java .
 * @author kalanidissanayake
 * @version 1
 */
public class Bob {
    /**
     * checks if the sweetness and flavors of each individual dessert object in Store 1 must all
     * be present in Store 2.
     * @param s1 : store 1
     * @param s2 : store 2
     * @return Return true if this is the case. False if otherwise.
     */
    public static boolean compareStores(Store s1, Store s2) {
        boolean response = true;
        s1.sortStore();
        for (int i = 0; i < s1.getDesserts().size(); i++) {
            Dessert dFind = s2.findDessert(s1.getDesserts().get(i));
            if (dFind == null) {
                response = false;
            }
        }
        return response;
    }
    /**
     * is the desert in the store? .
     * @param s : store where bob is looking for the dessert
     * @param d : the dessert bob is looking for
     * @return true (if desert is found in store) or false (if desert is NOT found in store)
     */
    public static boolean shop(Store s, Dessert d) {
        s.sortStore();
        Dessert dFind = s.findDessert(d);
        if (dFind != null) {
            return true;
        }
        return false;
    }
}
