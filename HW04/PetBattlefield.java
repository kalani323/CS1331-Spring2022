/**
 * HW04 : PetBattlefield.java .
 * @author kalanidissanayake
 * @version 1
 */
public class PetBattlefield {
    private Pet[] firstTeam;
    private Pet[] secondTeam;
    /**
     * constructs PetBattleField (2 args).
     * @param firstTeam : an array of pets
     * @param secondTeam : an array of pets
     */
    public PetBattlefield(Pet[] firstTeam, Pet[] secondTeam) {
        if (firstTeam.length > 5) {
            firstTeam = new Pet[5];
        }
        if (secondTeam.length > 5) {
            secondTeam = new Pet[5];
        }
        setFirstTeam(firstTeam);
        setSecondTeam(secondTeam);
    }
    /**
     * creates a string representation of the skunk.
     * @return a string representation of skunk.
     */
    public String toString() {
        String statement = "";
        statement += "First Team: ";
        for (int i = 0; i < firstTeam.length; i++) {
            if (firstTeam[i] == null) {
                statement += "Empty";
            } else {
                statement += firstTeam[i].toString();
            }
            statement += ", ";
        }
        statement = statement.substring(0, statement.length() - 2);
        statement += " vs Second Team: ";
        for (int j = 0; j < secondTeam.length; j++) {
            if (secondTeam[j] == null) {
                statement += "Empty";
            } else {
                statement += secondTeam[j].toString();
            }
            statement += ", ";
        }
        statement = statement.substring(0, statement.length() - 2);
        return statement;
    }
    /**
     * compares the teams and guesses which one will win.
     */
    public void compareTeams() {
        int i = 0;
        int j = 0;
        int total = 0;
        while (i < firstTeam.length && j < secondTeam.length) {
            if (firstTeam[i] != null) {
                total += firstTeam[i].compareTo(secondTeam[j]);
            }
            i++;
            j++;
        }
        if (total == 0) {
            System.out.println("It is an even match.");
        } else if (total > 0) {
            System.out.println("The first team will probably win.");
        } else if (total < 0) {
            System.out.println("The second team will probably win.");
        }
    }
    /**
     * start a battle until at least one team has only fainted pets.
     */
    public void battle() {
        int i = 0;
        int j = 0;
        int team1points = 0;
        int team2points = 0;
        while (i < firstTeam.length && j < secondTeam.length) {
            if (firstTeam[i] == null) {
                i++;
            }
            if (secondTeam[j] == null) {
                j++;
            }
            firstTeam[i].attackPet(secondTeam[j]);
            secondTeam[j].attackPet(firstTeam[i]);
            if (firstTeam[i].hasFainted()) {
                firstTeam[i] = null;
                i++;
                team2points++;
            }
            if (secondTeam[j].hasFainted()) {
                secondTeam[j] = null;
                j++;
                team1points++;
            }
        }
        if (team1points > team2points) {
            System.out.println("The first team won!");
        } else if (team1points < team2points) {
            System.out.println("The second team won!");
        } else {
            System.out.println("Both teams fainted");
        }
    }
    /**
     * set firstTeam.
     * @param firstTeam : an array of pets
     */
    public void setFirstTeam(Pet[] firstTeam) {
        this.firstTeam  = firstTeam;
    }
    /**
     * set SecondTeam.
     * @param secondTeam : an array of pets
     */
    public void setSecondTeam(Pet[] secondTeam) {
        this.secondTeam  = secondTeam;
    }
    /**
     * main method, used to test functionality.
     * @param args : command line arguments
     */
    public static void main(String[] args) {
        Pet[] pets1 = {new Skunk(), null, new Turtle(), new Hippo()};
        Pet[] pets2 = {new Skunk(), new Turtle(), new Turtle(), new Skunk()};
        PetBattlefield battlefield = new PetBattlefield(pets1, pets2);
        battlefield.compareTeams();
        battlefield.battle();
        System.out.println(battlefield.toString());
    }
}
