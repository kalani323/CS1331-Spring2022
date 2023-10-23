/**
 * HW04 : Hippo.java .
 * @author kalanidissanayake
 * @version 1
 */
public class Hippo extends Pet {
    private int buff;
    /**
     * constructs Hippo object (3 args).
     * @param health : an int representing the health points for this pet
     * @param attack : an int representing the  attack points for this pet
     * @param buff : an int representing the buff, or increase to this Hippo's health and attack
     */
    public Hippo(int health, int attack, int buff) {
        super(health, attack);
        setBuff(buff);
    }
    /**
     * constructs Hippo object (no args).
     */
    public Hippo() {
        this(7, 4, 2);
    }
    /**
     * increases health and attack by buff.
     */
    public void getBuffed() {
        setHealth(getHealth() + buff);
        setAttack(getAttack() + buff);
    }
    /**
     * attack another pet.
     * @param another : a pet that will be attacked by this pet.
     */
    public void attackPet(Pet another) {
        another.getAttacked(this.getAttack());
        if (another.hasFainted()) {
            this.getBuffed();
        }
    }
    /**
     * creates a string representation of the hippo.
     * @return a string representation of hippo.
     */
    public String toString() {
        return ("Hippo:" + super.toString() + "/" + buff);
    }
    /**
     * set buff.
     * @param buff : an int representing the buff, or increase to this Hippo's health and attack
     */
    public void setBuff(int buff) {
        if (buff < 0) {
            buff = 0;
        }
        this.buff = buff;
    }
    /**
     * get buff.
     * @return buff : an int representing the buff, or increase to this Hippo's health and attack
     */
    public int getBuff() {
        return buff;
    }
}
