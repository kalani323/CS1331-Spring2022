import java.util.ArrayList;
/**
 * HW05: Store.java .
 * @author kalanidissanayake
 * @version 1
 */
public class Store {
    private String name;
    private ArrayList<Dessert> desserts;
    /**
     * constructs store.
     * @param name : name of store
     */
    public Store(String name) {
        setName(name);
        setDesserts(new ArrayList<Dessert>());
    }
    /**
     * adds a dessert object to the back of the arraylist.
     * @param d : dessert object (that is needed to be added)
     */
    public void addDessert(Dessert d) {
        desserts.add(d);
    }
    /**
     * removes the first instance of a dessert object from the arraylist.
     * @param d : dessert object (that is needed to be removed)
     * @return the object that is being removed or null if the dessert is not found.
     */
    public Dessert removeDessert(Dessert d) {
        Dessert objectBeingRemoved = null;
        boolean isRemoved = false;
        for (int i = 0; i < desserts.size() && !isRemoved; i++) {
            if (desserts.get(i).equals(d)) {
                objectBeingRemoved = desserts.get(i);
                desserts.remove(i);
                isRemoved = true;
            }
        }
        return objectBeingRemoved;
    }
    /**
     * finds the dessert in desserts that has the same sweetness and flavor. (binary search)
     * @param d : dessert that we want to find in desserts
     * @return the dessert that has the same sweetness and flavor, as d, in desserts
     */
    public Dessert findDessert(Dessert d) {
        Dessert dessertReturned = null;
        int i = 0;
        int j = desserts.size() - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (desserts.get(mid).equals(d)) {
                dessertReturned = desserts.get(mid);
                j = i;
            }
            if (desserts.get(mid).compareTo(d) > 0) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return dessertReturned;
    }
    /**
     * sorts the arrayList in ascending order based on sweetness and flavor.
     */
    public void sortStore() {
        for (int i = 0; i < desserts.size(); i++) {
            for (int j = desserts.size() - 1; j > i; j--) {
                if (desserts.get(i).compareTo(desserts.get(j)) > 0) {
                    Dessert tmp = desserts.get(i);
                    desserts.set(i, desserts.get(j));
                    desserts.set(j, tmp);
                }
            }
        }
    }
    /**
     * finds the number of desserts in the store that are greater or equal to the dessert thats passed in.
     * @param d : dessert object
     * @return the number of desserts in the store that are greater or equal to the dessert thats passed in
     */
    public int checkStore(Dessert d) {
        int numSweets = 0;
        for (int i = 0; i < desserts.size(); i++) {
            if (desserts.get(i).compareTo(d) >= 0) {
                numSweets++;
            }
        }
        return numSweets;
    }
    /**
     * set Name.
     * @param name : name of store
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * set desserts.
     * @param desserts : an arrayList of type dessert
     */
    public void setDesserts(ArrayList<Dessert> desserts) {
        this.desserts = desserts;
    }
    /**
     * get name.
     * @return name : name of store
     */
    public String getName() {
        return name;
    }
    /**
     * get dessert.
     * @return desserts : an arrayList of type dessert
     */
    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }
}
