/**
 * HW04 : Pet.java .
 * @author kalanidissanayake
 * @version 1
 */
public abstract class Pet implements Comparable<Pet> {
    private int health;
    private int attack;
    /**
     * constructs Pet object (2 args).
     * @param health : an int representing the health points for this pet
     * @param attack : an int representing the  attack points for this pet
     */
    public Pet(int health, int attack) {
        if (health <= 0) {
            health = 1;
        }
        setHealth(health);
        if (attack < 0) {
            attack = 0;
        }
        setAttack(attack);
    }
    /**
     * has the pet fainted?
     * @return a boolean representing whether this pet has fainted
     */
    public boolean hasFainted() {
        return (health <= 0);
    }
    /**
     * decreases health when attacked.
     * @param damage : an int representing the amount of damage this pet is being attacked for
     */
    public void getAttacked(int damage) {
        health -= damage;
    }
    /**
     * attack another pet.
     * @param another : a pet that will be attacked by this pet.
     */
    public void attackPet(Pet another) {
        another.getAttacked(attack);
    }
    /**
     * creates a string representation of the pet.
     * @return a string representation of pet
     */
    public String toString() {
        return (attack + "/" + health);
    }
    /**
     * overrides comparable interface's method of same name.
     * @param p : another Pet that is being compared to this object
     * @return an int value representing the difference between the two Pets (health and attack)
     */
    public int compareTo(Pet p) {
        int result;
        if (p != null) {
            if (this.equals(p)) {
                result = 0;
            } else {
                result = (this.health + this.attack) - (p.health + p.attack);
            }
        } else {
            result = 5;
        }
        return result;
    }
    /**
     * get health.
     * @return health : an int representing the health points for this pet
     */
    public int getHealth() {
        return health;
    }
    /**
     * get attack.
     * @return attack : an int representing the  attack points for this pet
     */
    public int getAttack() {
        return attack;
    }
    /**
     * sets health.
     * @param health : an int representing the health points for this pet
     */
    public void setHealth(int health) {
        this.health = health;
    }
    /**
     * set attack.
     * @param attack : an int representing the  attack points for this pet
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }
}
