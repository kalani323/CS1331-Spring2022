/**
 * HW04 : Skunk.java .
 * @author kalanidissanayake
 * @version 1
 */
public class Skunk extends Pet {
    private int numSpray;
    /**
     * constructs Skunk object (3 args).
     * @param health : an int representing the health points for this pet
     * @param attack : an int representing the  attack points for this pet
     * @param numSpray : an int representing the number of times the Skunk can spray
     */
    public Skunk(int health, int attack, int numSpray) {
        super(health, attack);
        if (numSpray < 0) {
            numSpray = 0;
        }
        setNumSpray(numSpray);
    }
    /**
     * constructs Skunk object (no args).
     */
    public Skunk() {
        this(5, 3, 1);
    }
    /**
     * sprays another pet.
     * @param another : the pet that will be sprayed by the skunk
     */
    public void sprayPet(Pet another) {
        if (numSpray != 0) {
            another.setHealth((int) (another.getHealth() * (((double) 2) / ((double) 3))));
            another.setAttack((int) (another.getAttack() * (((double) 2) / ((double) 3))));
            numSpray--;
        }
    }
    /**
     * attack another pet.
     * @param another : a pet that will be attacked by this pet.
     */
    public void attackPet(Pet another) {
        if (numSpray != 0) {
            sprayPet(another);
        }
        another.getAttacked(this.getAttack());
    }
    /**
     * creates a string representation of the skunk.
     * @return a string representation of skunk.
     */
    public String toString() {
        return ("Skunk:" + super.toString() + "/" + numSpray);
    }
    /**
     * get numSpray.
     * @return numSpray : an int representing the number of times the Skunk can spray
     */
    public int getNumSpray() {
        return numSpray;
    }
    /**
     * set numSpray.
     * @param numSpray : an int representing the number of times the Skunk can spray
     */
    public void setNumSpray(int numSpray) {
        this.numSpray = numSpray;
    }
}
