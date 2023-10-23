/**
 * HW04 : Turtle.java .
 * @author kalanidissanayake
 * @version 1
 */
public class Turtle extends Pet  {
    private boolean melonArmor;
    /**
     * constructs Turtle object (3 args).
     * @param health : an int representing the health points for this pet
     * @param attack : an int representing the  attack points for this pet
     * @param melonArmor : a boolean representing whether this turtle pocesses melon armor,
     * the ability to block 20 damage from an incoming attack
     */
    public Turtle(int health, int attack, boolean melonArmor) {
        super(health, attack);
        this.melonArmor = melonArmor;
    }
    /**
     * constructs Turtle object (no args).
     */
    public Turtle() {
        this(4, 2, true);
    }
    /**
     * decreases health when attacked.
     * @param damage : an int representing the amount of damage this pet is being attacked for
     */
    public void getAttacked(int damage) {
        if (melonArmor) {
            setHealth(getHealth() - (damage - 20));
        } else {
            setHealth(getHealth() - damage);
        }
        melonArmor = false;
    }
    /**
     * creates a string representation of the turtle.
     * @return a string representation of turtle.
     */
    public String toString() {
        return ("Turtle:" + super.toString() + "/" + melonArmor);
    }
    /**
     * get melonArmor.
     * @return melonArmor : a boolean representing whether this turtle pocesses melon armor,
     * the ability to block 20 damage from an incoming attack
     */
    public boolean getMelonArmor() {
        return melonArmor;
    }
    /**
     * set melonArmor.
     * @param melonArmor : a boolean representing whether this turtle pocesses melon armor,
     * the ability to block 20 damage from an incoming attack
     */
    public void setMelonArmor(boolean melonArmor) {
        this.melonArmor = melonArmor;
    }
}
