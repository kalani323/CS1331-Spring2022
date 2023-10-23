/**
 * HW06 : ComputerScience.java .
 * @author kalanidissanayake
 * @version 1
 */
public class ComputerScience extends Course {
    private String language;
    /**
     * constructs ComputerScience.
     * @param courseName : the name of the course
     * @param id : the course identification number
     * @param professorName : the name of the professor teaching the course
     * @param language : the language in which the class is taught
     */
    public ComputerScience(String courseName, int id, String professorName, String language) {
        super(courseName, id, professorName);
        setLanguage(language);
    }
    /**
     * creates a String representation of ComputerScience.
     * @return String representation of ComputerScience
     */
    public String toString() {
        return ("ComputerScience," + super.toString() + "," + language);
    }
    /**
     * compares if one object is equal to this ComputerScience object.
     * @param o : object o (object being compared)
     * @return true (if the object equals this ComputerScience) or
     * false (if the object is not equal to this ComputerScience)
     */
    public boolean equals(Object o) {
        if (o instanceof ComputerScience) {
            ComputerScience oCS = (ComputerScience) o;
            return (super.equals(oCS) && this.language.equals(oCS.language));
        }
        return false;
    }
    /**
     * set the language (throws InvalidArgumentException if invalid).
     * @param language : the language in which the class is taught
     */
    public void setLanguage(String language) {
        if (language == null || language.equals("")) {
            throw new IllegalArgumentException();
        } else {
            this.language = language;
        }
    }
}
