// KALANI DISSANAYAKE
// PE03

import java.util.Random;
public class BendingBattlefield {
    public static void main(String[] args) {
        Random rand = new Random();
        int numHeroes =  rand.nextInt(100 - 50 + 1) + 50;
        double boomerangBoost = 7;

        do {
            boomerangBoost = Math.round(((rand.nextDouble() * (7 - 3)) + 3) * 100) / 100;
        } while (boomerangBoost == 7); // in the range [3, 7)

        double averageFirePower = 0;
        double averageFireHealth = 0;
        double averageAlliancePower = 0;
        double averageAllianceHealth = 0;

        System.out.println("Selecting " + numHeroes + " heroes.");

        int numFire = 0;
        int numAlliance = 0;

        for (int i = 0; i < numHeroes; i++) {
            BendingType heroType  = BendingType.values()[rand.nextInt(5)];
            double health = 50;
            do {
                health = Math.round(((rand.nextDouble() * (150 - 50)) + 50) * 100) / 100;
            } while (boomerangBoost == 50); // in the range [50,150)
            double power = 40;
            do {
                power = Math.round(((rand.nextDouble() * (120 - 40 + 1)) + 40) * 100) / 100; // in the range (40,120]
            } while (power == 40);

            if (heroType == BendingType.FIRE) {
                averageFireHealth += health;
                averageFirePower += power;
                numFire++;
            } // end fire-if
            if (heroType == BendingType.NON_BENDER) {
                power *= boomerangBoost;
            } // end NON_BENDER-if
            if (heroType == BendingType.NON_BENDER || heroType == BendingType.AIR
                || heroType == BendingType.WATER || heroType == BendingType.EARTH) {
                averageAllianceHealth += health;
                averageAlliancePower += power;
                numAlliance++;
            } // end (NON_BENDER, AIR, WATER, OR EARTH)-if
            System.out.println(heroType + " has been summoned by his army, adding "
                + power + " power and " + health + " health to the army.");
        } //end for loop

        averageAlliancePower = (averageAlliancePower / numAlliance);
        averageAllianceHealth = (averageAllianceHealth / numAlliance);
        averageFirePower = (averageFirePower / numFire);
        averageFireHealth = (averageFireHealth / numFire);

        System.out.printf("The Fire Nation has an average of %.2f power and %.2f health.\n",
            averageFirePower, averageFireHealth);
        System.out.printf("The Alliance has an average of %.2f power and %.2f health.\n",
            averageAlliancePower, averageAllianceHealth);

        if ((2 * averageFirePower + 3 * averageFireHealth) > (2 * averageAlliancePower + 3 * averageAllianceHealth)) {
            System.out.println("The Fire Nation won!");
        } // end if (fire nation won)
        if ((2 * averageFirePower + 3 * averageFireHealth) < (2 * averageAlliancePower + 3 * averageAllianceHealth)) {
            System.out.println("The Alliance won!");
        }
        if ((2 * averageFirePower + 3 * averageFireHealth) == (2 * averageAlliancePower + 3 * averageAllianceHealth)) {
            System.out.println("The Alliance won!");
        }


    } // end main
} // end class
